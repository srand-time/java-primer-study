package Settings;

public class Tile {
	//��ĳ���ƶ�ʱ�Ƿ��Ѿ��ϲ���,ͬһ���ƶ���һ����ֻ����һ�κϲ�
	private boolean merged=false;
	private int value;
	
	public Tile() {
	}
	public Tile(int value) {
		this.value=value;
	}

	public int getvalue()
	{
		return value;
	}
	
	public void setvalue(int value)
	{
		this.value=value;
	}
	
	public void setmerged(boolean merged)
	{
		this.merged=merged;
	}
	
	public boolean getmerged()
	{
		return merged;
	}
}
