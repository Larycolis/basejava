package com.basejava.webapp.storage;

import com.basejava.webapp.exeption.ExistStorageException;
import com.basejava.webapp.exeption.NotExistStorageException;
import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.sql.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLStorage implements Storage {
    public final ConnectionFactory connectionFactory;
    // public final SqlHelper sqlHelper;

    public SQLStorage(String dbUrl, String dbUser, String dbPassword) {
        connectionFactory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @Override
    public void clear() {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM resume")) {
            ps.execute();
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void save(Resume resume) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO resume (uuid, full_name) VALUES (?,?)")) {
            ps.setString(1, resume.getUuid());
            ps.setString(2, resume.getFullName());
            try {
                ps.execute();
            } catch (SQLException e) {
                throw new ExistStorageException(resume.getUuid());
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void update(Resume resume) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE resume SET full_name=? WHERE uuid=?")) {
            ps.setString(1, resume.getFullName());
            ps.setString(2, resume.getUuid());
            int rs = ps.executeUpdate();
            if (rs == 0) {
                throw new NotExistStorageException(resume.getUuid());
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public Resume get(String uuid) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM resume r WHERE r.uuid=?")) {
            ps.setString(1, uuid);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid, rs.getString("full_name"));
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void delete(String uuid) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM resume r WHERE r.uuid=?")) {
            ps.setString(1, uuid);
            boolean rs = ps.execute();
            if (!rs) {
                throw new NotExistStorageException(uuid);
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> results = new ArrayList<>();
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM resume ORDER BY uuid")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Resume resume = new Resume(rs.getString("uuid").trim(), rs.getString("full_name").trim());
                results.add(resume);
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
        return results;
    }

    @Override
    public int size() {
        int count = 0;
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM resume")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
        return count;
    }
}
