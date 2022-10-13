package Myservlet;
import java.sql.*;

public class savePathHistory {
        //String Url = "jdbc:mysql://172.16.143.11/school_navigation";//数据库地址，Mysql 8.0以下使用
        String Url = "jdbc:mysql://localhost:3306/school_navigation";
        String name = "root";//数据库用户名
        String psd = "123456";//数据库密码

        //String jdbcName = "com.mysql.jdbc.Driver";//连接MySql数据库，Mysql 8.0以下用这条语句
        String jdbcName = "com.mysql.cj.jdbc.Driver";//Mysql 8.0以上用这条语句
        String sql = "insert into PathStorage values(?,?,?,?)";//数据库操作语句（插入）

        //将用户输入的起点，目的地，计算得到的路径，路程写入数据库表
        //start:起点（地点名称）、end:目的地（地点名称）、road:路径、waylength:路程
        public void save_PathHistory(int start, int end, String road, int waylenght) {
            Connection con = null;
            PreparedStatement pst = null;
            try {
                Class.forName(jdbcName);//向DriverManager注册自己
                con = DriverManager.getConnection(Url, name, psd);//与数据库建立连接
                pst = con.prepareStatement(sql);//用来执行SQL语句查询，对sql语句进行预编译处理
                pst.setInt(1, start);
                pst.setInt(2, end);
                pst.setString(3, road);
                pst.setDouble(4, waylenght);
                pst.executeUpdate();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {//执行与数据库建立连接需要抛出SQL异常
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally{
                // 关闭资源
                try{
                    if(pst!=null) pst.close();
                }catch(SQLException se2){
                }// 什么都不做
                try{
                    if(con!=null) con.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }
        }

}
