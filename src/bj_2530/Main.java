package bj_2530;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tot = 3600*sc.nextInt() + 60*sc.nextInt() + sc.nextInt() + sc.nextInt(); 
		System.out.println((tot / 3600)%24 + " " + (tot/60)%60 + " " + tot%60);
	}

}
