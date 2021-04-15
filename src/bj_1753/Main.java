package bj_1753;

import java.io.*;
import java.util.*;

public class Main {
	static int V;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine())-1; // start
//		HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();
		ArrayList<int[]> [] edges = new ArrayList[V];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
//			if(!hm.containsKey(from)) {
//				hm.put(from, new ArrayList<int[]>());
//			}
//			hm.get(from).add(new int[] {to, weight});
			if(edges[from] == null) edges[from] = new ArrayList<int[]>();
			edges[from].add(new int[] {to,weight});
		}
		
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[S] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
		pq.offer(new int[] {S,0});
		
		boolean[] visited = new boolean[V];
		dijkstra(distance, visited, pq, edges);
		StringBuilder sb = new StringBuilder();
		for(int d : distance) {
			sb.append(d==Integer.MAX_VALUE? "INF\n" : d+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dijkstra(int[] distance, boolean[] visited, PriorityQueue<int[]> pq, ArrayList[] hm) {
		
		while(!pq.isEmpty()) {			
			int[] curr = pq.poll();
			int vertexId = curr[0];
			int totalDistance = curr[1];
			if(visited[vertexId]) continue;
			visited[vertexId] = true;
			
			
			ArrayList<int[]> edges = hm[vertexId];
			if(edges == null) continue;
			for(int[] edge : edges) {
				int nextId = edge[0];
				int dist = edge[1];
				if(!visited[nextId] && distance[nextId] > distance[vertexId] + dist) {
					distance[nextId] = distance[vertexId] + dist;
//				if(distance[nextId] > totalDistance + dist) {
//					distance[nextId] = totalDistance + dist;
					pq.offer(new int[] {nextId, distance[nextId]});
				}
			}
		}	
	}
}

/*
3 2
3
1 3 10
2 1 4
정답
INF
INF
0
===================
2 1
2
2 1 1
정답
1
0
===================
4 8
1
1 2 3
2 1 5
4 3 4
2 3 10
1 3 10
2 4 1
3 1 1
1 2 2
정답
0
2
7
3
===================
2 4
1
1 2 1
1 2 2
1 2 5
1 2 10
정답
0
1
===================
2 3
2
1 2 1
1 2 1
1 2 1
정답
INF
0
===================
3 3
2
2 1 4
2 1 4
2 1 4
정답
4
0
INF
===================
5 8
2
1 2 3
2 1 5
4 3 4
2 3 10
1 3 10
2 4 1
3 1 1
1 2 2
정답
5
0
5
1
INF
===================
4 6
2
3 1 2
1 4 2
4 3 2
3 4 2
2 3 2
2 4 2
정답
4
0
2
2

===================

3 4
2
1 3 5
2 1 9
2 3 3
2 1 10
정답
9
0
3

===================

12 20
1
1 2 1
1 3 1
1 4 2
1 5 2
1 6 2
1 7 2
1 8 2
1 9 3
1 10 4
1 11 5
2 11 5
3 11 4
4 11 3
5 11 2
6 11 1
7 10 1
8 10 2
9 10 3
10 11 4
1 11 10
정답

0
1
1
2
2
2
2
2
3
3
3
INF
 * */
