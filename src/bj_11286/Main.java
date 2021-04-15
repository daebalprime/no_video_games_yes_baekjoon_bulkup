package bj_11286;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(
				Math.abs(o1)==Math.abs(o2)?Integer.compare(o1,o2):Integer.compare(Math.abs(o1),Math.abs(o2))
				));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if(tmp.charAt(0) == '0') {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()+"\n");
			}
			else {
				pq.offer((Integer.parseInt(tmp)));
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
