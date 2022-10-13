package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebServlet(name = "remark", value = "/remark")
public class comment_data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment=request.getParameter("comment");
        String place=request.getParameter("place");
        if(comment.equals("")||place.equals("")){
            request.setAttribute("Tips","请输入完整信息！");
            request.getRequestDispatcher("/comment.jsp").forward(request, response);
        }
        else {
            scenicExist judge = new scenicExist(place);
            if (judge.isIn == false) {
                request.setAttribute("Tips", "该景点不存在！");
                request.getRequestDispatcher("/comment.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                String username=(String)session.getAttribute("username");
                getNickname Nickname=new getNickname(username);
                String nickname=Nickname.nickname;
                JnameTranslateJno tojno=new JnameTranslateJno(place);
                int Jno=tojno.Jno;
                scenicComment commentStore=new scenicComment();
                commentStore.scenicComment(Jno,place,nickname,username,comment);
                if(commentStore.count>0){
                    request.setAttribute("Tips", "评论发表成功！");
                    request.getRequestDispatcher("/comment.jsp").forward(request, response);
                }else{
                    request.setAttribute("Tips", "评论发表失败！");
                    request.setAttribute("comment", comment);
                    request.getRequestDispatcher("/comment.jsp").forward(request, response);
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}