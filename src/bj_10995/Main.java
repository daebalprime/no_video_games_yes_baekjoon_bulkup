package bj_10995;

import java.util.Scanner;

public class Main {
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int N = 2;
		map = new char[n][2*n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][(i%2)+2*j] = '*';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2*n-((i+1)%2) ; j++) {
				char c = map[i][j];
				System.out.print(c == '*'? c : " ");
			}
			System.out.println();
		}
	}
}
