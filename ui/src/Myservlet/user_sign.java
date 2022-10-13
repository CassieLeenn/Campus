package Myservlet;

import java.sql.*;

public class user_sign {
    //172.16.143.11是主机，如果是本地主机直接用localhost   3306是mysql端口号   school_navigation是数据库名称
    private String url="jdbc:mysql://localhost:3306/school_navigation";
    //root是用户名
    private String user="root";
    //20010915lhy是密码
    private String psd="123456";
//    private String psd="123456";

    Connection conn2 =null;
    PreparedStatement ps2 =null;
    ResultSet rs2 =null;
    Statement stmt=null;
    public int count=0;

    public user_sign(String user, String password, String nickname){
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn2 = DriverManager.getConnection(url,this.user,psd);
            //数据库预编译操作对象获取
            //将value键值对插入到表Client中，账号Cacc，密码Cpw，其中密码用MD5加密存储。
            String sql1="INSERT into Client(Cacc,Cpw,nickname) values(?,MD5(?),?)";
//            sql2后面会用来查看账号Cacc是否在表Client中已经存在
            String sql2="select * from Client where Cacc='"+user+"'";

//            String sql1="INSERT into user(u_username,u_password,nickname) values(?,MD5(?),?)";
//            String sql2="select * from user where u_username='"+user+"'";
            stmt=conn2.createStatement();
            rs2=stmt.executeQuery(sql2);
            if(!rs2.next()){
                ps2 = conn2.prepareStatement(sql1);
                ps2.setString(1,user);
                ps2.setString(2,password);
                ps2.setString(3,nickname);
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
