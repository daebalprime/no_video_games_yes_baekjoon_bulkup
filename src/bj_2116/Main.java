package bj_2116;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][][] dices = new int[N][6][2]; 
		int[][] mask = new int[][]{
				{1,2,3,4},	
				{0,2,4,5},	
				{0,1,3,5},	
				{0,2,4,5},	
				{0,1,3,5},	
				{1,2,3,4},	
		};
		int[] tmp = new int[6];
		int[] oppo = new int[] {5,3,4,1,2,0};
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < 6; j++) {
				int x = tmp[j]-1;
				dices[i][x][0] = tmp[oppo[j]]-1;
				int sum = 0;
				for(int k = 0; k < 4; k++) {
					sum = Math.max(tmp[mask[j][k]], sum);
				}
				dices[i][x][1] = sum;
			}
		}
		int answer = 0;
		for(int k = 0; k < 6; k++) {
			int local = 0;
//			int next = dices[0][dices[0][k][0]][0];
			int next = k;
			for(int i = 0; i < N; i++) {
				local += dices[i][next][1];
				next = dices[i][next][0];
			}
			answer = Math.max(answer, local);
		}
		System.out.println(answer);
	}
}
