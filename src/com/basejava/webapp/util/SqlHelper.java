package com.basejava.webapp.util;

import com.basejava.webapp.exeption.StorageException;
import com.basejava.webapp.sql.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    private final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public <T> T runCode(String setString) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(setString)) {
            return null; // тут должен выполняться команда SQL в зависимости от операции CRUD
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}
