//转自：
//https://git.nowcoder.com/11000160/2048-java/blob/master/Game2048.java
//添加了注释

package Frame;
import Settings.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


public class Game2048 extends JPanel {
	//随机数
	private Random rand = new Random();
	
	//地块
	private Tile [][]tiles;

  public Game2048() {
    setPreferredSize(new Dimension(900, 700));    //用于创建用户界面
    //setSize,setLocation,setBounds方法需要在不使用布局管理器的时候使用，
    //也就是setLayout(null)的时候可以使用这三个方法控制布局。
    //setPreferredSize需要在使用布局管理器的时候使用,
    //布局管理器会获取空间的preferredsize，因而可以生效。
    
    
    //setBackground(new Color(0xFAF8EF));           //背景颜色设置
    //setFont(new Font("SansSerif", Font.BOLD, 48));//字体设置
    setFocusable(true);					
    //一个组件在获得焦点(focus)的时候, 该组件上的键盘事件监听器才能捕获键盘事件 

    //鼠标监听
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        startGame();
        //由于startGame会进行状态判断，利用gamestate确定这是否是一轮新的游戏
        //所以可以只要一点鼠标就调用不会有问题

        repaint();
        //点击后调用startGame，需要在同一个界面下重新绘制游戏内容，所以需要repaint
        //好像每次要绘制界面的时候都加一个repaint也没有关系。
      }
    });
    

    //键盘监听
    //通过按下方向键调用对应的move函数
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
          case KeyEvent.VK_UP:
            moveUp();
            //setting.gamestate =setting.State.start;
            break;
          case KeyEvent.VK_DOWN:
            moveDown();
            break;
          case KeyEvent.VK_LEFT:
            moveLeft();
            break;
          case KeyEvent.VK_RIGHT:
            moveRight();
            break;
        }
        repaint();
      }
    });
  }

  public void startGame() 
  {
	  if(setting.gamestate != setting.State.running)
	  {
		  setting.gamestate=setting.State.running;
		  setting.score=0;
		  tiles=new Tile[setting.sides][setting.sides];
		  //此时还没有各个tiles,仍然需要自己new每一个tiles
		  addRandomTile();
		  addRandomTile();
	  }
  }
  
  //绘制界面模块
  @Override
  public void paintComponent(Graphics g) {

	  if(setting.gamestate == setting.State.running) 
	  {		  
		  g.setColor(setting.startColor);
		  g.fillRect(0,0,900,700);
		  //绘制分数字符串
		  g.setColor(setting.gridColor.darker().darker());
		  g.setFont(new Font("SansSerif", Font.BOLD, 40));
		  String s1 = String.valueOf(setting.score);
		  g.drawString("当前得分:"+s1, 300, 650);
		  
		  
		  g.setColor(setting.gridColor);
		  g.fillRoundRect(200, 100, 500, 500, 15, 15);
		  
		  //按下按键或者鼠标后
		  //每次都重新绘制所有的块,因为每次移动都会有合并
		  for (int r = 0; r < setting.sides; r++) {
		        for (int c = 0; c < setting.sides; c++) {
		        	if(tiles[r][c]==null)
		        	{
		        		g.setColor(setting.emptyColor);
		            	g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);
		        	}
		        	else 
		        	{
		        		int value=tiles[r][c].getvalue();
		        		g.setColor(setting.colorTable[ (int) (Math.log(value)/Math.log(2))+1] );
		            	g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);
		            	
		            	String s = String.valueOf(value);
		                g.setColor(value < 128 ? setting.colorTable[0] : setting.colorTable[1]);
		                g.setFont(new Font("SansSerif", Font.BOLD, 80));
		                FontMetrics fm = g.getFontMetrics();
		                int asc = fm.getAscent();
		                int dec = fm.getDescent();
		            	int x = 215 + c * 121 + (106 - fm.stringWidth(s)) / 2;
		                int y = 115 + r * 121 + (asc + (106 - (asc + dec)) / 2);
		            	g.drawString(s, x, y);
		        	}
		      }
		  }
	  }
	  else if(setting.gamestate == setting.State.start)
	  {
		  //重新填充游戏所在的方框位置,以达到覆盖效果
		  g.setColor(setting.startColor);
	      //g.fillRoundRect(215, 115, 469, 469, 7, 7);
		  g.fillRect(0, 0, 900, 700);
		  g.setColor(setting.gridColor.darker().darker());
		  //绘制开始游戏的字符串信息
		  g.setFont(new Font("SansSerif", Font.BOLD, 128));
		  g.drawString("2048", 310, 270);
		  g.setFont(new Font("SansSerif", Font.BOLD, 40));
		  g.drawString("点击鼠标开始游戏", 310, 400);
		  g.drawString("通过方向键盘操作", 310, 500);
	  }
	  else if(setting.gamestate == setting.State.over)
	  {
		//重新填充游戏所在的方框位置,以达到覆盖效果
		  g.setColor(setting.startColor);
	      //g.fillRoundRect(215, 115, 469, 469, 7, 7);
		  g.fillRect(0, 0, 900, 700);
		  g.setColor(setting.gridColor.darker().darker());
		  g.setFont(new Font("SansSerif", Font.BOLD, 40));
		  g.drawString("四个方向都已无法移动，游戏失败", 310, 270);
		  g.drawString("点击鼠标重新开始游戏", 310, 400);
	  }
	  else if(setting.gamestate == setting.State.won)
	  {
		  g.setColor(setting.startColor);
	      //g.fillRoundRect(215, 115, 469, 469, 7, 7);
		  g.fillRect(0, 0, 900, 700);
		  g.setColor(setting.gridColor.darker().darker());
		  g.setFont(new Font("SansSerif", Font.BOLD, 40));
		  g.drawString("最大值已达到"+setting.target+"，胜利", 310, 270);
		  g.drawString("点击鼠标重新开始游戏", 310, 400);
	  }
  }

  //start_merge_pos开始合并的位置
  private void move(int start_merge_pos,int incx,int incy) {
	  int now=start_merge_pos;
	  //只有两种取值
	  //setting.sides*setting.sides,  -1
	  for(int i=0;i<setting.sides*setting.sides;i++)
	  {
		  //从最后一个块往前数
		  if(start_merge_pos==setting.sides*setting.sides)
			  now--;
		  else
			  now++;
		  int row=now/setting.sides;
		  int col=now%setting.sides;
		  int nextrow=row+incx;
		  int nextcol=col+incy;

		  //没有越界的情况下
		  while((nextrow<0||nextrow>=setting.sides||
				  nextcol<0||nextcol>=setting.sides)==false)
		  {
			  if(tiles[row][col]==null)
				  break;
			  
			  //如果下一个块是空且当前块不为空
			  else if(tiles[nextrow][nextcol]==null)
			  {
				  tiles[nextrow][nextcol]=new Tile();
				  int value=tiles[row][col].getvalue();
				  boolean merged=tiles[row][col].getmerged();
				  tiles[nextrow][nextcol].setvalue(value);
				  tiles[nextrow][nextcol].setmerged(merged);
				  tiles[row][col]=null;
			  }
			  
			  //考虑合并两个块的问题
			  else if(tiles[nextrow][nextcol].getvalue()
				  ==tiles[row][col].getvalue())
			  	{
				  	//达到合并条件
				  	if(tiles[nextrow][nextcol].getmerged()==false&&
				  	tiles[row][col].getmerged()==false)
				  	{
				  		tiles[nextrow][nextcol].setmerged(true);
				  		int value=tiles[row][col].getvalue()*2;
				  		tiles[nextrow][nextcol].setvalue(value);
				  		tiles[row][col]=null;
				  		if(value==setting.target)
				  		{
				  			setting.gamestate =setting.State.won;
				  			break;
				  		}
				  	}
			  	}
			  row=nextrow;col=nextcol;
		  	  nextrow=nextrow+incx;nextcol=nextcol+incy;
		  }
	  }
	  //将所有merged置为false,表示下一轮move时还可以合并
	  clear_setmerged();
	  

	   
	  //并非所有的块都已经被占据
	  if(have_emptytile()==true)
			  addRandomTile();
	  //如果不存在空块,如果不可以通过合并继续移动
	  //那游戏结束
	  else if(checkalive()==false)
		  setting.gamestate=setting.State.over;
	  //如果不存在空块,且可以通过合并继续移动
	  //此时不能添加新的tile
  }
  
  
  private void clear_setmerged()
  {
	  for(int row=0;row<setting.sides;row++)
		  for(int col=0;col<setting.sides;col++)
			  if(tiles[row][col]!=null)
			  tiles[row][col].setmerged(false);
  }
  
  private boolean have_emptytile() {
	  for(int row=0;row<setting.sides;row++)
		  for(int col=0;col<setting.sides;col++)
			  if(tiles[row][col]==null)
				  return true;
	  return false;
  }	
  
  private void addRandomTile() {
	  int r,c;
	  do {
	  //随机生成在某个位置
	  int pos=rand.nextInt(setting.sides*setting.sides);
	  r=pos/setting.sides;
	  c=pos%setting.sides;
	  }while(tiles[r][c]!=null);
	  

	  //确定生成的数是4还是2
	  int i=rand.nextInt(10);
	  if(i==0)
		  {
		  	tiles[r][c]=new Tile(4);
		  	setting.score=setting.score+4;
		  }
	  else
		  {
		  	tiles[r][c]=new Tile(2);
		  	setting.score=setting.score+2;
		  }
	  }
  
  private boolean moveUp() {
    move(-1,-1,0);
    return true;
  }

  private boolean moveDown() {
	  move(setting.sides*setting.sides,1,0);
	  return true;
  }

  private boolean moveLeft() {
	  move(-1,0,-1);
	  return true;
  }

  private boolean moveRight() {
	  move(setting.sides*setting.sides,0,1);
	  return true;
  }
  
  //检验是否还可以通过合并块进行移动
  private boolean checkalive() {
	  return checkup()||checkdown()||checkleft()||checkright();
  }
  private boolean checkup() {
	  return checkmove(-1,-1,0);
  }
  private boolean checkdown() {
	  return checkmove(setting.sides*setting.sides,1,0);
  }
  private boolean checkleft() {
	  return checkmove(-1,0,-1);
  }
  private boolean checkright() {
	  return checkmove(setting.sides*setting.sides,0,1);
  }
  
  private boolean checkmove(int start_merge_pos,int incx,int incy) {
	  int now=start_merge_pos;
	  //只有两种取值
	  //setting.sides*setting.sides,  -1
	  for(int i=0;i<setting.sides*setting.sides;i++)
	  {
		  //从最后一个块往前数
		  if(start_merge_pos==setting.sides*setting.sides)
			  now--;
		  else
			  now++;
		  int row=now/setting.sides;
		  int col=now%setting.sides;
		  int nextrow=row+incx;
		  int nextcol=col+incy;

		  //没有越界的情况下
		  while((nextrow<0||nextrow>=setting.sides||
				  nextcol<0||nextcol>=setting.sides)==false)
		  {			  
			  //考虑合并两个块的问题
			  if(tiles[nextrow][nextcol]!=null&&
				tiles[row][col]!=null&&
			tiles[nextrow][nextcol].getvalue()==tiles[row][col].getvalue())
			  	{
				  	//达到合并条件
				  	if(tiles[nextrow][nextcol].getmerged()==false&&
				  	tiles[row][col].getmerged()==false)
				  	{
				  		return true;
				  	}
			  	}
			  row=nextrow;col=nextcol;
		  	  nextrow=nextrow+incx;nextcol=nextcol+incy;
		  }
	  }
	  return false;
  }
  
  
}