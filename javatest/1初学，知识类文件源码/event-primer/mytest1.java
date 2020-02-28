import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class test1
{
    public static void main(String[] args)
    {
        JFrame frame=new JFrame();
        frame.setTitle("event handle");
        //初始化一个JFrame,初始化的时候只new一个对象
        //并且建立一个标题，大小，是否可见，位置什么的最后再写。。

        JButton jbtok=new JButton("ok");
        JButton jbtcancel=new JButton("cancel");
        //添加两个按钮。ok和cancel。

        JPanel panell=new JPanel();
        panell.add(jbtok);
        panell.add(jbtcancel);
        frame.add(panell);


        //添加按钮和框架

        ListenerClass listener_ok=new ListenerClass();
        ListenerClass listener_cancel=new ListenerClass();
        listener_ok.str="OK";
        listener_cancel.str="Cancel";
        //实例化两个监听器

        jbtok.addActionListener(listener_ok);
        jbtcancel.addActionListener(listener_cancel);
        //将监听器添加过去

        frame.setBounds(0,0,300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ListenerClass implements ActionListener
{
    public String str;
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(str+"execute");
    }
}
