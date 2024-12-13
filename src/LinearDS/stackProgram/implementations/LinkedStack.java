package LinearDS.stackProgram.implementations;

import java.util.Scanner;

import LinearDS.LinkedList.SinglyLinkedList;

public class LinkedStack {
	SinglyLinkedList top;
    public boolean isEmpty(){
        return top==null;
    }
    public void push(int a) {
       if(top==null) {
    	   top = new SinglyLinkedList();
       }
       top.insert(0, a);
    }
    public int pop() {
        if(isEmpty()) return -1;
        int val = top.get(0);
        top.deleteAt(0);
        return val;
    }
    public int peek() {
        if(isEmpty()) return -1;
        int val = top.get(0);
        return val;
    }
    public static void main(String[] args) {
		LinkedStack stk = new LinkedStack();
		stk.push(10);
		stk.push(20);
		System.out.println(stk.pop());
		System.out.println(stk.pop());
	}
}
