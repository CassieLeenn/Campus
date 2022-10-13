package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class login_data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取用户的账号与密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String UserorAdmin=request.getParameter("UserorAdmin");
        if (username.equals("")||password.equals("")){
            request.setAttribute("error","用户名或密码不能为空！");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/").forward(request, response);
        }else {
            if (UserorAdmin.equals("user")) {
                user_login userlogin = new user_login(username, password);
                if (userlogin.isIn == true) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);
                    request.setAttribute("username", username);
                    showNotice notice1=new showNotice();
                    notice1.showNotice();
                    String Notice=notice1.notice;
                    System.out.println(Notice);
                    session.setAttribute("notice",Notice);
                    request.getRequestDispatcher("/showNotice.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "用户名或密码错误！");
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/").forward(request, response);
                    //PrintWriter out=response.getWriter();
                    //out.print("<script language='javascript'>alert('用户名或密码错误');window.location.href='index.jsp';</script>");
                    //response.sendRedirect("index.jsp");
                }
            } else {
                admin_login adminlogin = new admin_login(username, password);
                if (adminlogin.isIn == true) {
                    scenceRecommend recommend=new scenceRecommend();
                    recommend.Recommend_sjk();
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);
                    request.setAttribute("username", username);
                    showNotice notice1=new showNotice();
                    notice1.showNotice();
                    String Notice=notice1.notice;
                    System.out.println(Notice);
                    session.setAttribute("notice",Notice);
                    request.getRequestDispatcher("/addInformation.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "用户名或密码错误！");
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/").forward(request, response);
                    //PrintWriter out=response.getWriter();
                    //out.print("<script language='javascript'>alert('用户名或密码错误');window.location.href='index.jsp';</script>");
                    //response.sendRedirect("index.jsp");
                }
            }
        }
        System.out.println("user:"+username);
        System.out.println("password:"+password);
        System.out.println("classsify:"+UserorAdmin);
    }
}
