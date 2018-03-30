public class Existence<A>{
	private A obj;
	private int exist;
	
	public Existence(A obj, int exist){
		this.obj = obj;
		this.exist = 1;
	}
	
	public void setObject(){ // untuk existence level praktikan dan wall
		this.exist = 10;
	}
}
