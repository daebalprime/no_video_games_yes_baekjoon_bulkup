package bj_17472_prim;

import java.io.*;
import java.util.*;

public class Main {
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,-1,0,1};
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
		
		final int INF = 987654321;
		int[] minEdge = new int[islandId+1];
		Arrays.fill(minEdge, INF);
		minEdge[1] = 0;
		boolean[] visited = new boolean[islandId+1];
		
		int[][] adjMatrix = new int[islandId+1][islandId+1];
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
							if(dist > 2) {
								if(adjMatrix[i][map[dy][dx]] == 0) adjMatrix[i][map[dy][dx]]= dist-1;
								else adjMatrix[i][map[dy][dx]]= Math.min(adjMatrix[i][map[dy][dx]], dist-1);
								if(adjMatrix[map[dy][dx]][i] == 0) adjMatrix[map[dy][dx]][i]= dist-1;
								else adjMatrix[map[dy][dx]][i]= Math.min(adjMatrix[map[dy][dx]][i], dist-1);
							}
							break;
						}
					}
				}
			}
		}
		
		int answer = 0;
		int count = islandId - 1;
		for (int c = 1; c <= islandId-1; c++) {
			
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			// 신장트리에 연결되지 않은 정점중 minEdge비용이 최소인 정점
			for (int i = 1; i <= islandId; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			count--;
			answer += min;
			visited[minVertex] = true;
			
			//신장트리 선택후 해당 정점에서 뻗어나가는 간선들과 minEdge를 비교하여 최신화하기
			for (int i = 1; i <= islandId; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] >adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
			
		}
		
		
//		for(int[] ia : map) {
//			System.out.println(Arrays.toString(ia));
//		}
		System.out.println(count);
		System.out.println(answer);
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
	

}
