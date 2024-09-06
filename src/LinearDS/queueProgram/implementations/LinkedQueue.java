package LinearDS.queueProgram.implementations;

import LinearDS.LinkedList.SinglyLinkedList;

public class LinkedQueue {

	SinglyLinkedList queue;
	
	public LinkedQueue() {
		this.queue = new SinglyLinkedList();
	}

	public void add(int data) {
		queue.append(data);
	}
	public int remove() {
		int val = -1;
		if(queue.size()>0) {
			val = queue.get(0);
			queue.deleteAt(0);
		}
		return val;
	}
	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		queue.add(10);
		queue.add(20);
		queue.add(40);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
	
}
