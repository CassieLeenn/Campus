package Myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "shortPath", value = "/shortPath")
public class shortestPath_data extends HttpServlet {
    String[] vertexname;
    int Length;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] place=request.getParameterValues("path");
        int no;
        //首先创建结点数组，用于后续转换
        shortestPath path=new shortestPath();
        path.Vertexname();
        vertexname=path.vertexname;
        Length=path.Length;
        List list = new ArrayList();
        int start=0;
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
        int count=path.begin1(list,start);
        int waylength=path.begin2(list,start);
        int [] Path=path.begin3(list,start);
        int ss =path.begin4(list,start);
        path.printPath(place[0],waylength,Path,count);

        String[] vername=new String[count];
        for(int i=0;i<count;i++){
            vername[i]=vertexname[Path[i]];
            System.out.println(vername[i]);
        }
        String name=null;
        try {
            draw_prepare f=new draw_prepare();
            f.frame(vername);
            name=f.name;
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        String path1="";
        for (int j=0;j<count;j++){
            path1=path1+"-->"+vername[j];
        }
        if(place.length==2){
            savePathHistory pathHistorySave =new savePathHistory();
            pathHistorySave.save_PathHistory(translate(place[0]),translate(place[1]),path1,waylength);
        }
        
        HttpSession session = request.getSession(true);
        session.setAttribute("way","最短到达路径");
        session.setAttribute("length",waylength);
        session.setAttribute("count",count);
        session.setAttribute("path",path1);
        session.setAttribute("name", name);

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