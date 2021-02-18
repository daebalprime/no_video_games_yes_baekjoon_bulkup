package bj_1654;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] strs = new int[K];
		
		int max = 0;
		for(int i = 0; i < K; i++) {
			int tmp = Integer.parseInt(br.readLine());
			strs[i] = tmp;
			max = Math.max(tmp, max);
		}
		long left = 1;
		long right = max;
		long mid = (left+right)/2;
		while(true) {
			if(left > right) break;
			long count = 0;
			for(int i = 0; i < K; i++) {
				count += strs[i]/mid;
			}
			if(count >= N) left = mid+1;
			else right = mid-1;
			mid = (left+right)/2;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(mid);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
