package bj_1620;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> dogam = new HashMap<>();
		HashMap<Integer, String> dogam2 = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			String pokeName = br.readLine();
			dogam.put(pokeName, i);
			dogam2.put(i, pokeName);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String prob = br.readLine();
			if(prob.charAt(0)-'0'>=0 &&prob.charAt(0)-'0'<=9) {
				sb.append(dogam2.get(Integer.parseInt(prob))+"\n");
			}else {
				sb.append(dogam.get(prob)+"\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
