package Myservlet;

import java.sql.*;

public class getNickname {
    private String url="jdbc:mysql://localhost:3306/school_navigation";
    private String user="root";
    private String psd="123456";
    public String nickname;

    Connection conn1 =null;
    PreparedStatement ps1 =null;
    ResultSet rs1 =null;

    public getNickname(String name){
        try {

            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn1 =DriverManager.getConnection(url,this.user,psd);
            //数据库预编译操作对象获取
            String sql="select * from client where Cacc=?";
            ps1 = conn1.prepareStatement(sql);
            ps1.setString(1,name);
            //执行sql语句
            rs1=ps1.executeQuery();
            if(rs1.next()){
                nickname= rs1.getString("Nickname");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs1 !=null){
                try {
                    rs1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps1 !=null){
                try {
                    ps1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn1 !=null){
                try {
                    conn1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}