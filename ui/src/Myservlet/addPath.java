package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "addPath", value = "/addPath")
public class addPath extends HttpServlet {
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
    String result=null;
    public int count=0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count=0;
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        String length=request.getParameter("length");
        System.out.println("start:"+start);
        System.out.println("end:"+end);
        System.out.println("length:"+length);
        if (start.equals("")||end.equals("")||length.equals("")){
            request.setAttribute("tips","请输入完整信息！");
            request.getRequestDispatcher("/addPath.jsp").forward(request, response);
        }else{
            JnameTranslateJno tojno1=new JnameTranslateJno(start);
            JnameTranslateJno tojno2=new JnameTranslateJno(end);
            if(tojno1.isIn==true&& tojno2.isIn==true){
                System.out.println(tojno1.Jno);
                System.out.println(tojno2.Jno);
                int _Jno1=tojno1.Jno-1;
                int _Jno2=tojno2.Jno-1;
                try {
                    //注册驱动
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //连接数据库
                    conn2 = DriverManager.getConnection(url,this.user,psd);
                    String sql1="INSERT into distance(Jno1,Jno2,distance) values(?,?,?)";
                    //sql2后面会用来查看路径是否存在
                    String sql2="select * from distance where ((Jno1='"+start+"'and Jno2='\"+end+\"')or(Jno1='\"+end+\"'and Jno2='\\\"+start+\\\"'))";
                    stmt=conn2.createStatement();
                    rs2=stmt.executeQuery(sql2);
                    if(!rs2.next()){
                        ps2 = conn2.prepareStatement(sql1);
                        ps2.setInt(1,_Jno1);
                        ps2.setInt(2,_Jno2);
                        ps2.setString(3,length);
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
                    if(count==1){
                        request.setAttribute("tips","添加路径成功！");
                        request.getRequestDispatcher("/addPath.jsp").forward(request, response);
                    }else{
                        request.setAttribute("tips","该路径已存在");
                        request.getRequestDispatcher("/addPath.jsp").forward(request, response);
                    }
                }
            }else{
                request.setAttribute("tips","输入地点不存在");
                request.getRequestDispatcher("/addPath.jsp").forward(request, response);
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
