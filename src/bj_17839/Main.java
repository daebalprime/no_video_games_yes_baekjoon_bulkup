package bj_17839;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int N = Integer.parseInt(st.nextToken());
		HashMap<String, LinkedList<String>> hm = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			st.nextToken();
			String c = st.nextToken();
			if(!hm.containsKey(p)) {
				hm.put(p, new LinkedList<String>());
			}
			hm.get(p).add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<String> pq = new PriorityQueue<>();
		dfs(hm, "Baba", pq);
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void dfs(HashMap<String, LinkedList<String>> hm, String curr, PriorityQueue<String> pq) {
		if(!hm.containsKey(curr)) return;
		for(String s : hm.get(curr)) {
			pq.offer(s);
			dfs(hm, s, pq);
		}
	}

}
