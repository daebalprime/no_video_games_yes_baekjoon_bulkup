package bj_2752;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < 3; i++) {
			pq.add(sc.nextInt());
		}
		for(int i = 0; i < 3; i++) {
			System.out.print(pq.poll()+" ");
		}
		
	}

}
