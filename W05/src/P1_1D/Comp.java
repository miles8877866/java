package P1_1D;

public class Comp {

	private int x, y, z;
	
	public Comp() {
		
	}
	
	public Comp(int x,int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int sum() {
		
		return x + y + z;
	}
	
	public int max() {
		
		if(x >= y && x >= z)
			return x;
		else if(y >= x && y >= z)
			return y;
		else
			return z;
	}
	
	public int min() {
		if(x <= y && x <= z)
			return x;
		else if(y <= x && y <= z)
			return y;
		else
			return z;	
	}
	
	
}
