package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "searchPlace", value = "/searchPlace")
public class searchPlace extends HttpServlet {
    String result = "没有找到该地点";
    private String url="jdbc:mysql://localhost:3306/school_navigation";
    private String user="root";
    private String psd="123456";

    Connection conn1 =null;
    PreparedStatement ps1 =null;
    ResultSet rs1 =null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search=request.getParameter("search");
        System.out.println("search:"+search);
        HttpSession session = request.getSession(true);
        String username=(String) session.getAttribute("username");
        int flag=0;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn1 =DriverManager.getConnection(url,this.user,psd);
            //数据库预编译操作对象获取
            String sql="select * from scenic where Jname=?";
            ps1 = conn1.prepareStatement(sql);
            ps1.setString(1,search);
            //执行sql语句
            rs1=ps1.executeQuery();
            if(rs1.next()){
                result=rs1.getString("Jmessage");
                flag=1;
            }
            System.out.println(result);
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
        if(flag==1){
            request.setAttribute("information", result);
            request.setAttribute("place",search);
            request.getRequestDispatcher("/informationSearch.jsp").forward(request, response);
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
                String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
                String user = "root";
                String password= "123456";
                Connection conn = DriverManager.getConnection(url, user, password);
                String sql = "insert into searchrecords(Cacc,Jname) " +
                        "values('"+username+"','"+search+"')";  //*****
                Statement stmt = conn.createStatement();// 创建statement
                int count = stmt.executeUpdate(sql);// 执行sql
                String message = "插入失败";
                if(count>0){
                    message = "插入成功";
                }
                System.out.println(message);//判断是否插入成功
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }else{
            request.setAttribute("information", "没有该地点，请重新输入！");
            request.setAttribute("place",search);
            request.getRequestDispatcher("/informationSearch.jsp").forward(request, response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}