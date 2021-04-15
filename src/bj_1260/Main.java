package bj_1260;

import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // vertices
		int M = Integer.parseInt(st.nextToken()); // edges
		int V = Integer.parseInt(st.nextToken())-1; // start

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(!hm.containsKey(a)) {
				hm.put(a, new ArrayList<Integer>());
			}
			if(!hm.containsKey(b)) {
				hm.put(b, new ArrayList<Integer>());
			}
			hm.get(a).add(b);
			hm.get(b).add(a);
		}
		boolean[] visited = new boolean[N];
		dfs(V, visited);
		sb.setLength(sb.length()-1);
		sb.append("\n");
		
		visited = new boolean[N];
		bfs(V, visited);
		sb.setLength(sb.length()-1);
		sb.append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void dfs(int curr, boolean[] visited) {
		
		visited[curr] = true;
		sb.append((curr+1)+" ");
		ArrayList<Integer> next = hm.getOrDefault(curr, null);
		if(next == null) return;
		next.sort((o1,o2)->Integer.compare(o1, o2));
		
		for(int i : next) {
			if(!visited[i]) {				
				visited[i] = true;
				dfs(i,visited);
			}
		}
	}
	
	static void bfs(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append((curr+1)+" ");
			ArrayList<Integer> next = hm.getOrDefault(curr, null);
			if(next == null) return;
			next.sort((o1,o2)->Integer.compare(o1, o2));
			for(int i : next) {
				if(!visited[i]) {				
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}

/*
질문 1. 나는 hashMap으로 구현함 ㄱㅊ?
질문 2. 클래스 만드는게 느릴 가능성이 있나? (좌표)
그리고 오픽
 */
