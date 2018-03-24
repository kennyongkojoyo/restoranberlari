//KELAS ASISTEN
//Asisten.java

public class Asisten implements Runnable{
	private String name;
	 Point posa;
	
	public Asisten(String name){
		this.name = name;
		this.posa = new Point();
	}
	
	public void run(){
		System.out.println("Asisten "+name+" sedang bergerak.");
		//Asisten ngapain
		
	}
	
	class Point{
		private int x;
		private int y;
		
		public Point(){
			x = 0;
			y = 0;
		}
		
		public int getX () {
			return this.x;
		}
		
		public int getY () {
			return this.y;
		}
		
		public void setX (int x) {
			this.x = x;
		}
		
		public void setY (int y) {
			this.y = y;
		}
	}
	
	public void setPosA(int x, int y){
		posa.setX(x);
		posa.setY(y);
	}
}
