import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyGridLayout {
    public static void main(String[] args) {
        /*
        JFrame frm = new JFrame("网格布局管理器");
        frm.setSize(300, 200);
        // 创建一个网格布局管理器实例grid，表格为3*3
        GridLayout grid = new GridLayout(3, 3);
        // 设置frm的页面布局为grid
        frm.setLayout(grid);
        */
        JFrame frm=new JFrame("输入数字");
        frm.setSize(200,200);


        // 定义一个JButton的数组b，数组长度为9
        JButton[] b = new JButton[9];
        for(int i=0; i<9; i++) {
            b[i] = new JButton(i+1+"");
            //b[i]=new JButton( Integer.toString(i+1));
        }
        //按钮

        JPanel panell=new JPanel();
        ListenerClass[] b_e=new ListenerClass[9];
        for(int i=0;i<9;i++)
        {
            b_e[i]=new ListenerClass();
            b_e[i].str=i+1+"";
            panell.add(b[i]);
            b[i].addActionListener(b_e[i]);
        }
        frm.add(panell);
        //事件控制

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
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
