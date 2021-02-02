package bj_10872;

import java.util.Scanner;

public class Main {
	static int factorial(int n, int mid) {
		if(n<=1) return mid;
		return factorial(n-1, mid*n);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n,1));
	}
}
