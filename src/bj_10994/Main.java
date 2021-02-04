package bj_10994;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static char[][] map;
	static void recur(int n, int x, int y) {
		if(n == 1) {
			map[x][y] = '*';
			return;
		}
		for(int i = 0; i < 4*n-3; i++) {
			for(int j = 0; j < 4*n-3; j++) {
				if(i == 0 || j == 0 || i == (4*n-4) || j == (4*n-4)) {
					map[x+i][x+j] = '*';
				}
			}
		}
		recur(n-1, x+2, y+2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		int N = 2;
		map = new char[4*N-3][4*N-3];
		recur(N,0,0);
		for (char[] ca : map) {
			for (char c : ca) {
				System.out.print(c == '*'? c : " ");
			}
			System.out.println();
		}
	}
}
