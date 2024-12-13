package LinearDS.PriorityQueue;

public class TestingClass {
	public static void main(String[] args) {
		PriorityQueue<Integer>pq = new PriorityQueue<Integer>(5,(a,b)->{
			return b-a;
		});
		for(int i=0;i<=100;i++) {
			pq.add(i);
			System.out.println(pq);
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}
}
