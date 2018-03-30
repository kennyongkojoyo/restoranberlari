import java.util.*;

public class SingletonQueue{
	private static SingletonQueue queueIns = null;
	private Queue queue = new LinkedList();
	
	public static SingletonQueue getIns(){
		if (queueIns == null){
			queueIns = new SingletonQueue();
		}
		return queueIns;
	}
	
	public Queue getQueue(){
		return queue;
	}
	
	public void add(Praktikan a){
		synchronized (queue){
			queue.add(a);
		}
	}
	
	public void remove(Praktikan a) {
		synchronized (queue) {
			queue.remove(a);
		}
	}
	
	public Praktikan poll() {
		Praktikan a = (Praktikan)queue.poll();
		return a;
	}
 
	// Returns true if this collection contains no elements
	public boolean isEmpty() {
		return queue.isEmpty();
	}
 
	// Returns the number of elements in this collection. If this collection
	// contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE
	public int getTotalSize() {
		return queue.size();
	}
}

