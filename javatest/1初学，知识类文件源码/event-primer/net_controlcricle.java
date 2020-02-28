import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlCircle2 extends JFrame {
    private JButton jbtEnlarge=new JButton("∑≈¥Û");
    private JButton jbtShrink=new JButton("Àı–°");
    private CirclePanel canvas=new CirclePanel();

    public ControlCircle2(){
        JPanel panel=new JPanel();
        panel.add(jbtEnlarge);
        panel.add(jbtShrink);

        add(canvas, BorderLayout.CENTER);
        add(panel,BorderLayout.SOUTH);

        jbtEnlarge.addActionListener(new EnlargeListener());
        jbtShrink.addActionListener(new ShrinkListener() );
    }

    public static void main(String[] args) {
        ControlCircle2 frame=new ControlCircle2();
        frame.setTitle("ControlCircle2");
        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class EnlargeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.enlarge();
        }
    }
    class ShrinkListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.shrink();
        }
    }
    class CirclePanel extends JPanel{
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

}
