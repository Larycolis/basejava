package com.basejava.webapp.sql;

import java.sql.Connection;
import java.sql.SQLException;

// интерфейс, который получает коннект к базе данных resumes
public interface ConnectionFactory {
    Connection getConnection() throws SQLException;
}