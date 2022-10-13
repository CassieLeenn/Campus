package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "addPlace", value = "/addPlace")
public class addPlace extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String place = request.getParameter("place");
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String information = request.getParameter("information");
        System.out.println("place:" + place);
        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println("information"+information);
        if(place.equals("")||x.equals("")||y.equals("")||information.equals("")){
            request.setAttribute("tip", "输入信息不能为空！");
            request.getRequestDispatcher("/addInformation.jsp").forward(request, response);
        }else {
            getScenicNum _getScenicNum = new getScenicNum();
            int Jno = _getScenicNum.Jno;
            scenicExist _JnameJudge = new scenicExist(place);
            if (_JnameJudge.isIn == true) {
                request.setAttribute("tip", "输入景点已存在！");
                request.getRequestDispatcher("/addInformation.jsp").forward(request, response);
            } else {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
                    String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
                    String user = "root";
                    String password= "123456";
                    Connection conn = DriverManager.getConnection(url, user, password);
                    String sql = "insert into scenic(Jno,Jname,Jmessage) " +
                            "values('"+(Jno+1)+"','"+place+"','"+information+"')";
                    String sql1 = "insert into location(Jno,Jname,Jx,Jy) " +
                            "values('"+(Jno+1)+"','"+place+"','"+x+"','"+y+"')";
                    Statement stmt = conn.createStatement();// 创建statement
                    int count = stmt.executeUpdate(sql);// 执行sql
                    String message = "插入失败";
                    Statement stmt1 = conn.createStatement();// 创建statement
                    int count1 = stmt.executeUpdate(sql1);// 执行sql
                    String message1 = "插入失败";
                    if(count>0&&count1>0){
                        request.setAttribute("tip", "景点添加成功!");
                        request.getRequestDispatcher("/addInformation.jsp").forward(request, response);
                    }
                    System.out.println(message);//判断是否插入成功
                }catch(Exception e2){
                    e2.printStackTrace();
                }
                request.setAttribute("tip", "景点添加失败!");
                request.getRequestDispatcher("/addInformation.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}