import java.awt.*;
import javax.swing.*;
public class MyFlowout
{
    public static void main(String[] args)
    {
        JFrame frm=new JFrame("流式布局管理器");
        FlowLayout flow=new FlowLayout(FlowLayout.CENTER);
        JButton b1=new JButton("first button");
        JButton b2=new JButton("second button");
        JButton b3=new JButton("third second");

        frm.setLayout(flow);
        frm.setSize(200,150);

        Container c=frm.getContentPane();
        c.setBackground(Color.pink);
        frm.add(b1);
        frm.add(b2);
        frm.add(b3);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
