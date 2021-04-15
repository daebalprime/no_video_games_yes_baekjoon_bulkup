package bj_1600;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {0,-1,0,1,1,1,2,2,-1,-1,-2,-2};
	static int[] dj = {-1,0,1,0,2,-2,1,-1,2,-2,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[H][W];
		for(int j = 0; j < H; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < W; i++) {
				if(st.nextToken().equals("1")) map[j][i] = true;
			}
		}
		br.close();
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0,0,0,0});
		boolean[][][] visited = new boolean[K+1][H][W];
		int answer = Integer.MAX_VALUE;
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int depth = curr[2];
			if(x == W-1 && y == H-1) {
				answer = Math.min(answer, depth);
				break;
			}
			int jump = curr[3];
//			visited[y][x] = true;
			
			int extend = jump<K? di.length : 4;
			for(int k = 0; k < extend; k++) {
				if(k==4) ++jump;
				int nx = x + di[k];
				int ny = y + dj[k];
				if(nx < 0 || nx >= W || ny < 0 || ny >= H || visited[jump][ny][nx] || map[ny][nx]) continue;
				q.offer(new int[] {nx,ny,depth+1,jump});
				visited[jump][ny][nx] = true;
			}
			
		}
		
		System.out.println(answer == Integer.MAX_VALUE? -1 : answer);
	}

}
