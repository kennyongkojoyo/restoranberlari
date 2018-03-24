//KELAS ASISTEN
//Asisten.java

public class Asisten implements Runnable{
	private String name;
	
	private Asisten(String name){
		this.name = name;
	}
	
	public void run(){
		System.out.println("Asisten "+name+" sedang bergerak.");
		//Asisten ngapain
	}	
}
