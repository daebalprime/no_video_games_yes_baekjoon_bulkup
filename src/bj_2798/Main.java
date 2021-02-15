package bj_2798;

import java.io.*;
import java.util.*;

public class Main {
	static int M,N, answer;
	static int[] picks = new int[3];
	static int[] cards;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		combi(0,0);
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static void combi(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for(int p : picks) {
				sum += cards[p];
			}
			if(sum <= M) answer = Math.max(answer, sum);
			return;
		}
		if(start == N) {
			return;
		}
		for(int i = start; i < N; i++) {
			picks[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
}
