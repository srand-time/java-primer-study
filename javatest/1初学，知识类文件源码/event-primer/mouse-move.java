import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MoveMessageDemo extends JFrame {
    public MoveMessageDemo(){
//        创建一个MovableMessagePanle实例去移动一条信息
        MovableMessagePanel p=new MovableMessagePanel("Welcome to Java");
//        将这条信息放在frame里面
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

    //内部类，可移动信息的绘制
    static class MovableMessagePanel extends JPanel {
        private String message = "Welcome to Java";
        private int x = 20;
        private int y = 20;

        //构造一个panel绘制信息
        public MovableMessagePanel(String s) {
            message = s;
            addMouseMotionListener(new MouseMotionAdapter() {
                //           处理鼠标移动事件
                public void mouseDragged(MouseEvent e) {
//            获取新的位置信息并且重新绘制在屏幕上
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
