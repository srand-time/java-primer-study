//转自：
//https://git.nowcoder.com/11000160/2048-java/blob/master/Game2048.java
//添加了注释

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Game2048 extends JPanel {

  //enum枚举，这里感觉是当一个可以取多值的布尔变量用。
  //private State gamestate = State.start;
  //gamestate =State.over;
  enum State {
    start, won, running, over
  }

  //不同取值用于给数值不同的块加上不同的颜色
  final Color[] colorTable = {
      new Color(0x701710), new Color(0xFFE4C3), new Color(0xfff4d3),
      new Color(0xffdac3), new Color(0xe7b08e), new Color(0xe7bf8e),
      new Color(0xffc4c3), new Color(0xE7948e), new Color(0xbe7e56),
      new Color(0xbe5e56), new Color(0x9c3931), new Color(0x701710)};

  //游戏胜利时的目标得分
  final static int target = 2048;

  //地图上值最大的块的数值
  static int highest;
  
  //地图上所有块的总数值当作得分
  static int score;

  //设置各种背景颜色，包括起始界面和格子
  private Color gridColor = new Color(0xBBADA0);
  private Color emptyColor = new Color(0xCDC1B4);
  private Color startColor = new Color(0xFFEBCD);

  private Random rand = new Random();

  private Tile[][] tiles;
  //tiles = new Tile[side][side];
  //Tile 地块,这是这个文件里面自己定义的。

  private int side = 4;
  //地图大小

  private State gamestate = State.start;
  //初始状态设置

  private boolean checkingAvailableMoves;
  //是否开启检验模式,检验模式下调用moveUp,moveDown 等方法不会移动。

  public Game2048() {
    setPreferredSize(new Dimension(900, 700));    //用于创建用户界面
    //setSize,setLocation,setBounds方法需要在不使用布局管理器的时候使用，
    //也就是setLayout(null)的时候可以使用这三个方法控制布局。
    //setPreferredSize需要在使用布局管理器的时候使用,
    //布局管理器会获取空间的preferredsize，因而可以生效。
    
    
    setBackground(new Color(0xFAF8EF));           //背景颜色设置
    setFont(new Font("SansSerif", Font.BOLD, 48));//字体设置
    setFocusable(true);					
    //一个组件在获得焦点(focus)的时候, 该组件上的键盘事件监听器才能捕获键盘事件 

    //鼠标监听
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        repaint();
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

  
  //paint只会负责重画容器类的界面例如：Frame   Dialog   Window之类的，
  //而在这些容器之上的组件则由paint委托paintComponent负责重画。
  
  //repaint()方法会告知Swing尽快重绘该组件。重绘时会调用该组件的paint()方法，而paint()方法会
  //继续依次调用paintComponent、paintBorder、paintChildren三个方法来完成绘制。
  @Override
  public void paintComponent(Graphics gg) {
    //super.paintComponent(gg);
    //Graphics2D g = (Graphics2D) gg;
    //g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    //	RenderingHints.VALUE_ANTIALIAS_ON);
    drawGrid(gg);
  }
  

  void startGame() {
    //如果游戏不是处于正在运行状态就重新运行游戏
    if (gamestate != State.running) {
      score = 0;
      highest = 0;
      gamestate = State.running;
      tiles = new Tile[side][side];
      //System.out.println(tiles[0][0]==null);
      //这么new对象之后tiles不是null了
      //但是tiles[0][0]这些具体的某个位置的tiles还是null
      addRandomTile();
      addRandomTile();
    }
  }

  void drawGrid(Graphics g) {
    g.setColor(gridColor);
    
    //fillRoundRect,绘制圆角矩形
    g.fillRoundRect(200, 100, 500, 500, 15, 15);

    if(gamestate == State.running) {
      //由于初始图形是一个gridColor的圆角矩形
      //所以只要每次在这个大圆角矩形中填充一部分
      //就可以搞出十六宫格的效果
      for (int r = 0; r < side; r++) {
        for (int c = 0; c < side; c++) {
          if (tiles[r][c] == null) {
            g.setColor(emptyColor);
            g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);
          } 
          
          else {
            drawTile(g, r, c);
            //r,c相当于row,col
          }
        }
      }
    } 
    
    	//如果游戏不是处于正在运行状态
    	//那么就不用绘制网格了
    	//然后根据情况绘制字符串
      else {
      g.setColor(startColor);
      g.fillRoundRect(215, 115, 469, 469, 7, 7);

      g.setColor(gridColor.darker());
      
      //绘制完2048这几个字之后又重新设置成了较小的字体
      g.setFont(new Font("SansSerif", Font.BOLD, 128));
      g.drawString("2048", 310, 270);

      g.setFont(new Font("SansSerif", Font.BOLD, 20));

      if (gamestate == State.won) {
        g.drawString("you made it!", 390, 350);

      } 
      
      else if (gamestate == State.over)
        g.drawString("game over", 400, 350);

      g.setColor(gridColor);
      g.drawString("click to start a new game", 330, 470);
      g.drawString("(use arrow keys to move tiles)", 310, 530);
    }
  }

  
  void drawTile(Graphics g, int r, int c) {
    int value = tiles[r][c].getValue();
    //相当于log2(value)
    g.setColor(colorTable[(int) (Math.log(value) / Math.log(2)) + 1]);
    g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);
    String s = String.valueOf(value);

    g.setColor(value < 128 ? colorTable[0] : colorTable[1]);

    FontMetrics fm = g.getFontMetrics();
    int asc = fm.getAscent();
    int dec = fm.getDescent();

    int x = 215 + c * 121 + (106 - fm.stringWidth(s)) / 2;
    int y = 115 + r * 121 + (asc + (106 - (asc + dec)) / 2);

    g.drawString(s, x, y);
  }


  private void addRandomTile() {
    int row, col;
    do {
      //pos = (pos + 1) % (side * side);
      
      int pos = rand.nextInt(side * side);
      //nextInt(n)将返回一个大于等于0小于n的随机数
      row = pos / side;
      col = pos % side;
    } while (tiles[row][col] != null);

    //设定有十分之一的概率新生成的是一个4而不是2
    int val = rand.nextInt(10) == 0 ? 4 : 2;
    tiles[row][col] = new Tile(val);
  }

  //moveDown: move(side * side - 1, 1, 0)
  //调用方式 moveUp{move(0, -1, 0);}
  //要明确到底是在检验是否可以移动
  //还是正真按下键盘之后需要执行移动操作
  private boolean move(int countDownFrom, int yIncr, int xIncr) {
    boolean moved = false;

    for (int i = 0; i < side * side; i++) {
      int j = Math.abs(countDownFrom - i);
      //countDownFrom是用来保证优先级的
      //比方说如果下移,那么这个时候要从最后一行最后一列的那个块开始
      //算能否结合,不然就会出现一列2220,结合成了0420什么的

      int r = j / side;
      int c = j % side;

      //直到找到第一个不为null的块
      if (tiles[r][c] == null)
        continue;

      //next为尝试与下一个块合并的位置
      int nextR = r + yIncr;
      int nextC = c + xIncr;

      //当仍在地图范围内,依次对该行或该列的地块进行检验。
      //moveUp,moveDown什么的可以通过yIncr,xIncr控制检验方向
      while (nextR >= 0 && nextR < side && nextC >= 0 && nextC < side) {
        Tile next = tiles[nextR][nextC];
        Tile curr = tiles[r][c];

        if (next == null) {
        
        //如果是在检验模式下,下一个块是null,那就证明有可行的移动
          if (checkingAvailableMoves)
            return true;

          //如果是在非检验模式下,就把cur块移动到next块的位置
          //并且更新cur块和next块的位置,因为是用while循环做的判断，需要在这里更新
          tiles[nextR][nextC] = curr;
          tiles[r][c] = null;
          r = nextR;
          c = nextC;
          nextR += yIncr;
          nextC += xIncr;
          moved = true;
        } 
        
        //能够合并,如果在非检验模式下进行合并
        //检验模式下返回true表示有可行的移动
        else if (next.canMergeWith(curr)) {
          if (checkingAvailableMoves)
            return true;

          int value = next.mergeWith(curr);
          if (value > highest)
            highest = value;
          score += value;
          tiles[r][c] = null;
          moved = true;
          //break;
          r = nextR;
          c = nextC;
          nextR += yIncr;
          nextC += xIncr;
        } 
        
        //当次移动无效,什么也不做。
        else
          break;
      }
    }

    if (moved) {
      if (highest < target) {
        clearMerged();
        addRandomTile();
        if (!movesAvailable()) {
          gamestate = State.over;
        }
      } else if (highest == target)
        gamestate = State.won;
    }

    return moved;
  }

  boolean moveUp() {
    return move(0, -1, 0);
  }

  boolean moveDown() {
    return move(side * side - 1, 1, 0);
  }

  boolean moveLeft() {
    return move(0, 0, -1);
  }

  boolean moveRight() {
    return move(side * side - 1, 0, 1);
  }

  void clearMerged() {
    for (Tile[] row : tiles)
      for (Tile tile : row)
        if (tile != null)
          tile.setMerged(false);
  }

  //判断是否有能够移动的办法
  //如果四个方向都不能移动游戏就结束了
  boolean movesAvailable() {
    checkingAvailableMoves = true;
    boolean hasMoves = moveUp() || moveDown() || moveLeft() || moveRight();
    checkingAvailableMoves = false;
    return hasMoves;
  }

  
  public static void main(String[] args) {
    //可以注释掉这个SwingUtilities.invokeLater
	//SwingUtilities.invokeLater()方法使事件派发线程上的可运行对象排队。
	//当可运行对象排在事件派发队列的队首时，
	//就调用其run方法。其效果是允许事件派发线程调用另一个线程中的任意一个代码块。
	  SwingUtilities.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setTitle("2048");
      f.setResizable(true);
      f.add(new Game2048(), BorderLayout.CENTER);
      f.pack();
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class Tile {
  private boolean merged;
  private int value;

  //这个地块的数值
  Tile(int val) {
    value = val;
  }

  //获取某个地块的数值
  int getValue() {
    return value;
  }

  void setMerged(boolean m) {
	  //这个merged的意思是控制能否合并
	  //因为一次移动只能合并一次,合并一次之后就不能再合并了
	  //此时就要把merged置为false
    merged = m;
  }

  //是否能与另一个块合并
  boolean canMergeWith(Tile other) {
    return !merged && other != null && !other.merged && value == other.getValue();
  }

  //尝试与另一个块合并，合并成功返回合并后的值
  //也就是原值的两倍。失败了的话返回-1。
  int mergeWith(Tile other) {
    if (canMergeWith(other)) {
      value *= 2;
      merged = true;
      return value;
    }
    return -1;
  }
}