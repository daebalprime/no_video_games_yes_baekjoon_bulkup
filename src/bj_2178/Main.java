package bj_2178;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,-1,0,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		boolean[][] visited = new boolean[N][M];
		for(int j = 0; j < N; j++) {
			String tmp = br.readLine();
			for(int i = 0; i < M; i++) {
				if(tmp.charAt(i)=='1') map[j][i] = true;
			}
		}
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {0,0,1});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int depth = curr[2];
			if(x==M-1 && y==N-1) {
				System.out.println(depth);
				break;
			}
			for(int k = 0; k < 4; k++) {
				int nx = x + di[k];
				int ny = y + dj[k];
				if(nx >= 0 && nx < M && ny >= 0 && ny < N 
						&& !visited[ny][nx] && map[ny][nx]) {
					visited[ny][nx] = true;
					q.offer(new int[] {nx,ny,depth+1});
				}
			}
		}
		br.close();
	}

}
