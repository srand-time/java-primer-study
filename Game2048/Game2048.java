//ת�ԣ�
//https://git.nowcoder.com/11000160/2048-java/blob/master/Game2048.java
//�����ע��

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Game2048 extends JPanel {

  //enumö�٣�����о��ǵ�һ������ȡ��ֵ�Ĳ��������á�
  //private State gamestate = State.start;
  //gamestate =State.over;
  enum State {
    start, won, running, over
  }

  //��ͬȡֵ���ڸ���ֵ��ͬ�Ŀ���ϲ�ͬ����ɫ
  final Color[] colorTable = {
      new Color(0x701710), new Color(0xFFE4C3), new Color(0xfff4d3),
      new Color(0xffdac3), new Color(0xe7b08e), new Color(0xe7bf8e),
      new Color(0xffc4c3), new Color(0xE7948e), new Color(0xbe7e56),
      new Color(0xbe5e56), new Color(0x9c3931), new Color(0x701710)};

  //��Ϸʤ��ʱ��Ŀ��÷�
  final static int target = 2048;

  //��ͼ��ֵ���Ŀ����ֵ
  static int highest;
  
  //��ͼ�����п������ֵ�����÷�
  static int score;

  //���ø��ֱ�����ɫ��������ʼ����͸���
  private Color gridColor = new Color(0xBBADA0);
  private Color emptyColor = new Color(0xCDC1B4);
  private Color startColor = new Color(0xFFEBCD);

  private Random rand = new Random();

  private Tile[][] tiles;
  //tiles = new Tile[side][side];
  //Tile �ؿ�,��������ļ������Լ�����ġ�

  private int side = 4;
  //��ͼ��С

  private State gamestate = State.start;
  //��ʼ״̬����

  private boolean checkingAvailableMoves;
  //�Ƿ�������ģʽ,����ģʽ�µ���moveUp,moveDown �ȷ��������ƶ���

  public Game2048() {
    setPreferredSize(new Dimension(900, 700));    //���ڴ����û�����
    //setSize,setLocation,setBounds������Ҫ�ڲ�ʹ�ò��ֹ�������ʱ��ʹ�ã�
    //Ҳ����setLayout(null)��ʱ�����ʹ���������������Ʋ��֡�
    //setPreferredSize��Ҫ��ʹ�ò��ֹ�������ʱ��ʹ��,
    //���ֹ��������ȡ�ռ��preferredsize�����������Ч��
    
    
    setBackground(new Color(0xFAF8EF));           //������ɫ����
    setFont(new Font("SansSerif", Font.BOLD, 48));//��������
    setFocusable(true);					
    //һ������ڻ�ý���(focus)��ʱ��, ������ϵļ����¼����������ܲ�������¼� 

    //������
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        repaint();
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

  
  //paintֻ�Ḻ���ػ�������Ľ������磺Frame   Dialog   Window֮��ģ�
  //������Щ����֮�ϵ��������paintί��paintComponent�����ػ���
  
  //repaint()�������֪Swing�����ػ��������ػ�ʱ����ø������paint()��������paint()������
  //�������ε���paintComponent��paintBorder��paintChildren������������ɻ��ơ�
  @Override
  public void paintComponent(Graphics gg) {
    //super.paintComponent(gg);
    //Graphics2D g = (Graphics2D) gg;
    //g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    //	RenderingHints.VALUE_ANTIALIAS_ON);
    drawGrid(gg);
  }
  

  void startGame() {
    //�����Ϸ���Ǵ�����������״̬������������Ϸ
    if (gamestate != State.running) {
      score = 0;
      highest = 0;
      gamestate = State.running;
      tiles = new Tile[side][side];
      //System.out.println(tiles[0][0]==null);
      //��ônew����֮��tiles����null��
      //����tiles[0][0]��Щ�����ĳ��λ�õ�tiles����null
      addRandomTile();
      addRandomTile();
    }
  }

  void drawGrid(Graphics g) {
    g.setColor(gridColor);
    
    //fillRoundRect,����Բ�Ǿ���
    g.fillRoundRect(200, 100, 500, 500, 15, 15);

    if(gamestate == State.running) {
      //���ڳ�ʼͼ����һ��gridColor��Բ�Ǿ���
      //����ֻҪÿ���������Բ�Ǿ��������һ����
      //�Ϳ��Ը��ʮ�������Ч��
      for (int r = 0; r < side; r++) {
        for (int c = 0; c < side; c++) {
          if (tiles[r][c] == null) {
            g.setColor(emptyColor);
            g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);
          } 
          
          else {
            drawTile(g, r, c);
            //r,c�൱��row,col
          }
        }
      }
    } 
    
    	//�����Ϸ���Ǵ�����������״̬
    	//��ô�Ͳ��û���������
    	//Ȼ�������������ַ���
      else {
      g.setColor(startColor);
      g.fillRoundRect(215, 115, 469, 469, 7, 7);

      g.setColor(gridColor.darker());
      
      //������2048�⼸����֮�����������ó��˽�С������
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
    //�൱��log2(value)
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
      //nextInt(n)������һ�����ڵ���0С��n�������
      row = pos / side;
      col = pos % side;
    } while (tiles[row][col] != null);

    //�趨��ʮ��֮һ�ĸ��������ɵ���һ��4������2
    int val = rand.nextInt(10) == 0 ? 4 : 2;
    tiles[row][col] = new Tile(val);
  }

  //moveDown: move(side * side - 1, 1, 0)
  //���÷�ʽ moveUp{move(0, -1, 0);}
  //Ҫ��ȷ�������ڼ����Ƿ�����ƶ�
  //�������水�¼���֮����Ҫִ���ƶ�����
  private boolean move(int countDownFrom, int yIncr, int xIncr) {
    boolean moved = false;

    for (int i = 0; i < side * side; i++) {
      int j = Math.abs(countDownFrom - i);
      //countDownFrom��������֤���ȼ���
      //�ȷ�˵�������,��ô���ʱ��Ҫ�����һ�����һ�е��Ǹ��鿪ʼ
      //���ܷ���,��Ȼ�ͻ����һ��2220,��ϳ���0420ʲô��

      int r = j / side;
      int c = j % side;

      //ֱ���ҵ���һ����Ϊnull�Ŀ�
      if (tiles[r][c] == null)
        continue;

      //nextΪ��������һ����ϲ���λ��
      int nextR = r + yIncr;
      int nextC = c + xIncr;

      //�����ڵ�ͼ��Χ��,���ζԸ��л���еĵؿ���м��顣
      //moveUp,moveDownʲô�Ŀ���ͨ��yIncr,xIncr���Ƽ��鷽��
      while (nextR >= 0 && nextR < side && nextC >= 0 && nextC < side) {
        Tile next = tiles[nextR][nextC];
        Tile curr = tiles[r][c];

        if (next == null) {
        
        //������ڼ���ģʽ��,��һ������null,�Ǿ�֤���п��е��ƶ�
          if (checkingAvailableMoves)
            return true;

          //������ڷǼ���ģʽ��,�Ͱ�cur���ƶ���next���λ��
          //���Ҹ���cur���next���λ��,��Ϊ����whileѭ�������жϣ���Ҫ���������
          tiles[nextR][nextC] = curr;
          tiles[r][c] = null;
          r = nextR;
          c = nextC;
          nextR += yIncr;
          nextC += xIncr;
          moved = true;
        } 
        
        //�ܹ��ϲ�,����ڷǼ���ģʽ�½��кϲ�
        //����ģʽ�·���true��ʾ�п��е��ƶ�
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
        
        //�����ƶ���Ч,ʲôҲ������
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

  //�ж��Ƿ����ܹ��ƶ��İ취
  //����ĸ����򶼲����ƶ���Ϸ�ͽ�����
  boolean movesAvailable() {
    checkingAvailableMoves = true;
    boolean hasMoves = moveUp() || moveDown() || moveLeft() || moveRight();
    checkingAvailableMoves = false;
    return hasMoves;
  }

  
  public static void main(String[] args) {
    //����ע�͵����SwingUtilities.invokeLater
	//SwingUtilities.invokeLater()����ʹ�¼��ɷ��߳��ϵĿ����ж����Ŷӡ�
	//�������ж��������¼��ɷ����еĶ���ʱ��
	//�͵�����run��������Ч���������¼��ɷ��̵߳�����һ���߳��е�����һ������顣
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

  //����ؿ����ֵ
  Tile(int val) {
    value = val;
  }

  //��ȡĳ���ؿ����ֵ
  int getValue() {
    return value;
  }

  void setMerged(boolean m) {
	  //���merged����˼�ǿ����ܷ�ϲ�
	  //��Ϊһ���ƶ�ֻ�ܺϲ�һ��,�ϲ�һ��֮��Ͳ����ٺϲ���
	  //��ʱ��Ҫ��merged��Ϊfalse
    merged = m;
  }

  //�Ƿ�������һ����ϲ�
  boolean canMergeWith(Tile other) {
    return !merged && other != null && !other.merged && value == other.getValue();
  }

  //��������һ����ϲ����ϲ��ɹ����غϲ����ֵ
  //Ҳ����ԭֵ��������ʧ���˵Ļ�����-1��
  int mergeWith(Tile other) {
    if (canMergeWith(other)) {
      value *= 2;
      merged = true;
      return value;
    }
    return -1;
  }
}