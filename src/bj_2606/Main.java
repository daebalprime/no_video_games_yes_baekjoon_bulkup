package bj_2606;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N];
		HashMap<Integer, ArrayList<Integer>> network = new HashMap<>();
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(!network.containsKey(a)) network.put(a, new ArrayList<>());
			if(!network.containsKey(b)) network.put(b, new ArrayList<>());
			network.get(a).add(b);
			network.get(b).add(a);
		}
		br.close();
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		visited[0] = true;
		int answer = 0;
		while(!q.isEmpty()) {
			int curr = q.poll();
			answer++;
			for(int i : network.get(curr)) {
				if(!visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		System.out.println(answer-1);
	}

}
