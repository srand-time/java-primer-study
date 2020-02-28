import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Test2{
public Test2() {}

JFrame frame; //��������

//�����溯��
public void mainFace() {
frame=new JFrame("������");
frame.setLayout(new BorderLayout());

JLabel label=new JLabel("����������");
frame.add(label,BorderLayout.CENTER);

JButton button=new JButton("������һ������");
frame.add(button,BorderLayout.SOUTH);
button.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
otherFace(); //������һ������
frame.dispose(); //������ر�
}

});

frame.setSize(400,300);
frame.setLocation(100,50);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

//��һ��ͼ�ν���
public void otherFace() {
final JFrame oframe=new JFrame("��һ������");
oframe.setLayout(new BorderLayout());

JTextArea displayArea=new JTextArea();
oframe.add(displayArea,BorderLayout.CENTER);
displayArea.setFont(new Font("����",Font.BOLD,30));
displayArea.setForeground(Color.red);

displayArea.append("\n\n\n\n ������һ��ͼ�ν���");

JButton button1=new JButton("����������");
oframe.add(button1,BorderLayout.SOUTH);

button1.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
frame.setVisible(true); //��������ʾ
oframe.dispose(); //��һ������ر�
}

});

oframe.setSize(400,300);
oframe.setLocation(150,100);
oframe.setVisible(true);
}

//�������뺯��
public void passwordFrame() {
final JFrame keyFrame=new JFrame("Password Input");
keyFrame.setLayout(new FlowLayout());

final JPasswordField keyField=new JPasswordField();
keyField.setColumns(30);
keyField.setFont(new Font("����",Font.BOLD,20));
keyField.setEchoChar('@');
keyFrame.add(keyField);

Calendar calendar=Calendar.getInstance();

int mon=calendar.get(Calendar.MONTH)+1;
int day=calendar.get(Calendar.DAY_OF_MONTH);
int h=calendar.get(Calendar.HOUR_OF_DAY);
int m=calendar.get(Calendar.MINUTE);

System.out.println(mon+"."+day+"."+h+"."+m);
final String nowKey=mon+"."+day+"."+h+"."+m; //����Ϊ����ʱ��� ��.��.ʱ.��

keyField.addKeyListener(new KeyListener() { //���������Ӽ��̼�����

public void keyPressed(KeyEvent e) {
if(e.getKeyCode()==KeyEvent.VK_ENTER) {
char[] key=keyField.getPassword();
String keyStr = String.valueOf(key);

if(keyStr.equals(nowKey)) {
mainFace(); //����������
keyFrame.dispose();
}
else {
JOptionPane.showMessageDialog(null, "��������벻��ȷ��");
}
}
}

@Override
public void keyReleased(KeyEvent e) {}

public void keyTyped(KeyEvent e) {}

});

JButton sureButton=new JButton("ȷ��");
keyFrame.add(sureButton);
sureButton.addActionListener(new ActionListener() { //��'ȷ��'��ť��Ӷ���������

public void actionPerformed(ActionEvent e) {
char[] key=keyField.getPassword();
String keyStr = String.valueOf(key);

if(keyStr.equals(nowKey)) {
mainFace(); //����������
keyFrame.dispose();
}
else {
JOptionPane.showMessageDialog(null, "��������벻��ȷ��");
}
}

});

JButton cancelButton=new JButton("ȡ��");
keyFrame.add(cancelButton);
cancelButton.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {
System.exit(0);
}

});

keyFrame.setSize(400,120);
keyFrame.setLocation(300,300);
keyFrame.setVisible(true);
keyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

//����������
public static void main(String args[]) {
Test2 t2=new Test2();
t2.passwordFrame();
}
}
