package LinearDS.LinkedList;
public class DoublyLinkedList {
	class Node{
		int val;
		Node next,prev;
		public Node(int val, Node next, Node prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}
	Node head,tail;
	int size=0;
	//RangeCheck
	public void checkRange(int i) {
		if(i<0||i>=size) {
			throw new IndexOutOfBoundsException(" Index "+i+" Out Of Bound for length "+size);
		}
	}
	//GetNode
	private Node getNode(int i) {
		try {
			checkRange(i);
		}
		catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		Node pointer = head;
		for(int j=0;j<i;j++) {
			pointer = pointer.next;
		}
		return pointer;
	}
	//Insertion At Beginning
	public void insert(int val) {
		Node newNode = new Node(val,head,null);
		if(head!=null) {
			head.prev = newNode;
		}
		else {
			tail = newNode;
		}
		head = newNode;
		size++;
	}
	//Append Node at End
	public void append(int val) {
		Node newNode = new Node(val,null,tail);
		if(tail!=null) {
			tail.next = newNode;
		}
		else {
			head = newNode;
		}
		tail = newNode;
		size++;
	}
	//InsertAtEndPosition
	public void insert(int i,int val){
		try {
			if(i==0) {
				insert(val);
			}
			else if(i==size) {
				append(val);
			}
			else if(i>=0&&i<size){
				Node prevNode = getNode(i-1);
				Node newNode = new Node(val,prevNode.next,prevNode);
				if(prevNode.next!=null) {
					prevNode.next.prev = newNode;
				}
				else {
					tail = newNode;
				}
				prevNode.next = newNode;
				size++;
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
		catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
	}
	//Delete Node
	public void delete(int i) {
		try {
			checkRange(i);
			if(i==0) {
				head = head.next;
				head.prev = null;
			}
			else if(i==size-1) {
				tail = tail.prev;
				tail.next = null;
			}
			else {
				Node prevNode = getNode(i-1);
				prevNode.next = prevNode.next.next;
				prevNode.next.prev = prevNode;
			}
			size--;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Display Node
	public String display(boolean reverse) {
		Node pointer = !reverse?head:tail;
		String str = "{";
		while(pointer!=null) {
			str+=" "+pointer.val+",";
			pointer = !reverse?pointer.next:pointer.prev;
		}
		str+="}";
		return str;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		for(int i =0;i<=10;i++) {
			if(i%2==0) {
				dl.append(i);
			}
		}
		System.out.println(dl.display(false));
		for(int j =0;j<=10;j++) {
			if(j%2==1) {
				dl.insert(j,j);
			}
		}
		dl.insert(11,11);
		dl.insert(12,12);
		dl.insert(13,13);
		System.out.println(dl.display(false)+"\n"+dl.display(true));
		System.out.println(dl.size);
		dl.insert(15,14);
		System.out.println(dl.display(false)+"\n"+dl.display(true));
		dl.delete(0);
		dl.delete(dl.size-1);
		dl.delete(5);
		dl.delete(dl.size);
		System.out.println(dl.display(false)+"\n"+dl.display(true));
		
	}
	
	
	
}
