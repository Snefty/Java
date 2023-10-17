package tpBonus4;

public class Cell<E> {
	
	final E element;
	Cell<E> prev, next;
	
	public Cell(E e) {
	this.element = e;
	this.next = this.prev = null;
	}
	
	public String toString() {
		return element + "";
	}
}
