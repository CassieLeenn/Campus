package Myservlet;
import java.sql.*;
import java.util.Scanner;

public class personInformation {
    Scanner scanner = new Scanner(System.in);
    public void personInformation(String id,String Cacc,int Sno,String Sname,String Sdept,String Scollege,String Sacademy) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接，mytest为数据库名称
            String user = "root";//用户名
            String password = "123456";//密码
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into student(Cacc,id,Sno,Sname,Sdept,Scollege,Sacademy) " + "values('" + Cacc + "','" + id + "','" + Sno + "','" + Sname + "','" + Sdept + "','" + Scollege + "','" + Sacademy + "')";
            // 根据页面的数据，生成插入sql语句
            Statement stmt = conn.createStatement();// 创建statement
            int count = stmt.executeUpdate(sql);// 执行sql
            String message = "插入失败";
            if (count > 0) {
                message = "插入成功";
            }
            System.out.println(message);//检查是否插入成功
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void personInformation1(String id,String Cacc,int Fno,String Fname,String Fjob,String Fdept){

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");// 加载驱动类
                String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接，mytest为数据库名称
                String user = "root";//用户名
                String password= "123456";//密码
                Connection conn = DriverManager.getConnection(url, user, password);
                String sql = "insert into faculty(Cacc,id,Fno,Fname,Fjob,Fdept) " + "values('"+Cacc+"','"+id+"','"+Fno+"','"+Fname+"','"+Fjob+"','"+Fdept+"')";
                // 根据页面的数据，生成插入sql语句
                Statement stmt = conn.createStatement();// 创建statement
                int count = stmt.executeUpdate(sql);// 执行sql
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
