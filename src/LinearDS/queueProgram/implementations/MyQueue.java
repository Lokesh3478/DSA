package LinearDS.queueProgram.implementations;
class QueueException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public QueueException() {
		super();
	}
	public QueueException(String message) {
		super(message);
	}
	
}
public class MyQueue {
	int front = 0;
	int rear = -1;
	int data[];
	public MyQueue() {
		this.data = new int[10];
	}
	public MyQueue(int size) {
		this.data = new int[size];
	}
	public boolean isFull() {
		return rear-front+1==data.length;
	}
	public boolean isEmpty() {
		return rear<front;
	}
	public synchronized void add(int val){
		if(isFull()) {
			throw new QueueException("Queue is full");
		}
		rear++;
		data[rear%data.length] = val;
	}
	public synchronized int remove()throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		int val = data[front%data.length];
		front++;
		return val;
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue(10);
		for(int i =0;i<=30;i++) {
			if(i>=10&&(i%2==0)) {
				System.out.println(i);
				System.out.println( q.remove());
			}
			else {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}

}
