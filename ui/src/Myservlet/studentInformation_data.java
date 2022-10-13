package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "personal_b", value = "/personal_b")
public class studentInformation_data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取用户的账号与密码
        String fno=request.getParameter("Fno");
        int Fno= Integer.parseInt(fno);
        String Fname=request.getParameter("Fname");
        String Fdept=request.getParameter("Fdept");
        String Fjob=request.getParameter("Fjob");
        if (fno.equals("")||Fname.equals("")||Fdept.equals("")||Fjob.equals("")){
            request.setAttribute("error","请输入完整信息！");
            request.getRequestDispatcher("/teacherInformation.jsp").forward(request, response);
        }else {
            HttpSession session = request.getSession(true);
            String username=(String)session.getAttribute("username");
            personInformation information=new personInformation();
            information.personInformation1("教职工",username,Fno,Fname,Fdept,Fjob);
            request.setAttribute("error","信息录用成功！");
            request.getRequestDispatcher("/teacherInformation.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
