import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class bankmenu_GUI
{
    public static void main(String[] args)
    {
        show_all_operation1();
    }
    public static void show_all_operation1()
    {
        //退出直接按界面右上角的差
        JFrame show_all_frame=new JFrame();
        show_all_frame.setTitle("主界面");

        JButton button_1=new JButton("选项1,创建账户");
        JButton button_2=new JButton("选项2，显示所有账户");
        JButton button_3=new JButton("选项3，存款取款");
        JButton button_4=new JButton("删除一个账户");
        JPanel panell=new JPanel();
        panell.add(button_1);panell.add(button_2);
        panell.add(button_3);panell.add(button_4);
        show_all_frame.add(panell);

        button_1.addActionListener((ActionEvent e)->{
			excute_an_operation(1,show_all_frame);show_all_frame.dispose();
        });
        button_2.addActionListener((ActionEvent e)->{
			excute_an_operation(2,show_all_frame);show_all_frame.dispose();
        });
        button_3.addActionListener((ActionEvent e)->{
			excute_an_operation(3,show_all_frame);show_all_frame.dispose();
        });
        button_4.addActionListener((ActionEvent e)->{
			excute_an_operation(4,show_all_frame);show_all_frame.dispose();
        });

        show_all_frame.setSize(500,500);
        show_all_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show_all_frame.setLocationRelativeTo(null);
        show_all_frame.setVisible(true);
    }

    public static void excute_an_operation(int i,JFrame frame)
    {
        switch(i)
        {
        case 1:
            window_1(frame);
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:
            break;
        }
    }

    public static void window_1(JFrame frame)
    {
        JFrame f=new JFrame();

        JTextField []jtf=new JTextField[5];
        for(int i=0;i<3;i++)
        {
        jtf[i]=new JTextField(i+"",20);
        jtf[i].setEditable(false);
        jtf[i].setBounds(30,30*i,140,20);
        f.add(jtf[i]);
        }


        JButton button=new JButton("退回上一界面");
        JPanel  panell=new JPanel();
        panell.add(button);
        f.add(panell,BorderLayout.CENTER);
        button.addActionListener((ActionEvent e)->{
			f.dispose();frame.setVisible(true);
        });

        f.setSize(500,500);

        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
