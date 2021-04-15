package bj_2667;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,-1,0,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int remained = 0;
		boolean[][] map = new boolean[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int j = 0; j < N; j++) {
			String tmp = br.readLine();
			for(int i = 0; i < N; i++) {
				if(tmp.charAt(i)=='1') map[j][i] = true;
				++remained;
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			if(remained == 0) break;
			for(int j = 0; j < N; j++) {
				if(map[i][j]) {
					Queue<int[]> q = new ArrayDeque<int[]>();
					q.offer(new int[] {j,i});
					int count = 0;
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int x = curr[0];
						int y = curr[1];
						map[y][x] = false;
						--remained;
						count++;
						for(int k = 0; k < 4; k++) {
							int nx = x + di[k];
							int ny = y + dj[k];
							if(nx >= 0 && nx < N && ny >= 0 && ny < N 
									&& !visited[ny][nx] && map[ny][nx]) {
								visited[ny][nx] = true;
								q.offer(new int[] {nx,ny});
							}
						}
					}
					pq.offer(count);
				}
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		br.close();
	}

}
