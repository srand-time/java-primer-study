import java.awt.*;
import javax.swing.*;
public class windows
{
    public static void main(String[] args)
    {
        JFrame frm=new JFrame();
        //frm.setLocation(100,100);
        //frm.setSize(300,300);
        frm.setBounds(100,100,300,300);//����������������ͬ
        frm.setTitle("�ҵĴ���");
        Container c=frm.getContentPane();
        //frm�а���һ�����ݴ��� ��Ҫ��ȡ���ݴ��������ñ�����ɫ��
        //ֱ������frm�ı�����ɫ�ᱻ���ݴ���ס
        c.setBackground(Color.RED);
        frm.setLayout(null);
        //����������ΪĬ�ϲ���


        JButton btn=new JButton("ȷ��");
        btn.setLocation(100,100);
        btn.setSize(100,40);
        //���ð�ť�Ĵ�С�����ڻ�û�м����¼�
        frm.add(btn);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
