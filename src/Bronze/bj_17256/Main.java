package Bronze.bj_17256;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[6];
		for (int i = 0; i < 6; i++) {
			n[i] = sc.nextInt();
		}
		System.out.println((n[3]-n[2])+" "+(n[4]/n[1]+" "+(n[5]-n[0])));

	}

}
