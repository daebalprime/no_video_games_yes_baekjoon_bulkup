package bj_10039;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			int t = sc.nextInt();
			if(t < 40) {
				t = 40;
			}
			sum += t;
		}
		System.out.println(sum/5);
	}

}
