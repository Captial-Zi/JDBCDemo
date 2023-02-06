package com.msb.jdbc.base2;


import com.msb.jdbc.base1.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {
    public static void main(String[] args) throws SQLException {
        System.out.println(login("guowa' or '1' = '1"));   //sql注入
    }
    public static boolean login(String username) throws SQLException {
        //做登录
        Connection connection = JDBCUtils.getConnection();
        //Statement
        Statement stmt = connection.createStatement();

        String sql = "select * from emp where ename = '" + username + "'";

        System.out.println(sql);

        ResultSet resultSet = stmt.executeQuery(sql);

        return resultSet.next();

    }
}
