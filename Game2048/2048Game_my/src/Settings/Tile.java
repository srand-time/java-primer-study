package Settings;

public class Tile {
	//在某次移动时是否已经合并过,同一次移动下一个块只进行一次合并
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
