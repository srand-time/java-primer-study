import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class PassWordWin extends JFrame
{
    public static void main(String[] args)
    {
        PassWordWin frm=new PassWordWin();
        frm.setSize(300,200);
        frm.setTitle("������֤");

        //������ɫ�������õ���RGB���
        //��������c
        Container c=frm.getContentPane();
        c.setBackground(new Color(200,255,255));
        frm.setLayout(null);

        //�������û���������ǩ
        JLabel L1=new JLabel("�û�����");
        L1.setBounds(40,50,55,25);
        frm.setResizable(false);

        //�����ı���
        JTextField t1=new JTextField(50);//���50��ʾ��������50���ַ�
        t1.setBounds(100,50,100,20);

        //���������ǩ
        JLabel L2=new JLabel("����");
        L2.setBounds(40,80,55,25);

        //���������ı���,�����Ϊ"*"
        JPasswordField t2=new JPasswordField(50);
        t2.setEchoChar('*');
        t2.setBounds(100,80,100,20);

        //����ȷ����ť
        JButton btn=new JButton("ȷ��");

        //����ȷ����ť��ȡ�û���������
        btn.addActionListener((ActionEvent e)->{
			System.out.println(t1.getText());
			System.out.println(t2.getPassword());
		});
        btn.setBounds(40,110,80,30);

        //"�����ť"���������������û���������
        JButton btn2=new JButton("���");
        btn2.addActionListener((ActionEvent e)->{
                                t1.setText("");
                                t2.setText("");
                               });
        btn2.setBounds(130,110,80,30);

        //�������ӵ�frm��
        frm.add(t1);
		frm.add(L1);
		frm.add(L2);
		frm.add(t2);
		frm.add(btn);
		frm.add(btn2);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
    }
}
