package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "personal_s", value = "/personal_s")
public class teacherInformation_data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取用户的账号与密码
        String sno=request.getParameter("Sno");
        int Sno= Integer.parseInt(sno);
        String Sname=request.getParameter("Sname");
        String Sdept=request.getParameter("Sdept");
        String Scollege=request.getParameter("Scollege");
        String Sacademy=request.getParameter("Sacademy");
        if (sno.equals("")||Sname.equals("")||Sdept.equals("")||Scollege.equals("")||Sacademy.equals("")){
            request.setAttribute("error","请输入完整信息！");
            request.getRequestDispatcher("/studentInformation.jsp").forward(request, response);
        }else {
            HttpSession session = request.getSession(true);
            String username=(String)session.getAttribute("username");
            personInformation information=new personInformation();
            information.personInformation("学生",username,Sno,Sname,Sdept,Scollege,Sacademy);
            request.setAttribute("error","信息录用成功！");
            request.getRequestDispatcher("/studentInformation.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

}