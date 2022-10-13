package Myservlet;
import java.sql.*;

public class showNotice {
    String notice;

    public void showNotice(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();// 创建statement
            String sql = "SELECT Ncontent FROM Notice WHERE Ntime=(SELECT max(Ntime) FROM Notice)";//查询Notice表最新一条公告
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){//展开结果集数据库
                notice=rs.getString("Ncontent");
                //System.out.println("公告："+rs.getString("Ncontent"));//输出公告
            }
            //notice=rs.getString("Ncontent");
            System.out.println(notice);
            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }
}
