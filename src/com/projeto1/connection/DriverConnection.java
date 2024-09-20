package com.projeto1.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverConnection {

    private static DriverConnection INSTANCE;

    public static DriverConnection getInstance() {
        if (INSTANCE == null) INSTANCE = new DriverConnection();
        return INSTANCE;
    }

    private String host;
    private String user;
    private String password;

    private DriverConnection() {

    }

    public Connection startConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(host, user, password);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
