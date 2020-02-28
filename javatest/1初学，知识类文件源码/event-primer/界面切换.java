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

JFrame frame; //主界面框架

//主界面函数
public void mainFace() {
frame=new JFrame("主界面");
frame.setLayout(new BorderLayout());

JLabel label=new JLabel("这是主界面");
frame.add(label,BorderLayout.CENTER);

JButton button=new JButton("进入另一个界面");
frame.add(button,BorderLayout.SOUTH);
button.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
otherFace(); //进入另一个界面
frame.dispose(); //主界面关闭
}

});

frame.setSize(400,300);
frame.setLocation(100,50);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

//另一个图形界面
public void otherFace() {
final JFrame oframe=new JFrame("另一个界面");
oframe.setLayout(new BorderLayout());

JTextArea displayArea=new JTextArea();
oframe.add(displayArea,BorderLayout.CENTER);
displayArea.setFont(new Font("宋体",Font.BOLD,30));
displayArea.setForeground(Color.red);

displayArea.append("\n\n\n\n 这是另一个图形界面");

JButton button1=new JButton("返回主界面");
oframe.add(button1,BorderLayout.SOUTH);

button1.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
frame.setVisible(true); //主界面显示
oframe.dispose(); //另一个界面关闭
}

});

oframe.setSize(400,300);
oframe.setLocation(150,100);
oframe.setVisible(true);
}

//密码输入函数
public void passwordFrame() {
final JFrame keyFrame=new JFrame("Password Input");
keyFrame.setLayout(new FlowLayout());

final JPasswordField keyField=new JPasswordField();
keyField.setColumns(30);
keyField.setFont(new Font("宋体",Font.BOLD,20));
keyField.setEchoChar('@');
keyFrame.add(keyField);

Calendar calendar=Calendar.getInstance();

int mon=calendar.get(Calendar.MONTH)+1;
int day=calendar.get(Calendar.DAY_OF_MONTH);
int h=calendar.get(Calendar.HOUR_OF_DAY);
int m=calendar.get(Calendar.MINUTE);

System.out.println(mon+"."+day+"."+h+"."+m);
final String nowKey=mon+"."+day+"."+h+"."+m; //密码为现在时间的 月.日.时.分

keyField.addKeyListener(new KeyListener() { //给密码框添加键盘监听器

public void keyPressed(KeyEvent e) {
if(e.getKeyCode()==KeyEvent.VK_ENTER) {
char[] key=keyField.getPassword();
String keyStr = String.valueOf(key);

if(keyStr.equals(nowKey)) {
mainFace(); //进入主界面
keyFrame.dispose();
}
else {
JOptionPane.showMessageDialog(null, "输入的密码不正确！");
}
}
}

@Override
public void keyReleased(KeyEvent e) {}

public void keyTyped(KeyEvent e) {}

});

JButton sureButton=new JButton("确认");
keyFrame.add(sureButton);
sureButton.addActionListener(new ActionListener() { //给'确定'按钮添加动作监听器

public void actionPerformed(ActionEvent e) {
char[] key=keyField.getPassword();
String keyStr = String.valueOf(key);

if(keyStr.equals(nowKey)) {
mainFace(); //进入主界面
keyFrame.dispose();
}
else {
JOptionPane.showMessageDialog(null, "输入的密码不正确！");
}
}

});

JButton cancelButton=new JButton("取消");
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

//程序主函数
public static void main(String args[]) {
Test2 t2=new Test2();
t2.passwordFrame();
}
}
