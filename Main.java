import java.util.Scanner;



public class Main {
	/*public static int getNo () {
		return no;
	}*/
	
	public static void main (String[] args) {
		Praktikan p1 = new Praktikan ();
		Praktikan p2 = new Praktikan ();
		System.out.println(p1.pos.getX());
		System.out.println(p1.pos.getY());
		System.out.println(p2.pos.getX());
		System.out.println(p2.pos.getY());
		/*p1.tanya();
		System.out.println(p1.q.getQ());
		Scanner sc = new Scanner (System.in);
		String ans = sc.next();
		p1.checkAns(ans);
		System.out.println(p1.getTf());*/
		PraktikumBuilder pb = new PraktikumBuilder ();
		pb.printRoom();
		for (int i = 1; i <= 2; i++) {
			pb.Insert(2*(i % 3) - 1, 2*(i / 3) + 1, i);
		}
		System.out.println("");
		pb.printRoom();
		
		Grid2d map2d = new Grid2d(pb.getMap(),false);
		
		Asisten a1 = new Asisten("a");
		pb.Insert(a1.posa.getX(),a1.posa.getY(), 9);
		pb.printRoom();
		System.out.println(map2d.findPath(a1.posa.getX(), a1.posa.getY(), p1.pos.getX(), p1.pos.getY()));
		//Jawab pertanyaan
		
		//Posisi asisten ganti ke posisi praktikum sebelumnya
		a1.setPosA(p1.pos.getX(),p1.pos.getY());
		pb.Insert(a1.posa.getX(),a1.posa.getY(), 9);
		System.out.println("");
		pb.printRoom();
	}
}
