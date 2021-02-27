package bj_9252;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();

		int answer = 0;
	
		int[][] map = new int[s1.length()][s2.length()];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s1.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					if(i-1 >= 0 && j-1 >= 0) {
						map[i][j] = map[i-1][j-1]+1;
					}
					else {
						map[i][j] = 1;
					}
					answer = Math.max(answer, map[i][j]);
				}
				else {
					if(i-1 >= 0 && j-1 >= 0) {
						map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
					}
					else if(i-1 >= 0 && j == 0) {
						map[i][j] = map[i-1][j];
					}
					else if(i == 0 && j-1>=0) {
						map[i][j] = map[i][j-1];
					}
				}
			}
		}
		
//		for(int[] ia : map) {
//			for(int i : ia) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
		if(answer != 0) {
			int y = s1.length()-1;
			int x = s2.length()-1;
			
			while(x!=0&&y!=0) {
				if(map[y][x]==map[y-1][x]) {
					y--;
				}
				else if (map[y][x-1] == map[y][x]) {
					x--;
				}
				else {
					sb.append(s1.charAt(y));
					x--;
					y--;
				}
			}
			if(map[y][x] == 1) {
				if(map[0][0] == 1) sb.append(s1.charAt(0));
				else if(x==0) {
					while(y>0) {
						if(map[--y][x] == 0)
						sb.append(s1.charAt(y));
						break;
					}
				}
				else if(y==0) {
					while(x>0) {
						if(map[y][--x] == 0)
							sb.append(s2.charAt(x));
						break;
					}
				}
			}
			sb.reverse();
		}
		
		System.out.println(map[s1.length()-1][s2.length()-1]);
		if(map[s1.length()-1][s2.length()-1] != 0)
		System.out.println(sb.toString());
	}
}
/*
  A C A Y K P
C 0 1 1 1 1 1 
A 0 1 2 2 2 2 
P 0 1 2 2 2 3
C 0 1 2 3 3 3
A 0 1 2 0 0 3
K 0 1 2 0 0 3
*/