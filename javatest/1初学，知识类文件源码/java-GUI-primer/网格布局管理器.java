import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
public class MyGridLayout {
    public static void main(String[] args) {
        JFrame frm = new JFrame("网格布局管理器");
        frm.setSize(300, 200);
        // 创建一个网格布局管理器实例grid，表格为3*3
        GridLayout grid = new GridLayout(3, 3);
        // 设置frm的页面布局为grid
        frm.setLayout(grid);
        // 定义一个JButton的数组b，数组长度为9
        JButton[] b = new JButton[9];
        for(int i=0; i<9; i++) {
            b[i] = new JButton(i+1+"");
            //b[i]=new JButton( Integer.toString(i+1));
            // 将b[i]添加进frm中
            frm.add(b[i]);
        }
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
