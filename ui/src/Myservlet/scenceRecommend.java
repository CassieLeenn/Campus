package Myservlet;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

import static java.lang.Integer.parseInt;

public class scenceRecommend {
    //String Url = "jdbc:mysql://172.16.143.11/school_navigation";//数据库地址，Mysql 8.0以下使用
    String Url = "jdbc:mysql://localhost:3306/school_navigation";//数据库地址，Mysql 8.0以上使用
    String name = "root";//数据库用户名
    String psd = "123456";//数据库密码

//    String jdbcName = "com.mysql.jdbc.Driver";//连接MySql数据库，Mysql 8.0以下用这条语句
    String jdbcName = "com.mysql.cj.jdbc.Driver";//Mysql 8.0以上用这条语句
    String sql = "SELECT * FROM  Discussion  order by Dtime desc";//数据库操作语句（插入）
    String sql2= "insert into recommend values(?,?) ";
    String sql3 = "truncate recommend "; //相当于定期清楚数据

    List<String> place = new ArrayList<String>();
    List<String> message = new ArrayList<String>();

    public static Calendar dataToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public void Recommend_sjk(){
        Connection con = null;

        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;

        ResultSet rs=null;

        Map<String,Integer> scenic_sum = new HashMap<String, Integer>();

        try {
            Class.forName(jdbcName);//向DriverManager注册自己
            con = DriverManager.getConnection(Url, name, psd);//与数据库建立连接

            pst=con.prepareStatement(sql);//获得预处理对象

            Statement stmt=con.createStatement();
            stmt.executeUpdate(sql3);

//            stmt = con.createStatement();
            rs=pst.executeQuery();//查询结果返回rs中

            Date date = new Date(); //获取当前系统时间
            Timestamp nousedate = new Timestamp(date.getTime());
            Date date1 =nousedate;
            Calendar  currentTimes =dataToCalendar(date1);  //转换为对应的数据类型


            //读取mysql数据库的内容
            while(rs.next()){
                String Jno=rs.getString("Jno");  //将对应的值存到字典中去
                String Jname=rs.getString("Jname");
                Timestamp Dtime=rs.getTimestamp("Dtime");
                Date date2 =Dtime;
                Calendar  oldTimes =dataToCalendar(date2);
                int minus_day=-currentTimes.get(Calendar.DAY_OF_MONTH) + oldTimes.get(Calendar.DAY_OF_MONTH);

                //加一个限制，最近一个月内的评论
                if(minus_day<=30) {  //30天之内的评论收集
                    if (!scenic_sum.containsKey(Jname))
                        scenic_sum.put(Jname, 1);
                    else {
                        int times = scenic_sum.get(Jname) + 1;
                        scenic_sum.put(Jname, times);
                    }
                }
            }

            pst2=con.prepareStatement(sql2);//获得预处理对象

            Set<Map.Entry<String, Integer>> lists=scenic_sum.entrySet();
            for (Map.Entry<String, Integer> entry : lists) {      //重点

                    pst2.setString(1, entry.getKey());
                    pst2.setInt(2, entry.getValue());
                    pst2.executeUpdate();

            }



        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//执行与数据库建立连接需要抛出SQL异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            // 关闭资源
            try{
                if(pst!=null) pst.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(con!=null) con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }


    //管理员点击推荐才会推荐
    public void recommend() throws SQLException, ClassNotFoundException {
        Connection con = null;
        Class.forName(jdbcName);//向DriverManager注册自己
        con = DriverManager.getConnection(Url, name, psd);//与数据库建立连


        PreparedStatement pst = null;

        ResultSet rs=null;

        String sql = "SELECT * FROM  recommend  LEFT JOIN scenic on scenic.Jname=recommend.Jname order by times desc" ;//数据库操作语句（插入）


        pst=con.prepareStatement(sql);//获得预处理对象
        rs=pst.executeQuery();//查询结果返回rs中


        int i=0;
        //推荐前三个
        while(rs.next()){
            if(i>=5){
                break;
            }else {
                //要推荐的Top 景点
                //传送到前端有名字、介绍
                String Jname = rs.getString("Jname");  //将对应的值存到字典中去
                String Jmessage = rs.getString("Jmessage");  //将对应的值存到字典中去
                place.add(Jname);
                message.add(Jmessage);
                System.out.println("Jname:" + Jname); //读取一些景点介绍
                System.out.println("Jmessage:" + Jmessage); //读取一些景点介绍
            }

        i++;
        }


    }


}
