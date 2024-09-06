package LinearDS.LinkedList;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SinglyLinkedList{
	private ReentrantLock nodeLock = new ReentrantLock(true);
	private Condition notEmpty = nodeLock.newCondition();
	private Condition notFull = nodeLock.newCondition();
	private class Node{
		int val;
		Node next;
		
		public Node(int val) {
			super();
			this.val = val;
		}

		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		
	}
	private Node head,tail;
	private int size = 0;
	
	public SinglyLinkedList() {
	}
	
	public SinglyLinkedList(int startValue) {
		Node newNode = new Node(startValue,head);
		head = newNode;
		tail = newNode;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public void rangeCheck(int i) {
		if(i<0||i>=size) {
			throw new IndexOutOfBoundsException(i+" Array Index Out Of Bound");
		}
	}
	
	private void insertAtBeginning(int val) {
		Node newNode = new Node(val,head);
		head = newNode;
		if(tail==null) {
			tail = head;
		}
		size++;
	}
	
	//GetNodeReference
	private Node getNode(int n) {
		try {
			rangeCheck(n);
		}
		catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		Node pointer = head;
		for(int i =0;i<n;i++) {
			pointer = pointer.next;
		}
		return pointer;
	}
	
	
	//Append Node at end
	public void append(int val) {
		Node newNode = new Node(val);
		if(tail==null) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	
	//Insertion at nth Position
	public void insert(int n,int val){
		this.head = insertRec(n,val,head);
	}
	//Recursive Insertion
	private Node insertRec(int n,int val,Node node) {
		if(n==0) {
			size++;
			return new Node(val,node);
		}
		if(node==null) {
			throw new ArrayIndexOutOfBoundsException(n+" Array Index Out Of Bound");
		}
		node.next = insertRec(n-1,val,node.next);
		return node;
	}
	
	//Delete Node 
	public void deleteAt(int n) {
		try {
			rangeCheck(n);
			if(n==0) {
				head = head.next;
			}
			else {
				Node prevNode = getNode(n-1);
				prevNode.next = prevNode.next.next;
				if (prevNode.next == null) {
	                tail = prevNode;
	            }
			}
			size--;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAll(int n) {
		Node ptr = head;
		while(ptr!=null&&ptr.next!=null) {
			if(ptr.val==ptr.next.val) {
				ptr.next = ptr.next.next;
			}
			else {
				ptr = ptr.next;
			}
		}
	}
	
	//PrintList
	
	public String printList() {
		Node pointer = head;
		String out = "";
		out+="{";
		while(pointer!=null) {
			out+=" "+pointer.val;
			pointer = pointer.next;
		}
		out+="}";
		return out;
	}
	
	//Sort list
	public Node findMid(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node slow = head,fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;
        return mid;
    }
	public void sortList() {
		sortList(this.head);
	}
    public Node sortList(Node head) {
        Node res = head;
        if(head!=null&&head.next!=null){
            Node mid = findMid(head);
            Node left = sortList(head);
            Node right = sortList(mid);
            res = merge(left,right);
        }
        return res;
    }
    public Node merge(Node l1,Node l2){
        Node res = new Node(0);
        Node tail = res;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        tail.next = l1!=null?l1:l2;
        return res.next;
    }
    
    //Get Value
    public int get(int i) {
    	return this.getNode(i).val;
    }
	
	
	public static void main(String[] args) {
		
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(0);
        list.append(2);
        list.append(4);
        list.append(3);
        list.append(1);
        list.append(10);
        System.out.println(list.printList());
        list.sortList();
        System.out.println(list.printList());
        }
}
