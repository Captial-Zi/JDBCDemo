package com.msb.jdbc.base3;

import com.msb.jdbc.base1.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 模拟转账过程
 */
public class JDBCTransaction {
    /**
     *
     * @param src
     * @param des
     * @param money
     * @return
     */
    public boolean transfer(Integer src,Integer des,Double money) {
        //获取连接
        Connection conn = JDBCUtils.getConnection();
        //定义sql
        String sql = "upate emp set sal = sal + ? where empno = ?";
        PreparedStatement pstmt = null;
        //预编译
        try {
            pstmt = conn.prepareStatement(sql);
            //占位符赋值
            pstmt.setDouble(1,-money);
            pstmt.setInt(2,src);
            //增删改  返回的是  被影响的行数
            int i = pstmt.executeUpdate();
            int k = 10 / 0;
            //给目标账户添加
            pstmt.setDouble(1,money);
            pstmt.setInt(2,des);
            int i2 = pstmt.executeUpdate();
            if (i > 0 && i2 > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,pstmt);
        }
        return false;
    }
    public boolean transfer2(Integer src,Integer des,Double money) throws SQLException {
        //获取连接
        Connection conn = JDBCUtils.getConnection();
        //关闭自动提交事务
        conn.setAutoCommit(false);
        //定义sql
        String sql = "upate emp set sal = sal + ? where empno = ?";
        PreparedStatement pstmt = null;
        //预编译
        try {
            pstmt = conn.prepareStatement(sql);
            //占位符赋值
            pstmt.setDouble(1,-money);
            pstmt.setInt(2,src);
            //增删改  返回的是  被影响的行数
            int i = pstmt.executeUpdate();
            int k = 10 / 0;
            //给目标账户添加
            pstmt.setDouble(1,money);
            pstmt.setInt(2,des);
            int i2 = pstmt.executeUpdate();
            if (i > 0 && i2 > 0) {
                conn.commit();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("出故障了。。。。。。。。。。。");
            conn.rollback();
        } finally {
            JDBCUtils.close(conn,pstmt);
        }
        return false;
    }
}
