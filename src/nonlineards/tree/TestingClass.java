package nonlineards.tree;

import java.util.Random;

public class TestingClass {
	public static void main(String[] args) {
		BinarySearchTree<Integer>intBst = new BinarySearchTree<>();
		BinarySearchTree<Employee>e1 = new BinarySearchTree<Employee>((a,b)->{
			return a.getSalary()-b.getSalary();
		});
		Random random = new Random();
		for(int i=0;i<10;i++) {
			int r = random.nextInt(51);
			intBst.insert(r);
		}
		intBst.bfs();
		intBst.inorder();
		System.out.println();
		random = new Random();
		Random rChar = new Random();
		for(int i=0;i<=10;i++) {
			int r = random.nextInt(50000);
			char ch = (char)('a'+random.nextInt(26));
			e1.insert(new Employee(String.valueOf(ch), r));
		}
		e1.bfs();
		e1.inorder();
		System.out.println();
	}
}
class Employee{
	private String name;
	private int salary;
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name: "+name+" salary:"+salary;
	}
	
	
	
}
