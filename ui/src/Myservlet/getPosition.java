package Myservlet;

import java.util.HashMap;
import java.util.Map;
import java.sql.*;

public class getPosition {
    //读取像素点信息文件存入到相应的字典中,并返回到对应的数组字典
    public static Map[] readFileByLines(){
        //新建一个数组存储
        int length=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();// 创建statement
            String sql = "SELECT Jno FROM location WHERE Jno=(SELECT max(Jno) FROM location)";//查询Notice表最新一条公告
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){//展开结果集数据库
                length= Integer.parseInt(rs.getString("Jno"));
            }
            System.out.println("结点数量："+length);
            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e2){
            e2.printStackTrace();
        }
        //字典数组(已经存入node_info字典数组中)
        Map[] node_info=new Map[length];
        int i=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();// 创建statement
            String sql = "SELECT * FROM location";//查询Notice表最新一条公告
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){//展开结果集数据库
                node_info[i]=new HashMap();
                node_info[i].put("No",Integer.parseInt(rs.getString("Jno")));
                node_info[i].put("name",rs.getString("Jname"));
                node_info[i].put("x",Integer.parseInt(rs.getString("Jx")));
                node_info[i].put("y",Integer.parseInt(rs.getString("Jy")));
                i++;
            }
            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e2){
            e2.printStackTrace();
        }
        return  node_info;
    }

    //读取路口结点txt
    public static Map[] readCross(){
        //新建一个数组存储
        String[] temp=new String[11];

        //字典数组(已经存入node_info字典数组中)
        Map[] crossroad=new Map[temp.length];
        int i=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();// 创建statement
            String sql = "SELECT * FROM crossingnode";//查询Notice表最新一条公告
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){//展开结果集数据库
                crossroad[i]=new HashMap();
                crossroad[i].put("No",Integer.parseInt(rs.getString("Cno")));
                crossroad[i].put("x",Integer.parseInt(rs.getString("Cx")));
                crossroad[i].put("y",Integer.parseInt(rs.getString("Cy")));
                i++;
            }
            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e2){
            e2.printStackTrace();
        }

        return  crossroad;
    }

}
