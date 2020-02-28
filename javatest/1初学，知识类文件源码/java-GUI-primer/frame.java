import java.awt.*;
import javax.swing.*;
public class windows
{
    public static void main(String[] args)
    {
        JFrame frm=new JFrame();
        //frm.setLocation(100,100);
        //frm.setSize(300,300);
        frm.setBounds(100,100,300,300);//与上面两行作用相同
        frm.setTitle("我的窗口");
        Container c=frm.getContentPane();
        //frm中包含一个内容窗格， 需要获取内容窗格，再设置背景颜色，
        //直接设置frm的背景颜色会被内容窗格挡住
        c.setBackground(Color.RED);
        frm.setLayout(null);
        //将窗口设置为默认布局


        JButton btn=new JButton("确定");
        btn.setLocation(100,100);
        btn.setSize(100,40);
        //设置按钮的大小？现在还没有加上事件
        frm.add(btn);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
