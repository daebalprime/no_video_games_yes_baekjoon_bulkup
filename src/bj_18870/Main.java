package bj_18870;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N][];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = new int[] { Integer.parseInt(st.nextToken()), i};
		}
		Arrays.sort(nums, (o1,o2)-> Integer.compare(o1[0], o2[0]));
		int[] answer = new int[N];
		int prev = Integer.MIN_VALUE;
		int cnt = -1;
		for(int[] ia : nums) {
			if(ia[0] != prev) {
				cnt++;
				prev = ia[0];
			}
			answer[ia[1]] = cnt; 
		}
		StringBuilder sb = new StringBuilder();
		for(int i : answer) {
			sb.append(i+" ");
		}
		sb.setLength(sb.length()-1);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}