package bj_16928;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] map = new int[101];
		Arrays.fill(map, -1);
		boolean[] visited = new boolean[101];	
		for(int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from] = to;
		}
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {1,0});
		visited[1] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int curr = tmp[0];
			int depth = tmp[1];
			if(curr == 100) {
				System.out.println(depth);
				break;
			}
			for(int i = 1; i <= 6; i++) {
				int nx = curr+i;
				if(nx > 100) continue;
				while(map[nx] != -1) {
					nx = map[nx];
				}
				if(visited[nx]) continue;
				visited[nx] = true;
				q.offer(new int[] {nx, depth+1});
			}
		}
		br.close();
	}

}
