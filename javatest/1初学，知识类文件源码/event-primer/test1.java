import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestFrame extends JFrame{
    public TestFrame() {
        //创建两个按钮
        JButton jbtOK=new JButton("OK");
        JButton jbtCancel=new JButton("Cancel");

        //把两个按钮放到panel里面
        JPanel panel1=new JPanel();
        panel1.add(jbtOK);
        panel1.add(jbtCancel);

        //把panel添加到框架里面
        add(panel1);

        //实例化一个监听器，监听器类在下方
        OKListenerClass listener1=new OKListenerClass();
        CancelListenerClass listener2=new CancelListenerClass();
        jbtOK.addActionListener(listener1);
        jbtCancel.addActionListener(listener2);

        }

    public static void main(String[] args) {
        JFrame frame=new TestFrame();
        frame.setTitle("处理事件");
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
        System.out.println("OK按钮已被点击");

    }
}

class CancelListenerClass implements ActionListener{


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Cancel按钮已被按下");
    }
}
