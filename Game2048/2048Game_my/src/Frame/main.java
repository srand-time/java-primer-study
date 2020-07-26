package Frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		  //这个farme
		  //现在通过其控件大小控制窗口大小
	      JFrame f = new JFrame();
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setTitle("2048");
	      f.setResizable(true);
	      f.add(new Game2048(), BorderLayout.CENTER);
	      f.pack();
	      //这个方法就是依据你放置的组件设定窗口的大小 
	      //使之正好能容纳你放置的所有组件
	      
	      f.setLocationRelativeTo(null);
	      ///设置窗口相对于指定组件的位置。 
	      //如果组件当前未显示或者 c 为 null，则此窗口将置于屏幕的中央。
	      
	      f.setVisible(true);
	  }
}
