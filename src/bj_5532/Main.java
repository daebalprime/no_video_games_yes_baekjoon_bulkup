package bj_5532;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		System.out.println(L-Math.max((int)Math.ceil((double)A / C),(int)Math.ceil((double)B / D)));
	}

}
