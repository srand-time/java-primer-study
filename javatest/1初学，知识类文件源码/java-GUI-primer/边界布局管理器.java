import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MyBorderLayout {
    public static void main(String[] args) {
        JFrame frm = new JFrame("边界式布局管理器");
        // 创建布局管理器实例border，水平间隔为5，垂直间隔为10,
        BorderLayout border = new BorderLayout(5, 10);
        // 设置frm的页面布局为border
        frm.setLayout(border);
        frm.setSize(280, 200);
        JButton b1 = new JButton("北");
        JButton b2 = new JButton("南");
        JButton b3 = new JButton("西");
        JButton b4 = new JButton("东");
        JButton b5 = new JButton("中");
        // 将按钮添加到frm的上、下、左、右、中
        frm.add(b1, BorderLayout.NORTH);
        frm.add(b2, BorderLayout.SOUTH);
        frm.add(b3, BorderLayout.WEST);
        frm.add(b4, BorderLayout.EAST);
        frm.add(b5, BorderLayout.CENTER);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
