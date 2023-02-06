package com.msb.jdbc.base1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DeptDao {
    public boolean addDept(Dept dept) {
        String sql = "insert into dept values("+dept.getDeptno()+",'"+dept.getDname()+"','"+dept.getLoc()+"')";
        //获取连接
        Connection conn = JDBCUtils.getConnection();
        //创建Statement 对象
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            int i = stmt.executeUpdate(sql);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn,stmt);
        }
        return false;
    }
    public boolean updateDept(Dept dept) {
        return false;
    }
    public boolean deleteDept(Integer deptno) {
        return false;
    }
    public List<Dept> selectDept(){
        return null;
    }
}
