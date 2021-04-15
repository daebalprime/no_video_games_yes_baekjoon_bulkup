package bj_17070;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,1};
	static int[] dj = {1,1,0};
	static int[][][] dp;
	static int N, answer;
	static boolean[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;
		dp = new int[N][N][3];
		dp[0][1][0] = 1;
		dp[0][1][1] = 1;
		dp[0][1][2] = 1;
		map = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().equals("1") ? true : false;
			}
		}
		br.close();
		
		recur(1,0,0);
		
		System.out.println(answer);
	}
	
	static void recur(int x, int y, int ori) { // ori : 0 > 1 v 2 >v
		for(int[][] ia : dp) {
			for(int[] iaa : ia) {
				System.out.print("["+iaa[0]+" "+iaa[1]+" "+iaa[2]+"] ");
			}
			System.out.println();
		}
		System.out.println();
		if(x==N-1 && y == N-1) {
			System.out.println("break");
			answer++;
			return;
		}
		int start = 0, end = 0;
		if(ori == 2) {
			start = 1; 
			end = 2;
		}
		else if(ori == 0) {
			start = 0;
			end = 1;
		}
		else {
			start = 0;
			end = 2;
		}
		for(int k = start; k <= end; k++) {
			int nx = x+di[k];
			int ny = y+dj[k];
			System.out.println(nx+" "+ny);
			if(nx < 0 || nx >= N || ny < 0 || ny >=N || map[ny][nx]) continue;
//			if(nx == N-2 && k == 2 && ny != N-1) continue;
//			if(ny == N-2 && k == 0 && nx != N-1) continue;
			if(k == 1 && ( map[y][x+1] || map[y+1][x]))continue;
			System.out.println("success "+ori + " to next " + k  );
			System.out.println();
			dp[ny][nx][k] += dp[y][x][ori];
			recur(nx,ny,k);
		}
	}
}
