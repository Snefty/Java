package tpBonus4;

import java.util.ArrayList;

public class Dequeue<E> {

	private int size;
	private Cell<E> first;
	private Cell<E> last;
	
	public Dequeue() {
		new ArrayList<E>();
		this.size = 0;
		this.first = this.last = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void addFirst(E e) {
		this.first = new Cell<E>(e);
	}
	
	public void addLast(E e) {
		this.last = new Cell<E>(e);
	}
	
	public void addAll(Iterable<E> c) {
		for (E e : c) {
			addLast(e);
		}
	}

	public Cell<E> getFirst() {
		return first;
	}

	public Cell<E> getLast() {
		return last;
	}
	
	public Cell<E> removeFirst() {
		return null;
	}
	
}
