package bj_11659;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] sum = new int[N];
		int tmp = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tmp += Integer.parseInt(st.nextToken());
			sum[i] = tmp;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int result = sum[to];
			if(from != 0) result -= sum[from-1];
			sb.append(result+"\n");
			
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
