import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MoveMessageDemo extends JFrame {
    public MoveMessageDemo(){
//        ����һ��MovableMessagePanleʵ��ȥ�ƶ�һ����Ϣ
        MovableMessagePanel p=new MovableMessagePanel("Welcome to Java");
//        ��������Ϣ����frame����
        setLayout(new BorderLayout());
        add(p);
    }

    public static void main(String[] args) {
        MoveMessageDemo frame=new MoveMessageDemo();
        frame.setTitle("MoveMessage");
        frame.setSize(200,100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //�ڲ��࣬���ƶ���Ϣ�Ļ���
    static class MovableMessagePanel extends JPanel {
        private String message = "Welcome to Java";
        private int x = 20;
        private int y = 20;

        //����һ��panel������Ϣ
        public MovableMessagePanel(String s) {
            message = s;
            addMouseMotionListener(new MouseMotionAdapter() {
                //           ��������ƶ��¼�
                public void mouseDragged(MouseEvent e) {
//            ��ȡ�µ�λ����Ϣ�������»�������Ļ��
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }
            });
        }

        protected void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.drawString(message, x, y);

        }
    }
}
