import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * JDBC的开发步骤：
         *  1.加载驱动     Class.forName("驱动的全限定名)
         *  2.创建连接Connection DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","TIGER")
         *  3.创建一个发送sql的Statement对象  connection.createStatement()
         *  4.发送并执行sql  stmt.executeUpdate(sql)  执行  增删改
         *                  stmt.executeQuery(sql)   执行查询  返回一个ResultSet结果集
         *  5.解析结果集 ResultSet
         *    rs 的方法
         *       next(),将光标往下移动，如果有下一行数据，则返回true 否则返回false
         *       getInt(int index)
         *       getInt(字段名)
         *       getString()
         *       getDouble()
         *       getDate()
         *       getBoolean()
         *       getObject()
         *  6.释放资源
         *  rs.close()
         *  stmt.close()
         *  connection.close()
         */

        //加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //获取连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","TIGER");//
        //创建Statement 对象
        Statement stmt =  connection.createStatement();
        //发送并执行sql
        String sql = "select * from dept";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int deptno = rs.getInt(1);
            String dname = rs.getString(2);
            String loc = rs.getString(3);
            System.out.println(deptno+"\t" + dname + "\t" + loc);
        }
        //释放资源
        rs.close();
        stmt.close();
        connection.close();
    }
}
