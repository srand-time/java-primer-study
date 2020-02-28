import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlcircle
{
    public static void main1()
    {
        JFrame frame=new JFrame();
        frame.setTitle("Control circle");

        JButton jbtlarge=new JButton("�Ŵ�");
        JButton jbtshrink=new JButton("��С");

        JPanel panell=new JPanel();
        panell.add(jbtlarge);
        panell.add(jbtshrink);
        frame.add(panell,BorderLayout.NORTH);

        CirclePanel canvas=new CirclePanel();
        frame.add(canvas,BorderLayout.CENTER);
        //canvas.repaint();


        /*ListenerClass_l listener_large=new ListenerClass_l();
        ListenerClass_s listener_shrink=new ListenerClass_s();
        //ʵ��������������

        jbtlarge.addActionListener(listener_large);
        jbtshrink.addActionListener(listener_shrink);
        //����������ӹ�ȥ
        */
        jbtlarge.addActionListener((ActionEvent e)->{
			canvas.enlarge();
        });
        jbtshrink.addActionListener((ActionEvent e)->{
			canvas.shrink();
        });


        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class CirclePanel extends JPanel
{
        private int radius=5;
        public void enlarge(){
            radius++;
            repaint();
        }
        public void shrink(){
            radius--;
            repaint();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(getWidth()/2-radius,getHeight()/2-radius,2*radius,2*radius);
        }
}


