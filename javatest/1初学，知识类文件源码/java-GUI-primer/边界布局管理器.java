import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MyBorderLayout {
    public static void main(String[] args) {
        JFrame frm = new JFrame("�߽�ʽ���ֹ�����");
        // �������ֹ�����ʵ��border��ˮƽ���Ϊ5����ֱ���Ϊ10,
        BorderLayout border = new BorderLayout(5, 10);
        // ����frm��ҳ�沼��Ϊborder
        frm.setLayout(border);
        frm.setSize(280, 200);
        JButton b1 = new JButton("��");
        JButton b2 = new JButton("��");
        JButton b3 = new JButton("��");
        JButton b4 = new JButton("��");
        JButton b5 = new JButton("��");
        // ����ť��ӵ�frm���ϡ��¡����ҡ���
        frm.add(b1, BorderLayout.NORTH);
        frm.add(b2, BorderLayout.SOUTH);
        frm.add(b3, BorderLayout.WEST);
        frm.add(b4, BorderLayout.EAST);
        frm.add(b5, BorderLayout.CENTER);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
