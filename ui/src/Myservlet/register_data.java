package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class register_data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取用户的账号与密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String nickname=request.getParameter("nickname");
        String UserorAdmin=request.getParameter("UserorAdmin");
        System.out.println("user:"+username);
        System.out.println("password:"+password);
        System.out.println("classsify:"+UserorAdmin);
        System.out.println("nickname:"+nickname);
        if (username.equals("")||password.equals("")||nickname.equals("")){
            request.setAttribute("error","用户名、密码或昵称不能为空！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }else {
            if (UserorAdmin.equals("user")) {
                user_sign usersign = new user_sign(username, password, nickname);
                if (usersign.count == 1) {
                    request.setAttribute("error", "成功注册，请登录！");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "用户名已存在，请重新注册");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
            } else {
                admin_sign adminsign = new admin_sign(username, password);
                if (adminsign.count == 1) {
                    request.setAttribute("error", "成功注册，请登录！");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "用户名已存在，请重新注册");
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
            }
        }
    }
}
