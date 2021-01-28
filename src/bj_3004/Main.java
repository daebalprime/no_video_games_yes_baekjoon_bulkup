package bj_3004;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		int a = sc.nextInt();
		int result = 2;
		for (int i = 2; i <= a; i++) {
			System.out.println(i+ " " +  (((i-2)/2)+2));
			result += (((i-2)/2)+2);
		}
		System.out.println(result);

	}

}
