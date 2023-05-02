package com.basejava.webapp.sql;

import com.basejava.webapp.exeption.ExistStorageException;
import com.basejava.webapp.exeption.StorageException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
Connection - создается сеанс соединения с базой данных
PreparedStatement отдает команду SQL
*/

public class SqlHelper {
    private final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void execute(String sqlQuery) {
        execute(sqlQuery, PreparedStatement::execute);
    }

    public <T> T execute(String sqlQuery, SqlQueryExecutor<T> sqlQueryExecutor) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sqlQuery)) {
            return sqlQueryExecutor.execute(ps);
        } catch (SQLException e) {
            String state = e.getSQLState();
            throw state.equals("23505") ? new ExistStorageException(null) : new StorageException(e);
        }
    }

    @FunctionalInterface
    public interface SqlQueryExecutor<T> {
        T execute(PreparedStatement ps) throws SQLException;
    }
}
