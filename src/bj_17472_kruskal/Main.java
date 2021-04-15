package bj_17472_kruskal;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,-1,0,1};
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int islandId = 0;
		int[][] map = new int[N][M];
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				if(st.nextToken().equals("1")) map[j][i] = -1;
			}
		}
		
		
		ArrayList<ArrayList<int[]>> islands = new ArrayList<>();
		Queue<int[]> q = new LinkedList<int[]>();
		islands.add(null); // dummy for padding
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < M; i++) {
				if(map[j][i] < 0) {
					ArrayList<int[]> currIsland =new ArrayList<int[]>();  
					islands.add(currIsland);
					++islandId;
					q.offer(new int[] {i,j});
					currIsland.add(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int x = curr[0];
						int y = curr[1];
						map[y][x] = islandId;
						for(int k = 0; k < 4; k++) {
							int nx = x+di[k];
							int ny = y+dj[k];
							if(nx < 0 || nx >= M || ny < 0 || ny >= N || map[ny][nx] != -1){
								continue;
							}
							q.offer(new int[] {nx,ny});
							currIsland.add(new int[] {nx,ny});
						}
					}
				}
			}
		}
		parents = new int[islandId+1];
		for(int i = 1; i < islandId+1; i++) {
			parents[i] = i;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2],o2[2]));
		for(int i = 1; i <= islandId; i++) {
			ArrayList<int[]> currIsland = islands.get(i);
			for(int[] coord : currIsland) {
				int x = coord[0];
				int y = coord[1];
				for(int k = 0; k < 4; k++) {
					int dx = x, dy = y;
					int dist = 0;
					while(true) {
						dx += di[k];
						dy += dj[k];
						++dist;
						if(dx < 0 || dx >= M || dy < 0 || dy >= N || map[dy][dx] == i){
							break;
						}
						if(map[dy][dx] > 0) {
							if(dist > 2) pq.offer(new int[] {i,map[dy][dx], dist-1});
							break;
						}
					}
				}
			}
		}
		
		int answer = 0;
		int count = islandId - 1;
		while(!pq.isEmpty() && count != 0) {
			int[] curr = pq.poll();
			int from = curr[0];
			int to = curr[1];
			int weight = curr[2];
			if(union(from,to)) {
//				System.out.println(Arrays.toString(curr));
				answer+= weight;
				--count;
			}
		}
//		for(int[] ia : map) {
//			System.out.println(Arrays.toString(ia));
//		}
		
		if(count != 0 || answer == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer);
		}
		
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static int findSet(int i) {
		if(parents[i] == i) return i;
		return parents[i] = findSet(parents[i]);
	}
	
	static boolean union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa==pb) return false;
		parents[pb] = pa;
		return true;
	}

}
