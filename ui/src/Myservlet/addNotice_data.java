package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "warm", value = "/warm")
public class addNotice_data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String Warm=request.getParameter("warming");
        System.out.println("Warm:"+Warm);
        addNotice not=new addNotice();
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("username");
        System.out.println("Macc:"+username);
        not.Notice(username,Warm);
        if(not.isIn==true){
            request.setAttribute("error1", "发布公告成功");
        }else{
            request.setAttribute("error1", "发布公告失败");
        }
        request.setAttribute("information", Warm);
        request.getRequestDispatcher("/addNotice.jsp").forward(request, response);
    }
}