package nonlineards.tree;

import java.util.Scanner;
public class BinaryTree<T> {
	private Node<T> root;
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
	}
	public BinaryTree(Node<T> root) {
		this.root = root;
	}
	public void insert(T data) {
		
		Scanner sc = new Scanner(System.in);
		root = insert(root,data,sc);
		sc.close();
	}
	public Node<T> insert(Node<T> root,T data,Scanner sc) {
		if(root==null) {
			return new Node<T>(data);
		}
		System.out.println("Current Node:"+data.toString());
		loop1 : while(true) {
			System.out.println("Enter 1 for left or 2 for right");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				root.left = insert(root.left,data,sc);
				break loop1;
			case 2:
				root.right = insert(root.right,data,sc);
				break loop1;
			case 3:
				System.out.println("Invalid Option");
			}
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
		inorder(root.right);
		System.out.println(root.toString());
	}
}
