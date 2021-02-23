package bj_1764;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			hm.put(br.readLine(), 1);
		}
		for(int i = 0; i < M; i++) {
			String tmp = br.readLine();
			int ret = hm.getOrDefault(tmp, 0);
			if(ret == 1) {
				pq.add(tmp);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()+"\n");
		while (!pq.isEmpty()){			
			sb.append(pq.poll()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
