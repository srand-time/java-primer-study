package Settings;

import java.awt.Color;

public final class setting {

	public enum State {
	    start, won, running, over
	  }

	  //��ͬȡֵ���ڸ���ֵ��ͬ�Ŀ���ϲ�ͬ����ɫ
	public final static Color[] colorTable = {
	      new Color(0x701710), new Color(0xFFE4C3), new Color(0xfff4d3),
	      new Color(0xffdac3), new Color(0xe7b08e), new Color(0xe7bf8e),
	      new Color(0xffc4c3), new Color(0xE7948e), new Color(0xbe7e56),
	      new Color(0xbe5e56), new Color(0x9c3931), new Color(0x701710)};


	
	  //��Ϸʤ��ʱ��Ŀ��÷�
	public final static int target = 2048;

	  //��ͼ��ֵ���Ŀ����ֵ
	//��Ϊÿ�κϲ��궼�ж�һ�ºϲ����Ƿ�ﵽĿ��÷�
	//public static int highest=2;
	  
	  //��ͼ�����п������ֵ�����÷�
	public static int score=0;

	  //���ø��ֱ�����ɫ��������ʼ����͸���
	  public final static Color gridColor = new Color(0xBBADA0);
	  public final static Color emptyColor = new Color(0xCDC1B4);
	  public final static Color startColor = new Color(0xFFEBCD);

	  public final static int sides = 4;
	  //��ͼ��С

	  public static State gamestate = State.start;
	  //��ʼ״̬����
}
