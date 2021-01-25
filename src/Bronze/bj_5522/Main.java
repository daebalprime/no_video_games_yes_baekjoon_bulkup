package Bronze.bj_5522;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		while(sc.hasNextInt()) {
			answer += sc.nextInt();
		}
		System.out.println(answer);
	}
}
