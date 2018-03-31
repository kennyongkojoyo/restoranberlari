//Asisten.java
import java.util.*;

public class Asisten extends Mahasiswa implements Runnable {
	
	private static int jumlahAsisten;
	private static int toHelp = 5;
	private int countWorkDone;
	private Praktikan inquirer;
	private Direction direction;
	private Pathfinder pathfinder = Pathfinder.getInstance();
	//private static boolean bantuan = false;

	public Asisten(String name, String nim) {
		super(name, nim);
		jumlahAsisten++;
		countWorkDone = 0;
	}

	public String getName() {
		return name;
	}

	public static int getJumlahAsisten() {
		return jumlahAsisten;
	}

	public void testPrint() {
		System.out.println(name + " " + nim);
		System.out.println(currentLocation.toString());
	}

	private void moveTo(Node destination) {
		//ArrayDeque<Node> path = pathfinding(destination);
		Stack<Node> path = pathfinder.getPath(currentLocation, destination);

		if (!path.empty()) { 
			Node buang = path.pop();
		} else {System.out.println("Empty"); }

		while (!path.empty()) {
			Node temp = path.pop();
			String value = (temp.toString());
			setCurrentLocation(temp);
			System.out.println(name + " is moving to " + temp.toString());
		} 

		System.out.println(name + " has arrived at " + destination.toString());
	}

	private String answerQuestion(Question question) {
		String answer = ScanInput.getString();

		return answer;
	}

	private void handleInquirer() {
		if (!QuestionerQueue.isEmpty()) {

			inquirer = QuestionerQueue.getFromQueue();
			moveTo(inquirer.getLocation());

			if (inquirer.getInquiry() == Inquiry.FIX_COMPUTER) {
				System.out.println("Coba pindah komputer dulu ya..");
				inquirer.moveToNewComputer();
			} else if (inquirer.getInquiry() == Inquiry.QUESTION) {
				inquirer.receiveAnswer(answerQuestion(inquirer.askQuestion()));
			}
			
			inquirer = null;
			countWorkDone++;
		}

		if (toHelp > (-1)) {
			toHelp--;
		}
	}

	private static void callDuktek() {
		Thread duktek = new Thread(Duktek.getInstance());
		System.out.println("Sebentar ya manggil pak duktek dulu");
	}

	private void pingsan() {
		try { 
			System.out.println(getName() + " pingsan");
			Thread.currentThread().sleep(5000);
		} 
		catch(InterruptedException e) {}
		countWorkDone = 0;
	}
	
	
	public static void panggilBantuan() {

		//Ganti ke world.add asisten aja nanti
		Asisten Robert = new Asisten("Robert", "13514084");
		Asisten Raudi = new Asisten("Raudi", "13514001");
		
		Thread a2 = new Thread(Robert);
		Thread a3 = new Thread(Raudi);
		
		a2.start();
		a3.start();
	}

	@Override
	public void run() {
		while (true) {
			if (!suspended) {
				if (!QuestionerQueue.isEmpty()) {
					if (countWorkDone == 10) {
						pingsan();
					} else {
						handleInquirer();
					}
					if (toHelp == 0) {
						panggilBantuan();
					}
				} else { 
					try { 
						Thread.currentThread().sleep(1000);
					} 
					catch(InterruptedException e) {}
				}
			} else {
			}
		}

	}


}
