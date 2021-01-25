package Bronze.bj_8437;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		System.out.println((a/2 + b/2) + "\n" + (a/2 - b/2));
		sc.close();
	}

}
