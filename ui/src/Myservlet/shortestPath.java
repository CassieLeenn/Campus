package Myservlet;
import java.sql.*;
import java.util.Collections;
import java.util.List;

public class shortestPath {
    //创建数组存储景点的信息
    static int Length =length();
    static String[] vertexname = new String[Length];

    //获取景点的个数
    public static int length(){
        getScenicNum maxnum=new getScenicNum();
        System.out.println(maxnum.Jno);
        int _Length = maxnum.Jno;
        return _Length;
    }

    //逐行读取景点名字，并存入预先设定好的数组中
    public static void Vertexname(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();// 创建statement
            String sql = "SELECT * FROM scenic";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){//展开结果集数据库
                vertexname[Integer.parseInt(rs.getString("Jno"))-1]= rs.getString("Jname");
            }
            System.out.println(vertexname);
            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }

    static int[][] D = new int[vertexname.length][vertexname.length];    //D数组存储各点之间的最短路径
    static int[][] P = new int[vertexname.length][vertexname.length];    //P数组存储各点间最短路径的后置地点
    //创建邻接矩阵
    static int[][] distance = new int[vertexname.length][vertexname.length];
    static final short N = Short.MAX_VALUE;


    public static void begin(List list,int printPathNum){
        creategraph();
        floyd();
        Vertexname();
        //冒泡排序
        sortBubble(list, printPathNum);
        int waylength = 0; //记录路径的总长度
        int count = 1;
        int[] path = new int[100];//记录总的路径
        path[0] = printPathNum;  //用户输入的起点
        int stage = printPathNum;  //作为转接点标记
        for (int k = 0; k < list.size(); k++) {
            waylength += D[stage][(int) list.get(k)];
            //获取连接数
            count = getCount((int) list.get(k), count, path, stage);
            path[count] = (int) list.get(k);
            count++;
            stage = (int) list.get(k);    //以终点作为新的起点
        }
        //描述路径
        printPath(vertexname[printPathNum], waylength, path, count);
    }

    public static int begin1(List list,int printPathNum){
        creategraph();
        floyd();
        //冒泡排序
        sortBubble(list, printPathNum);
        int waylength = 0; //记录路径的总长度
        int count = 1;
        int[] path = new int[100];//记录总的路径
        path[0] = printPathNum;  //用户输入的起点
        int stage = printPathNum;  //作为转接点标记
        for (int k = 0; k < list.size(); k++) {
            waylength += D[stage][(int) list.get(k)];
            //获取连接数
            count = getCount((int) list.get(k), count, path, stage);
            path[count] = (int) list.get(k);
            count++;
            stage = (int) list.get(k);    //以终点作为新的起点
        }
        return count;
    }

    public static int begin2(List list,int printPathNum){
        creategraph();
        floyd();
        //冒泡排序
        sortBubble(list, printPathNum);
        int waylength = 0; //记录路径的总长度
        int count = 1;
        int[] path = new int[100];//记录总的路径
        path[0] = printPathNum;  //用户输入的起点
        int stage = printPathNum;  //作为转接点标记
        for (int k = 0; k < list.size(); k++) {
            waylength += D[stage][(int) list.get(k)];
            //获取连接数
            count = getCount((int) list.get(k), count, path, stage);
            path[count] = (int) list.get(k);
            count++;
            stage = (int) list.get(k);    //以终点作为新的起点
        }
        return waylength;
    }

    public static int[] begin3(List list,int printPathNum){
        creategraph();
        floyd();
        //冒泡排序
        sortBubble(list, printPathNum);
        int waylength = 0; //记录路径的总长度
        int count = 1;
        int[] path = new int[100];//记录总的路径
        path[0] = printPathNum;  //用户输入的起点
        int stage = printPathNum;  //作为转接点标记
        for (int k = 0; k < list.size(); k++) {
            waylength += D[stage][(int) list.get(k)];
            //获取连接数
            count = getCount((int) list.get(k), count, path, stage);
            path[count] = (int) list.get(k);
            count++;
            stage = (int) list.get(k);    //以终点作为新的起点
        }
        return path;
    }

    public static int begin4(List list,int printPathNum){
        creategraph();
        floyd();
        //冒泡排序
        sortBubble(list, printPathNum);
        int waylength = 0; //记录路径的总长度
        int count = 1;
        int[] path = new int[100];//记录总的路径
        path[0] = printPathNum;  //用户输入的起点
        int stage = printPathNum;  //作为转接点标记
        for (int k = 0; k < list.size(); k++) {
            waylength += D[stage][(int) list.get(k)];
            //获取连接数
            count = getCount((int) list.get(k), count, path, stage);
            path[count] = (int) list.get(k);
            count++;
            stage = (int) list.get(k);    //以终点作为新的起点
        }
        return printPathNum;
    }

    private static int getCount(int i, int count, int[] path, int stage) {
        while (P[stage][i] != i)   //利用P矩阵中的后置地点与要去的各个终点比较，
        //数值相同则直接加入path数组中，不相同证明其中有转接点。
        {
            path[count] = P[stage][i];
            stage = P[stage][i];  //以转接点作为新的起点继续循环
            count++;  //计算加1
        }
        return count;
    }

    public static void printPath(String x, int waylength, int[] path, int count) {
        System.out.println("你的起点为：");
        System.out.println(x);
        System.out.println("你的路径为：");
        for (int n = 0; n < count; n++) {
            System.out.print("->");
            System.out.print(vertexname[path[n]]);   //根据path数组中的数输出路径的名字
        }
        System.out.println();
        System.out.println("路径的总长度为：");
        System.out.println(waylength);
    }

    private static void sortBubble(List list, int start) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (D[start][(int) list.get(j)] > D[start][(int) list.get(j + 1)]) {
                    Collections.swap(list, j, (j + 1));
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void creategraph() {
        //构建图的边
        for (int i = 0; i < vertexname.length; i++) {
            for (int j = 0; j < vertexname.length; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else
                    distance[i][j] = N;
            }
        }
        pathDistance();
        for (int a = 0; a < vertexname.length; a++) {
            for (int b = 0; b < vertexname.length; b++) {
                if (distance[a][b] != 0)
                    distance[b][a] = distance[a][b];
            }
        }
    }

    //路径长度
    private static void pathDistance() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");			 // 加载驱动类
            String url = "jdbc:mysql://localhost:3306/school_navigation"; // 获取连接
            String user = "root";
            String password= "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();// 创建statement
            String sql = "SELECT * FROM distance";//查询Notice表最新一条公告
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){//展开结果集数据库
                distance[Integer.parseInt(rs.getString("Jno1"))][Integer.parseInt(rs.getString("Jno2"))]=Integer.parseInt(rs.getString("distance"));
            }
            System.out.println(distance);
            //完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e2){
            e2.printStackTrace();
        }

    }

    public static void floyd() {
        //初始化D和P数组
        for (int d = 0; d < vertexname.length; ++d) {
            for (int p = 0; p < vertexname.length; ++p) {
                D[d][p] = distance[d][p];
                P[d][p] = p;
            }
        }
        //弗罗伊德算法
        for (int k = 0; k < vertexname.length; k++) {
            for (int v = 0; v < vertexname.length; v++) {
                for (int w = 0; w < vertexname.length; w++) {
                    if (D[v][w] > D[v][k] + D[k][w]) {
                        D[v][w] = D[v][k] + D[k][w];
                        P[v][w] = P[v][k];
                    }
                }
            }
        }
    }
}
