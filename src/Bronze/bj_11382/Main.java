package Bronze.bj_11382;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] t = sc.nextLine().split(" ");
		int a = Integer.parseInt(t[0]);
		int b = Integer.parseInt(t[1]);
		int c = Integer.parseInt(t[2]);
		
		System.out.println(a+b+c);
		sc.close();
	}

}