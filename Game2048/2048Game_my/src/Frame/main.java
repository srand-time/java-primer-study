package Frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		  //���farme
		  //����ͨ����ؼ���С���ƴ��ڴ�С
	      JFrame f = new JFrame();
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setTitle("2048");
	      f.setResizable(true);
	      f.add(new Game2048(), BorderLayout.CENTER);
	      f.pack();
	      //�������������������õ�����趨���ڵĴ�С 
	      //ʹ֮��������������õ��������
	      
	      f.setLocationRelativeTo(null);
	      ///���ô��������ָ�������λ�á� 
	      //��������ǰδ��ʾ���� c Ϊ null����˴��ڽ�������Ļ�����롣
	      
	      f.setVisible(true);
	  }
}
