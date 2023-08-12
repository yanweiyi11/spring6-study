package com.spring.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Component
public class MyDataSource implements DataSource {

    // 使用Value注解注入的话，可以用在属性上，并且可以不提供setter方法
    @Value(value = "com.mysql.jdbc.mysql")
    private String driver;
    @Value("jdbc:mysql:///test")
    private String url;
    @Value("root")
    private String username;
    @Value("123456")
    private String password;

    @Override
    public String toString() {
        return "MyDataSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // public void setDriver(String driver) {
    //     this.driver = driver;
    // }
    //
    // public void setUrl(String url) {
    //     this.url = url;
    // }
    //
    // public void setUsername(String username) {
    //     this.username = username;
    // }
    //
    // public void setPassword(String password) {
    //     this.password = password;
    // }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
