package Myservlet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class draw_picture extends JPanel {
    BufferedImage bimg = null;
    JLabel jl = null;
    ImageIcon img = null;
    String name;

    public draw_picture() {
        try {
            this.bimg = ImageIO.read(new FileInputStream("C:\\Users\\ASUS\\Desktop\\1919\\ui\\web\\withstart.jpg"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();

        }

//        jl=new JLabel(img);
//            this.setLayout(new BorderLayout());
//            this.add(jl,BorderLayout.CENTER);
    }
    //在这里通过读取一个数组 然后再里面画

    //根据Jpanel调整图片大小
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        int w = getWidth();
        int h = getHeight();
        int iw = bimg.getWidth();
        int ih = bimg.getHeight();
        double xScale = (double) w / iw;   //比列大小
        double yScale = (double) h / ih;
        double scale = Math.min(xScale, yScale);    // scale to fit
        //Math.max(xScale, yScale);  // scale to fill
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        g2.drawImage(bimg, x, y, width, height, this);
    }


    //画图
    public void graph(Map[] node_info, Map[] crossroad) throws InterruptedException {
        //传进去的已经是个字典了

        Graphics2D g2d = (Graphics2D) bimg.getGraphics();
        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(10f)); //用来放大直线的倍数


        for (int i = 0; i < node_info.length - 1; i++) {


            if (node_info[i].get("name").equals("弘毅书院") && !node_info[i + 1].get("name").equals("图书馆") &&!node_info[i + 1].get("name").equals("医学院")) {   //弘毅书院必需后接

                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
                int a = Integer.parseInt(crossroad[0].get("x").toString());
                int b = Integer.parseInt(crossroad[0].get("y").toString());
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                g2d.drawLine(a, b, x2, y2);

            } else if ((node_info[i].get("name").equals("弘毅书院") && node_info[i + 1].get("name").equals("图书馆"))
            ) {   //弘毅书院必需后接
                System.out.println("hello！");
                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
                int a = Integer.parseInt(crossroad[0].get("x").toString());
                int b = Integer.parseInt(crossroad[0].get("y").toString());
                int c = Integer.parseInt(crossroad[1].get("x").toString());
                int d = Integer.parseInt(crossroad[1].get("y").toString());
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                g2d.drawLine(a, b, c, d);
                g2d.drawLine(c, d, x2, y2);


            } else if ((node_info[i].get("name").equals("医学院") && node_info[i + 1].get("name").equals("图书馆"))) {
                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
//                int a = Integer.parseInt(crossroad[0].get("x").toString());
//                int b = Integer.parseInt(crossroad[0].get("y").toString());
                int a = 2897;
                int b = 3641;
                int c=2955;
                int d=3473;
                int e=3293;
                int f=3337;
//                int c = Integer.parseInt(crossroad[1].get("x").toString());
//                int d = Integer.parseInt(crossroad[1].get("y").toString());
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                //g2d.drawLine(a, b, c, d);
                g2d.drawLine(a, b, c, d);
                g2d.drawLine(c, d, e, f);
                g2d.drawLine(e, f, x2, y2);
                 //已经连接图书馆了应该定位到图书馆到下一个

            } else if ((node_info[i].get("name").equals("工科楼") && node_info[i + 1].get("name").equals("理科楼"))||
                    (node_info[i].get("name").equals("理科楼") && node_info[i + 1].get("name").equals("工科楼"))
            ) {
                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
                int a = Integer.parseInt(crossroad[2].get("x").toString());
                int b = Integer.parseInt(crossroad[2].get("y").toString());
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                g2d.drawLine(a, b, x2, y2);

            } else if((node_info[i].get("name").equals("荷花池")  && node_info[i + 1].get("name").equals("旧行政楼"))||
                    (node_info[i].get("name").equals("旧行政楼")  && node_info[i + 1].get("name").equals("荷花池"))
            ) {

                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
                int a = Integer.parseInt(crossroad[4].get("x").toString());
                int b = Integer.parseInt(crossroad[4].get("y").toString());
                int c = Integer.parseInt(crossroad[3].get("x").toString());
                int d = Integer.parseInt(crossroad[3].get("y").toString());
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                g2d.drawLine(a, b, c, d);
                g2d.drawLine(c, d, x2, y2);

            } else if ((node_info[i].get("name").equals("二三饭") && (node_info[i + 1].get("name").equals("艺术学院") || node_info[i + 1].get("name").equals("淑德书院")))) {
                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
                int a = Integer.parseInt(crossroad[5].get("x").toString());
                int b = Integer.parseInt(crossroad[5].get("y").toString());
                int c = Integer.parseInt(crossroad[6].get("x").toString());
                int d = Integer.parseInt(crossroad[6].get("y").toString());
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                g2d.drawLine(a, b, c, d);
                g2d.drawLine(c, d, x2, y2);

            } else if((node_info[i].get("name").equals("校医院")&&node_info[i + 1].get("name").equals("水库"))
            ||(node_info[i].get("name").equals("水库")&&node_info[i + 1].get("name").equals("校医院"))
            ){
                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
                int a = Integer.parseInt(crossroad[7].get("x").toString());
                int b = Integer.parseInt(crossroad[7].get("y").toString());
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                g2d.drawLine(a, b, x2, y2);

            }else if((node_info[i].get("name").equals("水库")&&node_info[i + 1].get("name").equals("艺术学院"))||
                    (node_info[i].get("name").equals("艺术学院")&&node_info[i + 1].get("name").equals("水库"))
            ){
                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
                int a = Integer.parseInt(crossroad[8].get("x").toString());
                int b = Integer.parseInt(crossroad[8].get("y").toString());
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                g2d.drawLine(a, b, x2, y2);
            }else if((node_info[i].get("name").equals("研究生院")&&node_info[i + 1].get("name").equals("艺术学院"))||
                    (node_info[i].get("name").equals("艺术学院")&&node_info[i + 1].get("name").equals("研究生院"))
            ){
                int x1 = Integer.parseInt(node_info[i].get("x").toString());
                int y1 = Integer.parseInt(node_info[i].get("y").toString());
                int a=0;
                int b=0;
                int c=0;
                int d=0;
                if(node_info[i].get("name").equals("研究生院")) {
                     a = Integer.parseInt(crossroad[9].get("x").toString());
                     b = Integer.parseInt(crossroad[9].get("y").toString());
                     c = Integer.parseInt(crossroad[10].get("x").toString());
                     d = Integer.parseInt(crossroad[10].get("y").toString());
                }
                else{
                    a = Integer.parseInt(crossroad[10].get("x").toString());
                    b = Integer.parseInt(crossroad[10].get("y").toString());
                    c = Integer.parseInt(crossroad[9].get("x").toString());
                    d = Integer.parseInt(crossroad[9].get("y").toString());
                }
                int x2 = Integer.parseInt(node_info[i + 1].get("x").toString());
                int y2 = Integer.parseInt(node_info[i + 1].get("y").toString());
                g2d.drawLine(x1, y1, a, b);
                g2d.drawLine(a, b, c, d);
                g2d.drawLine(c, d, x2, y2);

            }else
                {

                int a = Integer.parseInt(node_info[i].get("x").toString());
                int b = Integer.parseInt(node_info[i].get("y").toString());
                int c = Integer.parseInt(node_info[i + 1].get("x").toString());
                int d = Integer.parseInt(node_info[i + 1].get("y").toString());

                g2d.drawLine(a, b, c, d);
            }

        }


        // }


        //然后再写进去
        try {
            name="draw_pic";
            ImageIO.write(bimg, "JPG", new FileOutputStream("C:\\Users\\ASUS\\Desktop\\"+name+".jpg"));



        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





