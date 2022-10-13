package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "orderPath", value = "/orderPath")
public class orderPath_data extends HttpServlet {
    String[] vertexname;
    int Length;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] place=request.getParameterValues("path");
        for(int i=0;i< place.length;i++){
            System.out.println(place[i]);
        }
        shortestPath path=new shortestPath();
        path.Vertexname();
        vertexname=path.vertexname;
        Length=path.Length;
        List list = new ArrayList();
        int start=0;
        int no;
        for(int i=0;i< place.length;i++){
            System.out.println(place[i]);
            no=translate(place[i]);
            if(i==0){
                start=no;
            }
            else{
                list.add(no);
            }
        }
        orderPath orderPathB=new orderPath(list,start);
        int length=orderPathB.get_waylength();
        int count=orderPathB.get_count();
        String path1="";
        String[] vername=orderPathB.get_vername(vertexname);
        String []Path=orderPathB.get_vername(vertexname);
        String name=null;
        try {
            draw_prepare f=new draw_prepare();
            f.frame(Path);
            name=f.name;

            for (int j=0;j<count;j++){
                path1=path1+"-->"+vername[j];
            }
            System.out.println(path1);
            HttpSession session = request.getSession(true);
            session.setAttribute("way","按序到达路径");
            session.setAttribute("length",length);
            session.setAttribute("count",count);
            session.setAttribute("path",path1);
            session.setAttribute("name", name);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if(place.length==2){
            savePathHistory pathHistorySave =new savePathHistory();
            pathHistorySave.save_PathHistory(translate(place[0]),translate(place[1]),path1,length);
        }

    }
    public int translate(String name){
        int i;
        for(i=0;i<Length;i++){
            if(vertexname[i].equals(name)){
                return i;
            }
        }
        return -1;
    }
}