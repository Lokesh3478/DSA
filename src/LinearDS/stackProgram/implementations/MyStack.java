package LinearDS.stackProgram.implementations;
class StackException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public StackException(String message) {
		
		super(message);
	}
}
public class MyStack {
	protected int arr[];
	int top = -1;
	private final int default_size = 10;
	public MyStack(){
		this.arr = new int[default_size];
	}
	public MyStack(int n) {
		this.arr = new int[n];
	}
	public boolean isFull() {
		return top==arr.length-1;
	}
	public boolean isEmpty() {
		return top<0;
	}
	public synchronized void push(int data)throws StackException {
		if(isFull()) {
			int temp[] = new int[2*arr.length];
			for(int i =0;i<arr.length;i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
		arr[++top] = data;
	}
	public synchronized int pop()throws StackException {
		if(isEmpty()) {
			throw new StackException("Stack is Empty");
		}
		return arr[top--];
	}
	public static void main(String[] args) {
		MyStack stack = new MyStack(10);
		for(int i =0;i<=10;i++) {
			stack.push(i);
		}
		for(int i =0;i<=11;i++) {
			System.out.println(stack.pop());
		}
	}
	
}
