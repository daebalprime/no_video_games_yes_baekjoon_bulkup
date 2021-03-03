package bj_11724;

import java.io.*;
import java.util.*;
public class Main {
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			if(!graph.containsKey(s)) graph.put(s, new LinkedList<>());
			graph.get(s).offer(e);
			if(!graph.containsKey(e)) graph.put(e, new LinkedList<>());
			graph.get(e).offer(s);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			answer++;
			q.offer(i);
			visited[i] = true;
			while(!q.isEmpty()) {
				int curr = q.poll();
				LinkedList<Integer> next = graph.getOrDefault(curr, null);
				if(next == null) continue;
				for(Integer it : next) {
					if(visited[it]) continue;
					q.offer(it);
					visited[it] = true;
				}
			}
		}
		System.out.println(answer);
	}

}
