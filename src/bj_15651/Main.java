package bj_15651;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		perm(0,new boolean[N],new int[M]);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static void perm(int cnt, boolean[] v, int[] pick) {
		if(cnt == M) {
			for(int p : pick) {
				sb.append(p+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
//			if(v[i]) continue;
//			v[i] = true;
			pick[cnt] = i+1;
			perm(cnt+1, v, pick);
//			v[i] = false;
		}
	}
}
