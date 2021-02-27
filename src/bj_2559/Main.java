package bj_2559;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] temp = new int[N];
		int answer = Integer.MIN_VALUE;
		int curr = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			if(i < K) curr+= temp[i];
		}
//		System.out.println(curr);
		answer = Math.max(curr, answer);
		for(int i = K; i < N; i++) {
			curr -= temp[i-K];
			curr += temp[i];
//			System.out.println(curr);
			answer = Math.max(curr, answer);
		}
		System.out.println(answer);
	}

}
