package bj_1655;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2)->(Integer.compare(o2, o1)));
		PriorityQueue<Integer> large = new PriorityQueue<>();
		int median = Integer.parseInt(br.readLine());
		sb.append(median+"\n");
		for(int i = 1; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			boolean ori = (tmp >=median) ? large.offer(tmp) : small.offer(tmp);
			while(i/2 != small.size()) {				
				if(i/2 > small.size()) {
					small.offer(median);
					median = large.poll();
				}else if (i/2 < small.size()) {
					large.offer(median);
					median = small.poll();
				}
			}
//			System.out.println(small.size() + " " + large.size());
			sb.append(median+"\n");
		}
//		System.out.println("0------0-0-0-");
		bw.write(sb.toString());
		bw.flush();
//		br.close();
//		bw.close();
	}

}
