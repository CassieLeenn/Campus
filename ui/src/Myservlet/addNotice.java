package Myservlet;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class addNotice {
    public Boolean isIn=false;

    public void Notice(String Macc,String comment) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into Notice(Macc,Ntime,Ncontent) " +
                    "values('"+Macc+"','"+formatter.format(date)+"','"+comment+"')";  //*****
            Statement stmt = conn.createStatement();// 创建statement
            int count = stmt.executeUpdate(sql);// 执行sql
            String message = "插入失败";
            if(count>0){
                message = "插入成功";
                isIn=true;
            }
            System.out.println(message);//判断是否插入成功
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }
}
