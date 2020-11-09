package grafos;

import java.util.HashSet;
import java.util.Iterator;

public class minHashSet implements Iterable<Arista>{
	private Arista min;
	private HashSet<Arista> set;
	
	public minHashSet() {
		set = new HashSet<>();
	}
	
	public void add(Arista data) {
		if(min==null) 
			min = data;
		else {
			if(min.compareTo(data)>=0) {
				set.add(min);
				min = data;
			}
			else {
				set.add(data);
			}
		}
	}
	
	public Arista getMin() {
		Arista m=min;
		min = null;
		return m;
	}
	
	public void remove(Arista data) {
		set.remove(data);
	}
	
	@Override
	public String toString() {
		return min+set.toString();
	}

	@Override
	public Iterator<Arista> iterator() {
		return set.iterator();
	}
	
	public int size() {
		return set.size()+1;
	}
}
