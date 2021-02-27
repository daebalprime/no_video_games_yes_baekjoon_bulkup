package bj_2304;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();

		int answer = 0;
	
		int[][] map = new int[s1.length()][s2.length()];
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
		
		System.out.println(map[s1.length()-1][s2.length()-1]);
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