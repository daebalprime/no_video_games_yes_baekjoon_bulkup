package bj_2636;

import java.io.*;
import java.util.*;

public class Main {
	static int H,W;
	static boolean[][] map;
	static int[][] visited;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new boolean[H][W];
		visited = new int[H][W];
		int mark = 1;
		int remained = 0;
		for(int j = 0; j < H; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < W; i++) {
				if(st.nextToken().equals("1")) {
					map[j][i] = true;
					++remained;
				}
			}
		}
		
		int time = 0;
		ArrayList<int[]> melted = new ArrayList<>();
		Queue<int[]> q = new LinkedList<int[]>();
		int lastRemained = 0;

		while(remained > 0) {
			q.offer(new int[] {0,0});
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				int x = curr[0];
				int y = curr[1];
				for(int i = 0; i < 4; i++) {
					int nx = x+di[i];
					int ny = y+dj[i];
					if(nx < 0 || nx >= W || ny < 0 || ny >= H || visited[ny][nx] == mark) continue;
					if(map[ny][nx]) melted.add(new int[] {nx,ny});
					else {
						q.add(new int[] {nx,ny});
					}
					visited[ny][nx] = mark;
				}
			}
			if(remained == melted.size()) lastRemained = remained;
			remained -= melted.size();
			for(int[] outer : melted) {
				int y = outer[1];
				int x = outer[0];
				map[y][x] = false;
			}
			melted.clear();
			mark++;
			time++;
		}
		System.out.println(time);
		System.out.println(lastRemained);
		br.close();
	}
}
