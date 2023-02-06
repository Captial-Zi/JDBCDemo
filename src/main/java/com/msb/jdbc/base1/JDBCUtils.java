package com.msb.jdbc.base1;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JDBCUtils {
    private JDBCUtils(){}
    private static Properties prop = new Properties();
    static {
        try {
            //读取配置文件
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            Class.forName(prop.getProperty("driverName"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(prop.getProperty("jdbcURL"),prop.getProperty("username"),prop.getProperty("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭资源
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        close(conn,stmt);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn,Statement stmt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
