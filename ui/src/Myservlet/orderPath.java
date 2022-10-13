package Myservlet;

import java.util.ArrayList;
import java.util.List;

public class orderPath {

    List list = new ArrayList();
    private int count=1;
    private int waylength=0;
    int[] Path;
    List Path1 = new ArrayList();

    //计算最短路径、最短路程、经过地点的数量；list:UserMenu中存放目的地的list，starpoint:起点Start[0]
    public orderPath(List list, int starpoint){
        System.out.println("in");
        int lsize = list.size();
        List end =new ArrayList();
        int star = starpoint;
        Path1.add(starpoint);
        shortestPath path = new shortestPath();
        for (int i=0;i<lsize;i++){
            end.add(list.get(i));
            int num = path.begin1(end,star);
            waylength += path.begin2(end,star);
            Path = path.begin3(end,star);

            for(int j=1;j<num;j++){
                Path1.add(Path[j]);
                System.out.println(Path[j]);
            }
            count +=(num-1);
            star = (int) end.get(0);
            end.remove(0);
        }

    }

    //获取路径
    public String[] get_vername(String[] vertexname) {//vertexname:存放所有地点名称的数组
        String[] vername=new String[count];
        for(int i=0;i<count;i++){
            vername[i]=vertexname[(int) Path1.get(i)];
            System.out.println(vername[i]);
        }
        return vername;
    }
    //获取总路程
    public int get_waylength() {
        return waylength;

    }
    //获取经过的点的数量
    public int get_count() {
        return count;
    }

}
