package tpBonus4;

public class DemoQueue {
	
	public static void main(String[] args) {
		Dequeue<Integer> deQueue = new Dequeue<Integer>();
		
		deQueue.addFirst(1);
		deQueue.addFirst(2);
		deQueue.addFirst(3);
		deQueue.addFirst(4);
		
		deQueue.addLast(5);
		deQueue.addLast(6);
		deQueue.addLast(7);
		deQueue.addLast(8);
		
		System.out.println(deQueue.getFirst());
		System.out.println(deQueue.getLast());
		
		System.out.println(deQueue);
		System.out.println("Nombre d'éléments : " + deQueue.size());
	}
	
}
