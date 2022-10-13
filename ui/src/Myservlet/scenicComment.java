package Myservlet;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class scenicComment {
    public int count=0;
    public void scenicComment(int Jno,String Jname,String nickname,String Cacc,String comment){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取当前时间


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");// 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接，mytest为数据库名称
            String user = "root";//用户名
            String password= "123456";//密码
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into discussion(Jno,Jname,Dtime,Dcontent,nickname,Cacc) " + "values('"+Jno+"','"+Jname+"','"+formatter.format(date)+"','"+comment+"','"+nickname+"','"+Cacc+"')";  //******
            // 根据页面的数据，生成插入的评论sql语句
            Statement stmt = conn.createStatement();// 创建statement
            count = stmt.executeUpdate(sql);// 执行sql
            String message = "插入失败";
            if(count>0){
                message = "插入成功";
            }
            System.out.println(message);//检查是否插入成功
        }catch(Exception e2){
            e2.printStackTrace();
        }

    }

}
