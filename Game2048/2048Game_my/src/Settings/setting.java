package Settings;

import java.awt.Color;

public final class setting {

	public enum State {
	    start, won, running, over
	  }

	  //不同取值用于给数值不同的块加上不同的颜色
	public final static Color[] colorTable = {
	      new Color(0x701710), new Color(0xFFE4C3), new Color(0xfff4d3),
	      new Color(0xffdac3), new Color(0xe7b08e), new Color(0xe7bf8e),
	      new Color(0xffc4c3), new Color(0xE7948e), new Color(0xbe7e56),
	      new Color(0xbe5e56), new Color(0x9c3931), new Color(0x701710)};


	
	  //游戏胜利时的目标得分
	public final static int target = 2048;

	  //地图上值最大的块的数值
	//改为每次合并完都判断一下合并后是否达到目标得分
	//public static int highest=2;
	  
	  //地图上所有块的总数值当作得分
	public static int score=0;

	  //设置各种背景颜色，包括起始界面和格子
	  public final static Color gridColor = new Color(0xBBADA0);
	  public final static Color emptyColor = new Color(0xCDC1B4);
	  public final static Color startColor = new Color(0xFFEBCD);

	  public final static int sides = 4;
	  //地图大小

	  public static State gamestate = State.start;
	  //初始状态设置
}
