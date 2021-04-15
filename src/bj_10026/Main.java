package bj_10026;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][];
		boolean[][] visited = new boolean[N][N];
		boolean[][] visitedWeak = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(bfs1(map, visited) + " " + bfs2(map,visitedWeak));
		br.close();
	}
	static int bfs1(char[][] map, boolean[][] visited) {
		int ret = 0;
		int N = map.length;
		Queue<int[]> q = new ArrayDeque<>();
		for(int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if(!visited[j][i]) {
					++ret;
					q.offer(new int[] {j,i});
					visited[j][i] = true;
					char color = map[j][i];
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int x = curr[0];
						int y = curr[1];
						for(int k = 0; k < 4; k++) {
							int nx = x + di[k];
							int ny = y + dj[k];
							if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]
									&& color == map[ny][nx]) {
								q.offer(new int[] {nx,ny});
								visited[ny][nx] = true;
							}
						}
					}
				}
			}
		}
		return ret;
	}
	static int bfs2(char[][] map, boolean[][] visited) {
		int ret = 0;
		int N = map.length;
		Queue<int[]> q = new ArrayDeque<>();
		for(int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if(!visited[j][i]) {
					++ret;
					q.offer(new int[] {j,i});
					visited[j][i] = true;
					char color = map[j][i];
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int x = curr[0];
						int y = curr[1];
						for(int k = 0; k < 4; k++) {
							int nx = x + di[k];
							int ny = y + dj[k];
							if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
								if((color == 'R' || color == 'G') && map[ny][nx] == 'B') continue;
								if(color == 'B' && (map[ny][nx] == 'R'|| map[ny][nx]=='G')) continue;
								q.offer(new int[] {nx,ny});
								visited[ny][nx] = true;
							}
						}
					}
				}
			}
		}
		return ret;
	}

}
