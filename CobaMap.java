import java.io.*;
import java.util.Scanner;

public class CobaMap{
	public static void main(String[] args){
		Existence<String> p1 = new Existence<String>("P",10);
		Existence<String> p2 = new Existence<String>("Q",10);
		Existence<String> p3 = new Existence<String>("R",10);
		Existence<String> p4 = new Existence<String>("S",10);
		
		Existence<String> a1 = new Existence<String>("A",10);
		Existence<String> a2 = new Existence<String>("B",10);
		
		Existence<String> pc = new Existence<String>(".",1);
		Existence<String> border = new Existence<String>("#",100);
		
		Map room = new Map(10,10,pc,border);
		room.printRoom();
		
		Existence<String> wall = new Existence<String>("|",100);
		
		try{
			Scanner sc = new Scanner(new File("posisi.txt"));
			int a = sc.nextInt();
			int b = sc.nextInt();
			room.insert(a,b,p1);
		}
		catch (IOException e){
			System.err.println("file error");
		}
		//room.insert(3,4,p2);
		//room.insert(2,3,p3);
		//room.insert(7,8,p4);
		//room.insert(1,1,a1);
		//room.insert(1,2,a2);
		//room.insert(6,6,wall);
		room.printRoom();
	}
}
