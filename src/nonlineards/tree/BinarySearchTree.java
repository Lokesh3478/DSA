package nonlineards.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
public class BinarySearchTree<T> {
	private Node<T> root;
	private Comparator<T>comparator;
	static class Node<T>{
		T data;
		private Node<T> left;
		private Node<T> right;
		
		public Node(T data, Node<T> left, Node<T> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public Node(T data) {
			super();
			this.data = data;
		}

		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node<T> getLeft() {
			return left;
		}
		public void setLeft(Node<T> left) {
			this.left = left;
		}
		public Node<T> getRight() {
			return right;
		}
		public void setRight(Node<T> right) {
			this.right = right;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return data.toString();
		}
		
	}
	public BinarySearchTree() {
	}
	
	
	public BinarySearchTree(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}


	public void insert(T data) {
		if(comparator!=null) {
			root = insertByComparator(root,data);
		}
		else {
			try {
				Comparable<? super T>compData = (Comparable<? super T>)(data); 
				root = insertByComparable(root, compData);
			}
			catch(ClassCastException e) {
				throw new ClassCastException("data is not a object of comparable. No comparators provided");
			}
		}
	}
	public Node<T> insertByComparator(Node<T> root,T data) {
		if(root==null) {
			return new Node<T>(data);
		}
		if(comparator.compare(root.data, data)<1) {
			root.right = insertByComparator(root.right, data);
		}
		else {
			root.left = insertByComparator(root.left, data);
		}
		return root;
		
	}
	public Node<T> insertByComparable(Node<T>root,Comparable<? super T>compData) {
		if(root==null) {
			return new Node<T>((T)compData);
		}
		if(compData.compareTo(root.data)>=1) {
			root.right = insertByComparable(root.right, compData);
		}
		else {
			root.left = insertByComparable(root.left, compData);
		}
		return root;

		
	}
	public void inorder() {
		inorder(root);
	}
	private void inorder(Node<T>root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.getData()+" ");
		inorder(root.right);
	}
	
	public void bfs() {
		Queue<Node<T>>q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Node<T>curr = q.poll();
				if(curr!=null) {
					System.out.print(curr.getData()+" ");
					q.add(curr.left);
					q.add(curr.right);
				}
				else {
					System.out.print(null+" ");
				}
			}
			System.out.println();
		}
	}
	public void dfs() {
		ArrayList<Node<T>>inorder = new ArrayList<>();
		ArrayList<Node<T>>preorder = new ArrayList<>();
		ArrayList<Node<T>>postorder = new ArrayList<>();
		dfs(root,1,inorder,preorder,postorder);
		System.out.print("Preorder : ");
		for(int i=0;i<preorder.size();i++) {
			System.out.print(preorder.get(i)+" ");
		}
		System.out.print("\ninorder : ");
		for(int i=0;i<inorder.size();i++) {
			System.out.print(inorder.get(i)+" ");
		}
		System.out.print("\npostorder : ");
		for(int i=0;i<postorder.size();i++) {
			System.out.print(postorder.get(i)+" ");
		}
		
	}
	
	private void dfs(Node<T> node,int label,ArrayList<Node<T>>inorder,ArrayList<Node<T>>preorder,ArrayList<Node<T>>postorder) {
		if(node==null) {
			return;
		}
		if(label==1) {
			preorder.add(node);
			dfs(node.left,1,inorder,preorder,postorder);
			dfs(node,2,inorder,preorder,postorder);
		}
		else if(label==2) {
			inorder.add(node);
			dfs(node.right,1,inorder,preorder,postorder);
			dfs(node,3,inorder,preorder,postorder);
		}
		else {
			postorder.add(node);
		}
		
	}
}
