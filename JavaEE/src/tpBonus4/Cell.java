package tpBonus4;

public class Cell<E> {
	
	private final E element;
	private Cell<E> prev, next;
	
	public Cell(E e) {
	this.element = e;
	this.next = this.prev = null;
	}
	
}
