package bj_10997;

import java.io.*;
import java.util.Scanner;

public class Main {
	static boolean[][] map;
	static int N;
	private static void recursive(int n, int x, int y) {
		if(n==1) {
			for(int i = 0; i < 3; i++) {				
				map[y+i][x] = true;
			}
			return;
		}
		for(int j = 0; j < 4*n-1; j++) {
			for(int i = 0; i < 4*n-3; i++) {
				if(i == 0 || j == 0  || i == 4*n-4 || j == 4*n-2 || (j == 2 && i == 4*n-5)) {
					if(i == 4*n-4 && j == 1) continue;
					map[y+j][x+i] = true;
				}
			}
		}
		recursive(n-1, x+2, y+2);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		if(N == 1) {
			System.out.println("*");
			return;
		}
		map = new boolean[4*N-1][4*N-3];
		recursive(N, 0, 0);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (boolean[] m : map) {
			if(i == 1) sb.append("*");
			else {				
				for(boolean c : m) {
					sb.append(c?"*":" ");
				}
			}
			sb.append("\n");
			i++;
		}		
		br.write(sb.toString());
		br.flush();
	}
}
