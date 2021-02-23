package bj_18768;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				new Comparator<int[]> (){

					@Override
					public int compare(int[] o1, int[] o2) {
						if(Math.abs(o2[0]-o2[1])==Math.abs(o1[0]-o1[1])) {
							return Integer.compare(Math.max(o2[0],o2[1]), Math.max(o1[0],o1[1]));
						}
						return Integer.compare(
								Math.abs(o2[0]-o2[1]), 
								Math.abs(o1[0]-o1[1]));
					}
				}
			);
		int T  = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.clear();
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			long max = 0;
			if(N % 2 == 1 && K % 2 == 1) {
				max = N - N/2 + K/2;
			}
			else {
				max = N/2 + K/2;
			}
		
			int[] tmp = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				tmp[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				pq.offer(new int[] {Integer.parseInt(st.nextToken()), tmp[i]});
			}
			int ta = 0;
			int tb = 0;
			long sum = 0;
			while(!pq.isEmpty()) {
				int[] curr = pq.poll();
				if(ta == max) {
					tb++;
					sum += curr[1];
				}
				else if(tb == max) {
					sum += curr[0];
					ta++;
				}
				else {
					if(curr[0]>curr[1]) {
						ta++;
					}
					else if (curr[0]<curr[1]) {
						tb++;
					}
					sum+= Math.max(curr[0], curr[1]);
				}
			}
			sb.append(sum+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
