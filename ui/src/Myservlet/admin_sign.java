package Myservlet;

import java.sql.*;

public class admin_sign {
    private String url="jdbc:mysql://localhost:3306/school_navigation";
    private String user="root";
    private String psd="123456";

    Connection conn2 =null;
    PreparedStatement ps2 =null;
    ResultSet rs2 =null;
    Statement stmt=null;
    public int count=0;

    public admin_sign(String user, String password){
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn2 = DriverManager.getConnection(url,this.user,psd);
            //数据库预编译操作对象获取
            String sql1="INSERT into management(Macc,Mpw) values(?,MD5(?))";
//            String sql1="INSERT into administrator(a_username,a_password) values(?,?)";
            String sql2="select * from management where Macc='"+user+"'";
            stmt=conn2.createStatement();
            rs2=stmt.executeQuery(sql2);
            if(!rs2.next()){
                ps2 = conn2.prepareStatement(sql1);
                ps2.setString(1,user);
                ps2.setString(2,password);
                count=ps2.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs2 !=null){
                try {
                    rs2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps2 !=null){
                try {
                    ps2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn2 !=null){
                try {
                    conn2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
