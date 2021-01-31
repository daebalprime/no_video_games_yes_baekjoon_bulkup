package bj_2525;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt()*60 + sc.nextInt() + sc.nextInt();
		System.out.println(t%(24*60)/60 + " " + t%60);
	}

}
