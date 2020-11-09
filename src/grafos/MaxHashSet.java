package grafos;

import java.util.HashSet;
import java.util.Iterator;

public class MaxHashSet implements Iterable<Arista>{
	private Arista max;
	private HashSet<Arista> set;
	
	public MaxHashSet() {
		set = new HashSet<>();
	}
	
	public void add(Arista data) {
		if(max==null) 
			max = data;
		else {
			if(max.compareTo(data)<=0) {
				set.add(max);
				max = data;
			}
			else {
				set.add(data);
			}
		}
	}
	
	public Arista getMax() {
		Arista m=max;
		max = null;
		return m;
	}
	
	public void remove(Arista data) {
		set.remove(data);
	}
	
	@Override
	public String toString() {
		return max+set.toString();
	}

	@Override
	public Iterator<Arista> iterator() {
		return set.iterator();
	}
	public int size() {
		return set.size()+1;
	}
	public boolean containsAll(HashSet<Arista> mst) {
		HashSet<Arista> clon=(HashSet<Arista>) set.clone();
		clon.add(max);
		return clon.containsAll(mst);
	}
}
