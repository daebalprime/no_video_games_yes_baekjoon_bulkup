package bj_14500;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	static int[][][] f1 = {
			{{0,0,0,1},{0,1,2,1}},
			{{1,1,1,0},{0,1,2,1}},
	};//2*3
//	static int[][][] f2 = {
//			{{0,1,2,1},{0,0,0,1}},
//			{{0,1,2,1},{1,1,1,0}},
//	};//3*2
	static int N, M, answer;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		answer = 0;
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				map[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < M; i++) {
				visited[j][i] = true;
				dfs(0,map[j][i],i,j);
				visited[j][i] = false;
				for(int k = 0; k < 2; k++) {
					int local1 = 0;
					int local2 = 0;
					if(i <= M-2 && j <= N-3) {
						for(int l = 0; l < 4; l++) {
							local1 += map[j+f1[k][1][l]][i+f1[k][0][l]];
						}
					}
					if(i <= M-3 && j <= N-2) {
						for(int l = 0; l < 4; l++) {
							local2 += map[j+f1[k][0][l]][i+f1[k][1][l]];
						}
					}
					answer = Math.max(answer, local1);
					answer = Math.max(answer, local2);
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
	
	static void dfs(int cnt, int sum, int x, int y) {
		if(cnt==3) {
			answer = Math.max(sum, answer);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x+di[i];
			int ny = y+dj[i];
			if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(cnt+1, sum+map[ny][nx], nx, ny);
				visited[ny][nx] = false;
			}
		}
	}

}
