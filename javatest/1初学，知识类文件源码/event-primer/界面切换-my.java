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
        //�˳�ֱ�Ӱ��������ϽǵĲ�
        JFrame show_all_frame=new JFrame();
        show_all_frame.setTitle("������");

        JButton button_1=new JButton("ѡ��1,�����˻�");
        JButton button_2=new JButton("ѡ��2����ʾ�����˻�");
        JButton button_3=new JButton("ѡ��3�����ȡ��");
        JButton button_4=new JButton("ɾ��һ���˻�");
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


        JButton button=new JButton("�˻���һ����");
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
