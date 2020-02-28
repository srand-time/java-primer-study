import java.awt.GridLayout;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyGridLayout {
    public static void main(String[] args) {
        /*
        JFrame frm = new JFrame("���񲼾ֹ�����");
        frm.setSize(300, 200);
        // ����һ�����񲼾ֹ�����ʵ��grid�����Ϊ3*3
        GridLayout grid = new GridLayout(3, 3);
        // ����frm��ҳ�沼��Ϊgrid
        frm.setLayout(grid);
        */
        JFrame frm=new JFrame("��������");
        frm.setSize(200,200);


        // ����һ��JButton������b�����鳤��Ϊ9
        JButton[] b = new JButton[9];
        for(int i=0; i<9; i++) {
            b[i] = new JButton(i+1+"");
            //b[i]=new JButton( Integer.toString(i+1));
        }
        //��ť

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
        //�¼�����

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
