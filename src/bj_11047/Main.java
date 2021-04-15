package bj_11047;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[N-1-i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		for(int i : coins) {
			answer += K/i;
			K = K%i;
		}
		System.out.println(answer);
		br.close();
	}

}
