package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame {
    private JButton jbtNumber0=new JButton("0");
    private JButton jbtNumber1=new JButton("1");
    private JButton jbtNumber2=new JButton("2");
    private JButton jbtNumber3=new JButton("3");
    private JButton jbtNumber4=new JButton("4");
    private JButton jbtNumber5=new JButton("5");
    private JButton jbtNumber6=new JButton("6");
    private JButton jbtNumber7=new JButton("7");
    private JButton jbtNumber8=new JButton("8");
    private JButton jbtNumber9=new JButton("9");
    private JButton jbtAdd=new JButton("+");
    private JButton jbtEqual=new JButton("=");
    private JButton jbtMinus=new JButton("-");
    private JButton jbtMultiply=new JButton("x");
    private JButton jbtDiv=new JButton("÷");
    private JButton jbtReset=new JButton("复位");
    private JLabel label1=new JLabel("请输入数据");
    private double add;
    private double added;
    private double total;
    private boolean flagAdd;
    private boolean flagMinus;
    private boolean flagMultiply;
    private boolean flagDiv;
    private boolean flagEqual;
    private JButton[] jbt={jbtNumber0,jbtNumber1,jbtNumber2,jbtNumber3,jbtNumber4,jbtNumber5,jbtNumber6,
    jbtNumber7,jbtNumber8,jbtNumber9};
    private JButton[] jbt2={jbtAdd,jbtMinus,jbtMultiply,jbtDiv};
    private String[] jbt3={"+","-","x","÷"};
    //private Boolean[] flag={flagAdd,flagMinus,flagMultiply,flagDiv,flagEqual};



    public calculator(){
            JPanel panel=new JPanel();
            ButtonListener listener=new ButtonListener();
            for (int i = 0; i < jbt.length; i++) {
            jbt[i].addActionListener(listener);
            jbtEqual.addActionListener(listener);
            jbtReset.addActionListener(listener);
            panel.add(jbt[i]);
        }
        for (int i = 0; i <jbt2.length ; i++) {
            jbt2[i].addActionListener(listener);
            panel.add(jbt2[i]);
        }
        panel.add(jbtEqual);
        panel.add(jbtReset);
        add(label1,BorderLayout.NORTH);
            add(jbtReset,BorderLayout.SOUTH);
        add(panel);
    }
    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i <jbt.length; i++) {
                if(e.getSource()==jbt[i]){
                    added=i;
                    if (!flagAdd&!flagMinus&!flagMultiply&!flagDiv){
                        System.out.println(i);
                        add=i;
                        label1.setText(""+add);
                    }
                    if(flagAdd){
                        label1.setText(add+"+"+added);
                    }
                    else if(flagMinus){
                        label1.setText(add+"-"+added);
                    }
                    else if(flagMultiply){
                        label1.setText(add+"x"+added);
                    }
                    else if(flagDiv){
                        label1.setText(add+"÷"+added);
                    }
                    break;
                }
            }

            if(e.getSource()==jbtEqual){
                //System.out.println(add+""+added);
                if(flagAdd){
                    total=add+added;
                }
                else if(flagMinus){
                    total=add-added;
                }
                else if(flagMultiply){
                    total=add*added;
                }
                else if(flagDiv){
                    total=add/added;
                }
                label1.setText(""+total);
            }
             else if(e.getSource()==jbtReset){
                add=0;
                added=0;
                flagAdd=false;
                flagMinus=false;
                flagMultiply=false;
                flagDiv=false;
                label1.setText("请输入数据:");
            }
             else if(e.getSource()==jbtAdd){
                 flagAdd=true;
                 label1.setText(add+"+");
            }
            else if(e.getSource()==jbtMinus){
                flagMinus=true;
                label1.setText(add+"-");
            }
            else if(e.getSource()==jbtMultiply){
                flagMultiply=true;
                label1.setText(add+"x");
            }
            else if(e.getSource()==jbtDiv){
                flagDiv=true;
                label1.setText(add+"÷");
            }

        }
    }


    public static void main(String[] args) {
        calculator frame=new calculator();
        frame.setTitle("Calculator");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
