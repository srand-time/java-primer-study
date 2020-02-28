import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestFrame extends JFrame{
    public TestFrame() {
        //����������ť
        JButton jbtOK=new JButton("OK");
        JButton jbtCancel=new JButton("Cancel");

        //��������ť�ŵ�panel����
        JPanel panel1=new JPanel();
        panel1.add(jbtOK);
        panel1.add(jbtCancel);

        //��panel��ӵ��������
        add(panel1);

        //ʵ����һ���������������������·�
        OKListenerClass listener1=new OKListenerClass();
        CancelListenerClass listener2=new CancelListenerClass();
        jbtOK.addActionListener(listener1);
        jbtCancel.addActionListener(listener2);

        }

    public static void main(String[] args) {
        JFrame frame=new TestFrame();
        frame.setTitle("�����¼�");
        //frame.setSize(200,150);
        //frame.setLocationRelativeTo(null);
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class OKListenerClass implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("OK��ť�ѱ����");

    }
}

class CancelListenerClass implements ActionListener{


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Cancel��ť�ѱ�����");
    }
}
