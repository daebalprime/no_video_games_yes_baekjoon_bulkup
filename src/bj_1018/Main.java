package bj_1018;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][][] map = new boolean[2][N][M];
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[0][i][j] = tmp.charAt(j) == 'W';
				map[1][i][j] = tmp.charAt(j) == 'B';
			}
		}
		for(int x = 0; x <= N-8; x++) {
			for(int y = 0; y <= M-8; y++) {
				int[] local = {0,0};
				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {
						if(map[0][i+x][j+y] != ((i+j)%2 == 0)) {
							local[0]++;
						}
						if(map[1][i+x][j+y] != ((i+j)%2 == 0)) {
							local[1]++;
						}
					}
				}
				answer = Math.min(answer,Math.min(local[0], local[1]));
			}
		}
		System.out.println(answer);
	}
}

//Must we avoid nested 4-level for loop?
