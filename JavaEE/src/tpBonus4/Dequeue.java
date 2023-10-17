package tpBonus4;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
		int size = 0;

		Cell<E> ce = getFirst();
		while(ce.next != null){
			size++;
			ce = ce.next;
		}

		ce = getLast();
		while(ce.next != null){
			size++;
			ce = ce.next;
		}

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
		if(this.first == null) {
			this.first = new Cell<E>(e);
		}else {
			Cell<E> ce = new Cell<E>(e);
			this.first.next = ce;
			ce.prev = this.first;
			this.first = ce;
			
			ce.next = this.first;
			ce.next.prev = ce;
			this.first = ce; 
		}
	}

	public void addLast(E e) {
		if(this.last == null) {
			this.last = new Cell<E>(e);
		}else {
			Cell<E> ce = new Cell<E>(e);
			this.last.next = ce;
			ce.prev = this.last;
			this.last = ce;
		}
	}

	public void addAll(Iterable<E> c) {
		for (E e : c) {
			addLast(e);
		}
	}

	public Cell<E> getFirst() throws NoSuchElementException{
		Cell<E> ce = this.first;
		while(ce.prev != null) {
			ce = ce.prev;
		}

		return ce;
	}

	public Cell<E> getLast() throws NoSuchElementException{
		Cell<E> ce = this.last;
		while(ce.prev != null) {
			ce = ce.prev;
		}

		return ce;
	}

	public Cell<E> removeFirst() throws NoSuchElementException{
		Cell<E> ce = getFirst();

		ce.next.prev = null;

		return ce;
	}

	public Cell<E> removeLast() throws NoSuchElementException{
		Cell<E> ce = getLast();

		ce.next.prev = null;

		return ce;
	}

	public String toString() {
		String l = " -> ";

		Cell<E> ce = getFirst();
		while(ce.next != null){
			if(ce.next.next == null && this.last == null) {
				l += ce;
			}else {
				l += ce  + ",";
			}
			ce = ce.next;
		}

		ce = getLast();
		while(ce.next != null){
			if(ce.next.next == null) {
				l += ce;
			}else {
				l += ce  + ",";
			}
			ce = ce.next;
		}
		return l;
	}

}
