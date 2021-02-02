package bj_10870;

import java.util.Scanner;

public class Main {
	static int fib(int c, int a1, int a2) {
		if(c<=0) return a1+a2;
		
		return fib(c-1, a2, a1+a2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		if(n==0) System.out.println("0");
		else System.out.println(fib(n-2,0,1));
		

	}

}
