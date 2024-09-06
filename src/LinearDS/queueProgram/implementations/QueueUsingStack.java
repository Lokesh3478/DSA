package LinearDS.queueProgram.implementations;

import java.util.Stack;

public class QueueUsingStack {
	Stack<Integer>lifo = new Stack<>();
    Stack<Integer>fifo = new Stack<>();
    public void push(int x) {
        while(!lifo.isEmpty()){
            fifo.push(lifo.pop());
        }
        lifo.push(x);
        while(!fifo.isEmpty()){
            lifo.push(fifo.pop());
        }
    }
    
    public int pop() {
        return lifo.pop();
    }
    
    public int peek() {
        return lifo.peek();
    }
    
    public boolean empty() {
        return lifo.isEmpty();  
    }
}
