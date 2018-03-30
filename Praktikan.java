//Praktikan.java

//Praktikan.java

import java.util.Random;

public class Praktikan {
	Point pos;
	private static int no = 0;
	QuestionGenerator q;
	private boolean tf;
	
	public Praktikan () {
		this.pos = new Point ();
		this.no++;
		this.tf = true;
		this.q = new QuestionGenerator();
	}
	
	public static int getNo () {
		return no;
	}
	
	class QuestionGenerator {
		private String q;
		
		public QuestionGenerator () {
			Random rand = new Random();
			int  n = rand.nextInt(3) + 1;
			if (n == 1) {
				q = "1 + 1 = ?";
			}
			else if (n == 2) {
				q = "Siapa nama dosen OOP?";
			}
			else {
				q = "Siapa nama ketua kelas STI 16?";
			}
		}
		
		public String getQ () {
			return this.q;
		}
		
	}
	
	public void tanya () {
		q = new QuestionGenerator ();
	}
	
	public void run () {
		tanya();
		Main2.q.add(this);
		System.out.println(this.getPQ());
		try {
			Thread.sleep(1000);
		}
		
		catch (InterruptedException e) {
			System.out.println("Interrupted!");
		}
	}
	
	public void checkAns (String ans) {
		boolean check = !true;
		
		if (q.getQ().equals("1 + 1 = ?")){
			if (ans.equals("2")){
				check = true;
			}else{
				check = false;
			}
		}else if (q.getQ().equals("Siapa nama dosen OOP?")){
			if (ans.equalsIgnoreCase("Riza")){
				check = true;
			}else{
				check = false;
			}
		}else if (q.getQ().equals("Siapa nama ketua kelas STI 16?")){
			if (ans.equalsIgnoreCase("Mbarz")){
				check = true;
			}else{
				check = false;
			}
		//}else{
		//	check = !false;
		}
		this.tf = check;
	}
	
	public boolean getTf () {
		return this.tf;
	}
	
	public void setTf (boolean tf) {
		this.tf = tf;
	}
	
	public String getPQ(){
		return q.getQ();
	}
	
	public Point getPos () {
		return this.pos;
	}
}


