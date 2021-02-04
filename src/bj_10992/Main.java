package bj_10992;

import java.util.Scanner;

public class Main {
	static boolean[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new boolean[n][2*n-1];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 2*n-1; j++) {
				if(i + j == n-1 || i - j == -n+1 || i==n-1) {
//				if((i + j) % 2 == (n+1) % 2 ) {
					map[i][j] = true;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n+i; j++) {
				boolean b = map[i][j];
				if(b) System.out.print("*");
				else System.out.print(" ");
					
				
			}
			System.out.println();
		}
	}

}
