package bj_1297;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		double t = Math.sqrt(b*b+c*c);
		System.out.println((int)(b*(a/t)) + " " +(int)(c*(a/t)));
	}

}
