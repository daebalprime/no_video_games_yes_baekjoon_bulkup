package bj_10996;

import java.util.Scanner;

public class Main {
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println("*");
			return;
		}
//		int N = 2;
		map = new char[2*n][n];
		
		for(int i = 0; i < n*2; i++) {
			for(int j = 0; j < n; j++) {
				if(j % 2 == i % 2)
					map[i][j] = '*';
			}
		}
		
//		int x = n%2 == 1 ? -(i%2) : i%2;
		for (int i = 0; i < 2*n; i++) {
			for (int j = 0; j < n-(n%2 != 0 ? (i%2) : (i+1)%2); j++) {
				char c = map[i][j];
				System.out.print(c == '*'? c : " ");
			}
//			System.out.print('!');
			System.out.println();
		}
	}
}
