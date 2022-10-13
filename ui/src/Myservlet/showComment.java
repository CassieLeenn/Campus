package Myservlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class showComment {
    List<String> nickname = new ArrayList<String>();
    List<String> time = new ArrayList<String>();
    List<String> comment = new ArrayList<String>();
    public void showComment(String Jname){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();// 创建statement
            String sql = "SELECT * FROM discussion WHERE Jname='"+Jname+"' ORDER BY Dtime desc LIMIT 0,5 ";//查询discussion表最新0~5条记录
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){//展开结果集数据库
                nickname.add(rs.getString("nickname"));
                comment.add(rs.getString("Dcontent"));
                time.add(rs.getString("DTime"));
                //System.out.println(rs.getTimestamp("Dtime")+" "+rs.getString("nickname")+":"+rs.getString("Dcontent"));//输出公告
            }
            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }
}
