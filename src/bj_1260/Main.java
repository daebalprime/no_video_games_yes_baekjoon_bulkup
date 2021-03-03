package bj_1260;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken())-1;
		boolean[] visited = new boolean[N];
		HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(!hm.containsKey(a)) {
				hm.put(a, new ArrayList<>());
			}
			if(!hm.containsKey(b)) {
				hm.put(b, new ArrayList<>());
			}
			hm.get(a).add(b);
			hm.get(b).add(a);
		}
		for(ArrayList<Integer> ll : hm.values()) {
			ll.sort((o1,o2)->Integer.compare(o1, o2));
		}
		if(!hm.containsKey(V)) {
			System.out.println(V+1);
			System.out.println(V+1);
			return;
		}
		Stack<Integer> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		stk.push(V);
//		visited[V] = true;
		while(!stk.isEmpty()) {
			int curr = stk.peek();
			
			boolean flag = false;
			if(!visited[curr]) {
				sb.append((curr+1)+" ");
				visited[curr] = true;
			}
			ArrayList<Integer> next = hm.get(curr);
			for(int i = 0; i < next.size(); i++) {
				int nxt = next.get(i);
				if(!visited[nxt]) {
					stk.push(nxt);
					flag =true;
					break;
				}
			}
			if(!flag) {
				stk.pop();
			}
		}
		sb.setLength(sb.length()-1);
		sb.append("\n");
		
		visited = new boolean[N];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(V);
		visited[V] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append((curr+1)+" ");
			ArrayList<Integer> next = hm.get(curr);
			for(int i = 0; i < next.size(); i++) {
				int nxt = next.get(i);
				if(!visited[nxt]) {
					q.offer(nxt);
					visited[nxt] = true;
				}
			}

		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
