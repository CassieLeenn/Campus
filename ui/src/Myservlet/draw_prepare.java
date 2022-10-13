package Myservlet;

import java.util.HashMap;
import java.util.Map;

public class draw_prepare {
    public String name;

    public void frame(String[] road) throws InterruptedException {

        Map[] node_info;
        Map[] readCross;
        Map[] road_info=new Map[road.length];


        node_info = new getPosition().readFileByLines();
        readCross = new getPosition().readCross();

        for(int j=0;j<road.length;j++){
            for(int i=0;i<node_info.length;i++){
                //System.out.println(j);
                //System.out.println();
                //System.out.println(i);
                if(node_info[i].get("name").equals(road[j])){
                    road_info[j]=new HashMap();
                    road_info[j].put("name",road[j]);
                    road_info[j].put("x",node_info[i].get("x"));
                    road_info[j].put("y",node_info[i].get("y"));
                }
            }
        }



        draw_picture pic= new draw_picture();
        pic.graph(road_info, readCross);
        name= pic.name;

    }
}


