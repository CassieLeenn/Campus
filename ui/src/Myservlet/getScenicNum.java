package Myservlet;

import java.sql.*;

public class getScenicNum {
    public int Jno;


    public getScenicNum(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();// 创建statement
            String sql = "SELECT Jno FROM scenic WHERE Jno=(SELECT max(Jno) FROM scenic)";//查询Notice表最新一条公告
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){//展开结果集数据库
                Jno= Integer.parseInt(rs.getString("Jno"));
            }
            System.out.println(Jno);
            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e2){
            e2.printStackTrace();
        }

    }
}
