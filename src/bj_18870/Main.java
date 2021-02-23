package bj_18870;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->(Integer.compare(o1[0], o2[0])));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pq.offer(new int[] { Integer.parseInt(st.nextToken()), i});
		}
		int[] answer = new int[N];
		int prev = Integer.MIN_VALUE;
		int cnt = -1;
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if(tmp[0] != prev) {
				cnt++;
				prev = tmp[0];
			}
			answer[tmp[1]] = cnt; 
		}
		StringBuilder sb = new StringBuilder();
		for(int i : answer) {
			sb.append(i+" ");
		}
		sb.setLength(sb.length()-1);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
