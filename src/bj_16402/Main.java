package bj_16402;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<String, String> parents = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			String kingdom = br.readLine().substring(11);
			parents.put(kingdom, kingdom);
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			String ka = st.nextToken().substring(11);
			String kb = st.nextToken().substring(11);
			int result = Integer.parseInt(st.nextToken());
			if(result == 1) {
				union(kb,ka,parents);
			}
			else {
				union(ka,kb,parents);
			}
		}
		StringBuilder sb = new StringBuilder();
		Iterator<String> itr = parents.keySet().iterator();
		PriorityQueue<String> pq = new PriorityQueue<>();
		while(itr.hasNext()) {
			String curr = itr.next();
			if(parents.get(curr).equals(curr)) {
				pq.offer(curr);
			}
		}
		sb.append(pq.size()+"\n");
		while(!pq.isEmpty()) {
			sb.append("Kingdom of "+pq.poll()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static String findSet(String s, HashMap<String,String> parents) {
		String ret = null;
		if(parents.get(s).equals(s)) return s;
		else {
			ret = findSet(parents.get(s), parents);
			parents.replace(parents.get(s), ret);
		}
		return ret;
	}
	
	static void union(String a, String b, HashMap<String,String> parents) {
		if(findSet(a,parents).equals(findSet(b,parents))) {
			parents.replace(a, a);
		}
		
		parents.replace(a, b);
		
		
	}
}
