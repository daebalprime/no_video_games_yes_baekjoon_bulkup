package bj_1929;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] eche = new boolean[1000001];
		LinkedList<Integer> ll = new LinkedList<>();
		for(int i = 2; i <= N; i++) {
			if(!eche[i] && i >= M) {
				eche[i] = true;
				ll.offer(i);
			}
			for(int j = i; j <= N; j += i) {
				eche[j] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!ll.isEmpty()) {
			sb.append(ll.poll()+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
