package LinearDS.stackProgram.implementations;

import java.util.LinkedList;
import java.util.Queue;

class QueueStack {
    Queue<Integer>q = new LinkedList<>();
    int n = 0;
    public QueueStack() {}
    public void push(int x) {
        q.add(x);
        int temp = n;
        while(temp>0){
            q.add(q.remove());
            temp--;
        }
        n++;
    }
    
    public int pop() {
        n--;
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}