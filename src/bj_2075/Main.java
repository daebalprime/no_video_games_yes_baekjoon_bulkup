package bj_2075;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(Integer.compare(o2, o1)));
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i = 0; i < N-1; i++) {
			pq.poll();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(pq.poll());
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
