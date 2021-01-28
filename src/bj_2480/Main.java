package bj_2480;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] dices = new int[3];
		for (int i = 0; i < 3; i++) {
			dices[i] = sc.nextInt();
		}
		if(dices[0]==dices[1] && dices[1]== dices[2]) {
			System.out.println(dices[0]*1000+10000);
		}
		else if(dices[0]==dices[1]) {
			System.out.println(1000+dices[0]*100);
		}
		else if(dices[1]==dices[2]) {
			System.out.println(1000+dices[1]*100);
		}
		else if(dices[0]==dices[2]) {
			System.out.println(1000+dices[0]*100);
		}
		else {
			System.out.println(Math.max(Math.max(dices[0], dices[1]),dices[2])*100);
		}
		sc.close();
	}

}
