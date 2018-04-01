import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class Mahasiswa {
	
	protected String name;
	protected String nim;
	protected Node currentLocation;
	protected World world = World.getInstance();
	protected World pathfindingMap;
	protected boolean suspended;

	public Mahasiswa(String name, String nim) {
		this.name = name;
		this.nim = nim;
		setCurrentLocation(0,0);
	}

	protected void setCurrentLocation(int x, int y) {
		currentLocation = world.getNode(x, y);
	}


	protected void setCurrentLocation(Node location) {
		currentLocation = location;
	}

/*	public static void toggleSuspend() {
		suspended = !suspended;
	}*/


}
