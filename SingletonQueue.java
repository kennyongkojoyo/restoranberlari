import java.util.*;

public class SingletonQueue<A>{
	private static SingletonQueue queueIns = null;
	private Queue<A> queue = new LinkedList<A>();
	
	public static SingletonQueue getIns(){
		if (queueIns == null){
			queueIns = new SingletonQueue();
		}
		return queueIns;
	}
	
	public Queue<A> getQueue(){
		return queue;
	}
	
	public void add(A a){
		synchronized (queue){
			queue.add(a);
		}
	}
	
	public void remove(A a) {
		synchronized (queue) {
			queue.remove(a);
		}
	}
	
	public A poll() {
		A a = queue.poll();
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
