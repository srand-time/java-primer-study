import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame.*;
public class Example11_2{
	public static void main(String args[]){
	WindowMenu win=new WindowMenu("�˵��Ĵ���",20,30,200,190);
	}
}
public class WindowMenu extends JFrame{
	JMenuBar menubar;
	JMenu menu,submenu;
	JMenuItem item1,item2;
	public WindowMenu(){}
	public WindowMenu(String s,int x,int y,int w,int h){
		init(s);
		setLocation(x,y);
		setSize(w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
void init(String s){
	setTitle(s);
	menubar=new JMenuBar();
	menu=new JMenu("�˵�");
	submenu=new JMenu("��ѧ����");
	item1=new JMenuItem("��⿻���");
	item2=new JMenuItem("��������");
	item1.setAccelerator(KeyStroke.getKeyStroke('A'));
	//item2.setAccelerator(KeyStrke.getKeyStroke(KeyEvent.VK_S,InputEvent.(TRL_MASK)));
    menu.add(item1);
    menu.addSeparator();
    menu.add(item2);
    menu.add(submenu);
    submenu.add(new JMenuItem("����"));
    submenu.add(new JMenuItem("����"));
    menubar.add(menu);
    setJMenuBar(menubar);
}
}
