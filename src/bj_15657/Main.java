package bj_15657;
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] table;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		table = new int[N];
		for(int i = 0; i < N; i++){
			table[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(table);
		perm(0,0,new boolean[N],new int[M]);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static void perm(int cnt,int start, boolean[] v, int[] pick) {
		if(cnt == M) {
			for(int p : pick) {
				sb.append(p+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for(int i = start; i < N; i++) {
			pick[cnt] = table[i];
			 
			perm(cnt+1, i, v, pick);
		}
	}
}