package LinearDS.stackProgram.implementations;

import java.util.Scanner;

import LinearDS.LinkedList.SinglyLinkedList;

public class LinkedStack {
	SinglyLinkedList top;
    boolean empty(){
        return top==null;
    }
    void push(int a) {
       if(top==null) {
    	   top = new SinglyLinkedList();
       }
       top.insert(0, a);
    }
    int pop() {
        if(empty()) return -1;
        int val = top.get(0);
        top.deleteAt(0);
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
