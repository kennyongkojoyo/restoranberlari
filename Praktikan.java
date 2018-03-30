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
	
	class Point {
		private int x;
		private int y;
		
		public Point () {
			Random rand1 = new Random();
			this.x = rand1.nextInt(10) + 1;
			Random rand2 = new Random();
			this.y = rand2.nextInt(10) + 1;
		}
		
			
		public int getX () {
			return this.x;
		}
		
		public int getY () {
			return this.y;
		}
		
		public void setX (int X) {
			this.x = x;
		}
		
		public void setY (int y) {
			this.y = y;
		}
		
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
}
