package bj_11000;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->(Integer.compare(o1[0], o2[0])));
		PriorityQueue<Integer> times = new PriorityQueue<>();
		times.offer(0);
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			pq.offer(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		while(!pq.isEmpty()) {
			if(times.peek() > pq.peek()[0]) {
				times.offer(pq.poll()[1]);
			}
			else {
				times.poll();
				times.offer(pq.poll()[1]);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(times.size());
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
