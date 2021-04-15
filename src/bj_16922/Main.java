package bj_16922;

import java.io.*;
import java.util.*;

public class Main {
	static int N, answer;
	static int[] values = {1,5,10,50};
	static Set<Integer> S;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		br.close();
		S = new HashSet<>();
		answer = 0;
		dfs(0,new int[4], N);
		System.out.println(answer);
	}
	
	static void dfs(int cnt, int[] picks, int remained) {
		if(remained < 0) return;
		if(cnt == 4 || remained == 0) {
			if(remained == 0) {
				int results = 0;
				for(int i = 0; i < 4; i++) {
					results += values[i] * picks[i];
				}
				if(!S.contains(results)) {
//					System.out.println(Arrays.toString(picks));
//					System.out.println(results);
					S.add(results);
					answer++;
				}
			}
			return;
		}
		for(int i = 0; i <= remained; i++) {
			picks[cnt] = i;
			dfs(cnt+1, picks, remained-i);
			picks[cnt] = 0;
		}
		
	}

}
