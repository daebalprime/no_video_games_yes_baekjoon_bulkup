package bj_18111;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int min = 1000;
		int max = 0;
//		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		int answer = Integer.MAX_VALUE;
		int height = 0;
		for(int h = min; h <= max; h++) {
			int up, down = down = up = 0;
			for(int[] ia : map) {
				for(int i : ia) {
					if(i > h) up += i-h;
					else if(i < h) down += h-i;
				}
			}
			if(B+up < down) break;
			int time = up*2 + down;
			
			if(answer > time) {
				answer = time;
				height = h;
			}
			else if(answer == time) {
				height = Math.max(height, h);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(answer + " " + height);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
