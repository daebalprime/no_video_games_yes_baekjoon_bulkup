package bj_2805;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] trees = new long[N];
//		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		long left = 1;
		long right = 0;
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, trees[i]);
		}
		
		long mid = (left+right)/2;
//		System.out.println(mid);
		int answer = 0;
		while(left<=right) {
			mid = (left+right)/2;
			long sum = 0;
			for(long i : trees) {
				if(i >= mid) sum += i-mid;
			}
//			if(sum == M) {
//				answer = Math.max(mid, answer);
//			}
//			System.out.println(left+ " " + mid + " " + right + " " +sum);
			if(sum < M) right = mid-1;
			else left = mid+1;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(right);
		// 겹치는 수가 있을 때, right를 출력하면 최댓값 나온다.
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
