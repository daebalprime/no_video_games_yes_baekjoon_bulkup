package bj_11399;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		int answer = 0;
		while(!pq.isEmpty()) {
			answer+= pq.poll()*(N--);
		}
		System.out.println(answer);
		br.close();
	}

}
