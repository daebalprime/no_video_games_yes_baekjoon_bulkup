package bj_1927;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if(tmp.charAt(0) == '0') {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()+"\n");
			}
			else {
				pq.offer(Integer.parseInt(tmp));
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
