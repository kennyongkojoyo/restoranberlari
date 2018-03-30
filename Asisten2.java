//KELAS ASISTEN
//Asisten.java

public class Asisten implements Runnable{
	Point posA;
	Scanner ask = new Scanner(System.in);
	ReentrantLock lock = new ReentrantLock();
	
	
	public Asisten(int x, int y){
		this.posA = new Point(x,y);
	}
	
	public isThere(Point p){
		return ((posA.getX == p.getX) && (posA.getY == p.getY));
	}
	
	public boolean checkAns(Praktikan p, String ans){
		boolean check = false;
		
		if (p.getPQ().equals("1 + 1 = ?"){
			if (ans.equals("2")){
				check = true;
			}else{
				check = false;
			}
		}else if (p.getPQ().equals("Siapa nama dosen OOP?")){
			if (ans.equalsIgnoreCase("Riza")){
				check = true;
			}else{
				check = false;
			}
		}else if (p.getPQ().equals("Siapa nama ketua kelas STI 16?")){
			if (ans.equalsIgnoreCase("Mbarz")){
				check = true;
			}else{
				check = false;
			}
		}
		return check;
	}
	
	public void run(){
		lock.lock();
		Praktikan pout = Main.q.poll();
		
		while (!isThere(pout.getPos()){ //cara akses queuenya gimana
			if (posA.getX() < pout.getPos().getX()){
				map.moveRight(posA.getX(),posA.getY); //map msh belum inisialisasi
				int nx = posA.getX()++;
				posA.setX(nx);
				
			}else if (posA.getX() > pout.getPos().getX()){
				map.moveLeft(posA.getX(),posA.getY);
				int nx = posA.getX()--;
				posA.setX(nx);
				
			}else if (posA.getY() < pout.getPos().getY()){
				map.moveUp(posA.getX(),posA.getY);
				int ny = posA.getY()++;
				posA.setY(ny);
				
			}else if (posA.getY() > pout.getPos().getY()){
				map.moveDown(posA.getX(),posA.getY);
				int ny = posA.getY()--;
				posA.setY(ny);
			}
			map.printRoom(); //map msh belum inisialisasi
			Thread.sleep(3000);
			
		}
		//System.out.println(...) pertanyaannya
		System.out.println(q.getPQ());
		String ans = ask.nextLine();
		if (!checkAns(pout,ans)){
			//salah jawab
			System.out.println("Jawaban salah");
			Main.q.add(pout);
		}
		
		lock.unlock();
	}
	
	class Point{
		private int x;
		private int y;
		
		public Point(){
			x = 0;
			y = 0;
		}
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
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
