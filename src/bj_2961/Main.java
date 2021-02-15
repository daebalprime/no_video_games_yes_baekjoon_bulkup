package bj_2961;

import java.io.*;
import java.util.*;

public class Main {

	static int[] sin;
	static int[] ssun;
	static boolean[] visited;
	static long answer;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		sin = new int[N];
		ssun = new int[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sin[i] = Integer.parseInt(st.nextToken());
			ssun[i] = Integer.parseInt(st.nextToken());
		}
		generateSubset(0,1,0);
		StringBuilder sb = new StringBuilder();
		sb.append(answer).append("\n");
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void generateSubset(int cnt, long sinsum, long ssunsum) {
		if(cnt == N) {
			if(sinsum != 1 && ssunsum != 0)
			answer = Math.min(answer, Math.abs(sinsum-ssunsum));
			return;
		}
		
		visited[cnt] = true;
		generateSubset(cnt+1, sinsum * sin[cnt], ssunsum + ssun[cnt]);
		visited[cnt] = false;
		generateSubset(cnt+1, sinsum, ssunsum);
	}

}
