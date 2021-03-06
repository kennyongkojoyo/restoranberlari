//KELAS ASISTEN
//Asisten2.java

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Asisten implements Runnable{
	Point posA;
	Scanner ask = new Scanner(System.in);
	ReentrantLock lock = new ReentrantLock();
	private Map map;
	
	
	public Asisten(int x, int y){
		this.posA = new Point(x,y);
	}
	
	public boolean isThere(Point p){
		return ((posA.getX() == p.getX()) && (posA.getY() == p.getY()));
	}
	
	public boolean checkAns(Praktikan p, String ans){
		boolean check = false;
		
		if (p.getPQ().equals("1 + 1 = ?")){
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
		Praktikan pout = Main2.q.poll();
		
		while (!isThere(pout.getPos())) { //cara akses queuenya gimana
			if (posA.getX() < pout.getPos().getX()){
				map.moveRight(posA.getX(),posA.getY()); //map msh belum inisialisasi
				int nx = posA.getX()+1;
				posA.setX(nx);
				
			}else if (posA.getX() > pout.getPos().getX()){
				map.moveLeft(posA.getX(),posA.getY());
				int nx = posA.getX()-1;
				posA.setX(nx);
				
			}else if (posA.getY() < pout.getPos().getY()){
				map.moveUp(posA.getX(),posA.getY());
				int ny = posA.getY()+1;
				posA.setY(ny);
				
			}else if (posA.getY() > pout.getPos().getY()){
				map.moveDown(posA.getX(),posA.getY());
				int ny = posA.getY()-1;
				posA.setY(ny);
			}
			map.printRoom(); //map msh belum inisialisasi
			try {
				Thread.sleep(3000);
			}
			
			catch (InterruptedException e) {
				System.out.println("Interrupted!");
			}
		}
		//System.out.println(...) pertanyaannya
		System.out.println(pout.getPQ());
		String ans = ask.nextLine();
		if (!checkAns(pout,ans)){
			//salah jawab
			System.out.println("Jawaban salah");
			Main2.q.add(pout);
		}
		
		lock.unlock();
	}
	
	public void setPosA(int x, int y){
		posA.setX(x);
		posA.setY(y);
	}
}
