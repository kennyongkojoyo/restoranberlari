//Praktikan.java
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.lang.InterruptedException;
import java.util.ArrayDeque;

public class Praktikan extends Mahasiswa implements Runnable{
	/* Atribut turunan */
	//protected String name;
	//protected String nim;
	//protected Node currentLocation;
	//protected World world = World.getInstance();
	//protected World pathfindingMap;
	
	/* Atribut Praktikan sendiri */
	private QuestionList qlist; //Daftar pertanyaan praktikan
	private Inquiry inquiry;
	private Question currentQuestion;
	
	//Konstruktor
	public Praktikan(String name, String nim, Node loc) {
		super(name, nim);
		this.qlist = new QuestionList();
		this.setCurrentLocation(loc.getX(), loc.getY());
		currentLocation.setAvailable(false);
	}
	
	//Setter
	public void setName(String name) {
		this.name = name;
	}
	
	//Getter
	public String getName() {
		return(name);
	}
	
	public Node getLocation() {
		return(this.currentLocation);
	}
	
	//Inner Class
	
	//Method

	private void raiseHand() {
		if (!currentLocation.computerIsActive()) {
			inquiry = Inquiry.FIX_COMPUTER;
		} else {
			inquiry = Inquiry.QUESTION;
			currentQuestion = qlist.getRandomQuestion();
		}

		System.out.println(this.getName() +": KAK... KAK...");
		QuestionerQueue.addToQueue(this);
		
	}

	public Inquiry getInquiry() {
		return inquiry;
	}

	public Question askQuestion() {
		System.out.println(name + ": " + currentQuestion.getStringQuestion());
		return currentQuestion;
	}

	private void askAgain() {
		QuestionerQueue.addToQueue(this);
		System.out.println(this.getName() + ": KAK... KAK... Ini masih salah…");
	}

	public void receiveAnswer(String answer) {
		if (!answer.equals(currentQuestion.getAnsQuestion())) {
			askAgain();
		} else {
			System.out.println(this.getName() + ": Terima kasih kak");
			currentQuestion = null;
		}
	}

	public void moveToNewComputer() {
		Node newPlace = null;
		try {
			newPlace = (Pathfinder.findComputer(currentLocation));
		} catch (NullPointerException e) {
			System.out.println("Ga ada komputer lagi nih");
		}
		if (newPlace != null) {
			currentLocation.setAvailable(true);
			setCurrentLocation(newPlace);
			newPlace.setAvailable(false);
			System.out.println("Praktikan " + name + " pindah ke " + newPlace.toString());
		} else {
			suspended = true;
		}
	}
	
	@Override
	public void run() {
		Random rand = new Random();
		int eta; //Estimated Time to Ask

		while(true) { //Parameter while diubah sesuai kondisi akhir game;
			if (!suspended) {	
				eta = rand.nextInt(20) + 5;
				try {
					TimeUnit.SECONDS.sleep(eta);
				}
				catch (InterruptedException e) { 
					// Restore the interrupted status
					Thread.currentThread().interrupt();
				}

				if (currentLocation.computerIsActive()) {
					if (currentQuestion == null) {
						raiseHand();
					}
				} else {
					raiseHand();
				}

			} else {
			}
		} 
	}
}
