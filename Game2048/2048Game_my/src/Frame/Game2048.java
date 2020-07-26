//ת�ԣ�
//https://git.nowcoder.com/11000160/2048-java/blob/master/Game2048.java
//�����ע��

package Frame;
import Settings.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


public class Game2048 extends JPanel {
	//�����
	private Random rand = new Random();
	
	//�ؿ�
	private Tile [][]tiles;

  public Game2048() {
    setPreferredSize(new Dimension(900, 700));    //���ڴ����û�����
    //setSize,setLocation,setBounds������Ҫ�ڲ�ʹ�ò��ֹ�������ʱ��ʹ�ã�
    //Ҳ����setLayout(null)��ʱ�����ʹ���������������Ʋ��֡�
    //setPreferredSize��Ҫ��ʹ�ò��ֹ�������ʱ��ʹ��,
    //���ֹ��������ȡ�ռ��preferredsize�����������Ч��
    
    
    //setBackground(new Color(0xFAF8EF));           //������ɫ����
    //setFont(new Font("SansSerif", Font.BOLD, 48));//��������
    setFocusable(true);					
    //һ������ڻ�ý���(focus)��ʱ��, ������ϵļ����¼����������ܲ�������¼� 

    //������
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        startGame();
        //����startGame�����״̬�жϣ�����gamestateȷ�����Ƿ���һ���µ���Ϸ
        //���Կ���ֻҪһ�����͵��ò���������

        repaint();
        //��������startGame����Ҫ��ͬһ�����������»�����Ϸ���ݣ�������Ҫrepaint
        //����ÿ��Ҫ���ƽ����ʱ�򶼼�һ��repaintҲû�й�ϵ��
      }
    });
    

    //���̼���
    //ͨ�����·�������ö�Ӧ��move����
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
		  //��ʱ��û�и���tiles,��Ȼ��Ҫ�Լ�newÿһ��tiles
		  addRandomTile();
		  addRandomTile();
	  }
  }
  
  //���ƽ���ģ��
  @Override
  public void paintComponent(Graphics g) {

	  if(setting.gamestate == setting.State.running) 
	  {		  
		  g.setColor(setting.startColor);
		  g.fillRect(0,0,900,700);
		  //���Ʒ����ַ���
		  g.setColor(setting.gridColor.darker().darker());
		  g.setFont(new Font("SansSerif", Font.BOLD, 40));
		  String s1 = String.valueOf(setting.score);
		  g.drawString("��ǰ�÷�:"+s1, 300, 650);
		  
		  
		  g.setColor(setting.gridColor);
		  g.fillRoundRect(200, 100, 500, 500, 15, 15);
		  
		  //���°�����������
		  //ÿ�ζ����»������еĿ�,��Ϊÿ���ƶ������кϲ�
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
		  //���������Ϸ���ڵķ���λ��,�Դﵽ����Ч��
		  g.setColor(setting.startColor);
	      //g.fillRoundRect(215, 115, 469, 469, 7, 7);
		  g.fillRect(0, 0, 900, 700);
		  g.setColor(setting.gridColor.darker().darker());
		  //���ƿ�ʼ��Ϸ���ַ�����Ϣ
		  g.setFont(new Font("SansSerif", Font.BOLD, 128));
		  g.drawString("2048", 310, 270);
		  g.setFont(new Font("SansSerif", Font.BOLD, 40));
		  g.drawString("�����꿪ʼ��Ϸ", 310, 400);
		  g.drawString("ͨ��������̲���", 310, 500);
	  }
	  else if(setting.gamestate == setting.State.over)
	  {
		//���������Ϸ���ڵķ���λ��,�Դﵽ����Ч��
		  g.setColor(setting.startColor);
	      //g.fillRoundRect(215, 115, 469, 469, 7, 7);
		  g.fillRect(0, 0, 900, 700);
		  g.setColor(setting.gridColor.darker().darker());
		  g.setFont(new Font("SansSerif", Font.BOLD, 40));
		  g.drawString("�ĸ��������޷��ƶ�����Ϸʧ��", 310, 270);
		  g.drawString("���������¿�ʼ��Ϸ", 310, 400);
	  }
	  else if(setting.gamestate == setting.State.won)
	  {
		  g.setColor(setting.startColor);
	      //g.fillRoundRect(215, 115, 469, 469, 7, 7);
		  g.fillRect(0, 0, 900, 700);
		  g.setColor(setting.gridColor.darker().darker());
		  g.setFont(new Font("SansSerif", Font.BOLD, 40));
		  g.drawString("���ֵ�Ѵﵽ"+setting.target+"��ʤ��", 310, 270);
		  g.drawString("���������¿�ʼ��Ϸ", 310, 400);
	  }
  }

  //start_merge_pos��ʼ�ϲ���λ��
  private void move(int start_merge_pos,int incx,int incy) {
	  int now=start_merge_pos;
	  //ֻ������ȡֵ
	  //setting.sides*setting.sides,  -1
	  for(int i=0;i<setting.sides*setting.sides;i++)
	  {
		  //�����һ������ǰ��
		  if(start_merge_pos==setting.sides*setting.sides)
			  now--;
		  else
			  now++;
		  int row=now/setting.sides;
		  int col=now%setting.sides;
		  int nextrow=row+incx;
		  int nextcol=col+incy;

		  //û��Խ��������
		  while((nextrow<0||nextrow>=setting.sides||
				  nextcol<0||nextcol>=setting.sides)==false)
		  {
			  if(tiles[row][col]==null)
				  break;
			  
			  //�����һ�����ǿ��ҵ�ǰ�鲻Ϊ��
			  else if(tiles[nextrow][nextcol]==null)
			  {
				  tiles[nextrow][nextcol]=new Tile();
				  int value=tiles[row][col].getvalue();
				  boolean merged=tiles[row][col].getmerged();
				  tiles[nextrow][nextcol].setvalue(value);
				  tiles[nextrow][nextcol].setmerged(merged);
				  tiles[row][col]=null;
			  }
			  
			  //���Ǻϲ������������
			  else if(tiles[nextrow][nextcol].getvalue()
				  ==tiles[row][col].getvalue())
			  	{
				  	//�ﵽ�ϲ�����
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
	  //������merged��Ϊfalse,��ʾ��һ��moveʱ�����Ժϲ�
	  clear_setmerged();
	  

	   
	  //�������еĿ鶼�Ѿ���ռ��
	  if(have_emptytile()==true)
			  addRandomTile();
	  //��������ڿտ�,���������ͨ���ϲ������ƶ�
	  //����Ϸ����
	  else if(checkalive()==false)
		  setting.gamestate=setting.State.over;
	  //��������ڿտ�,�ҿ���ͨ���ϲ������ƶ�
	  //��ʱ��������µ�tile
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
	  //���������ĳ��λ��
	  int pos=rand.nextInt(setting.sides*setting.sides);
	  r=pos/setting.sides;
	  c=pos%setting.sides;
	  }while(tiles[r][c]!=null);
	  

	  //ȷ�����ɵ�����4����2
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
  
  //�����Ƿ񻹿���ͨ���ϲ�������ƶ�
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
	  //ֻ������ȡֵ
	  //setting.sides*setting.sides,  -1
	  for(int i=0;i<setting.sides*setting.sides;i++)
	  {
		  //�����һ������ǰ��
		  if(start_merge_pos==setting.sides*setting.sides)
			  now--;
		  else
			  now++;
		  int row=now/setting.sides;
		  int col=now%setting.sides;
		  int nextrow=row+incx;
		  int nextcol=col+incy;

		  //û��Խ��������
		  while((nextrow<0||nextrow>=setting.sides||
				  nextcol<0||nextcol>=setting.sides)==false)
		  {			  
			  //���Ǻϲ������������
			  if(tiles[nextrow][nextcol]!=null&&
				tiles[row][col]!=null&&
			tiles[nextrow][nextcol].getvalue()==tiles[row][col].getvalue())
			  	{
				  	//�ﵽ�ϲ�����
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