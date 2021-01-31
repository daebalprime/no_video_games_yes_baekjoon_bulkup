package bj_4299;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); 
		int b = sc.nextInt();
		if(!((a%2 == 0)^(b%2 ==0)) && a>=b ) {			
			System.out.println((a+b)/2 + " " + (Math.abs(a-b)/2));
		}
		else {
			System.out.println("-1");
		}
	}

}
