import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.*;
public class MyGridLayout {
    public static void main(String[] args) {
        JFrame frm = new JFrame("���񲼾ֹ�����");
        frm.setSize(300, 200);
        // ����һ�����񲼾ֹ�����ʵ��grid�����Ϊ3*3
        GridLayout grid = new GridLayout(3, 3);
        // ����frm��ҳ�沼��Ϊgrid
        frm.setLayout(grid);
        // ����һ��JButton������b�����鳤��Ϊ9
        JButton[] b = new JButton[9];
        for(int i=0; i<9; i++) {
            b[i] = new JButton(i+1+"");
            //b[i]=new JButton( Integer.toString(i+1));
            // ��b[i]��ӽ�frm��
            frm.add(b[i]);
        }
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
