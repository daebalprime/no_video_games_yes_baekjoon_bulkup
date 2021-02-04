package bj_16505;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static char[][] map;
	static void recursive(int n, int x, int y) {
		if(n == 0) {
			map[x][y] = '*';
			return;
		}
		for(int i = 0; i < (int)Math.pow(2, n); i++) {
			for(int j = 0; j < (int)Math.pow(2, n)-i; j++) {
				if(i==0 || j==0 || i+j ==Math.pow(2, n)-1) {
					map[x+i][y+j] = '*';
				}
			}
		}
		recursive(n-1,x,y);
		recursive(n-1,x+(int)Math.pow(2, n-1),y);
		recursive(n-1,x,y+(int)Math.pow(2, n-1));
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = sc.nextInt();
//		int T = 6;
		map = new char[(int)Math.pow(2, T)][(int)Math.pow(2, T)];
		recursive(T,0,0);
		sc.close();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < (int)Math.pow(2, T); i++) {
			for(int j = 0; j < (int)Math.pow(2, T)-i; j++) {
				if(map[i][j] == '*') {
					sb.append('*');
				}
				else sb.append(' ');
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
