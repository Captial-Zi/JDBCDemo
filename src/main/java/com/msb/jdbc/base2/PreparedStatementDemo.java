package com.msb.jdbc.base2;

import com.msb.jdbc.base1.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
    public static void main(String[] args) throws SQLException {
        // ? 是一个占位符
        String sql = "select * from emp where ename = ? and deptno = ?";
        //获取连接
        Connection conn = JDBCUtils.getConnection();
        //获取PreparedStatement对象  预编译
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //给占位符赋值
        pstmt.setString(1,"SMITH");
        pstmt.setInt(2,20);

        //查询
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("ename") + "\t" + rs.getDouble("sal") + "\t" + rs.getString("job"));

        }
        //释放资源
        JDBCUtils.close(conn,pstmt,rs);
    }
}
