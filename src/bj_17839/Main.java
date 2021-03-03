package bj_17839;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, LinkedList<String>> hm = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String src = st.nextToken();
			st.nextToken();
			String dest = st.nextToken();
			if(!hm.containsKey(src)) {
				hm.put(src, new LinkedList<>());
			}
			hm.get(src).offer(dest);
		}
		Stack<String> stk = new Stack<>();
		stk.push("Baba");
		StringBuilder sb = new StringBuilder();
		while(!stk.isEmpty()) {
			String curr = stk.pop();
			if(!hm.containsKey(curr))break;
			LinkedList<String> next = hm.get(curr);
			while(!next.isEmpty()) {
				String s = next.poll();
				stk.push(s);
				pq.offer(s);
			}
		}
		String prev = "";
		while(!pq.isEmpty()) {
			String curr = pq.poll();
			if(!prev.equals(curr)) {
				sb.append(curr+"\n");
			}
			prev = curr;
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
