package nonlineards.tree;

import java.text.DateFormatSymbols;
import java.util.Random;

public class TestingClass {
	public static void main(String[] args) {
		BinarySearchTree<Integer>intBst = new BinarySearchTree<>();
		Random random = new Random();
		for(int i=0;i<=10;i++) {
			int r = random.nextInt(100);
			intBst.insert(r);
		}
		intBst.bfs();
		intBst.dfs();
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
