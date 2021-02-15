package bj_10816;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			int cnt = hm.getOrDefault(tmp, 0) + 1;
			if(cnt == 1) {
				hm.put(tmp, 0);
			}
			hm.replace(tmp, cnt);
		}
//		System.out.println(hm.get(10));
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			sb.append(hm.getOrDefault(tmp, 0)).append(" ");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
