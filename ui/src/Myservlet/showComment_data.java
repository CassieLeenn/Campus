package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "showremark", value = "/showremark")
public class showComment_data extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String place=request.getParameter("place");
        System.out.println("place:"+place);
        showComment show=new showComment();
        show.showComment(place);
        System.out.println(show.nickname);
        System.out.println(show.comment);
        System.out.println(show.time);
        request.setAttribute("comment_nickname",show.nickname);
        request.setAttribute("comment_comment",show.comment);
        request.setAttribute("comment_time",show.time);
        request.setAttribute("place",place);
        request.getRequestDispatcher("/showComment.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
