package bj_1987_optimize;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	static int answer = 0;
	static int R,C;
	static boolean[] alphabet;
	static boolean[][] visited;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		alphabet = new boolean[26];
//		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		dfs(0,0,0);
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void dfs(int x, int y, int len) {
//		if(answer )
		if(alphabet[map[y][x]-'A'] || visited[y][x]) {			
			answer = Math.max(answer, len);
			return;
		}
		alphabet[map[y][x]-'A'] = true;
		visited[y][x] = true;
		for(int k = 0; k < 4; k++) {
			int nx = x + di[k];
			int ny = y + dj[k];
			if(nx >= 0 && nx < C && ny >= 0 && ny < R) {
				
				dfs(nx, ny, len+1);
			}
		}
		visited[y][x] = false;
		alphabet[map[y][x]-'A'] = false;
	}
}
