package bj_12907;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] count = new int[N];
		for(int i = 0; i < N; i++) {
			int S = Integer.parseInt(st.nextToken());
			if(S >= N) {
				System.out.println(0);
				return;
			}
			count[S]++;
		}
		
		int answer = 1;
		boolean flag = false;
		int max = count[0];
		if(max > 2) answer = 0;
		for(int i = 0; i < N; i++) {
//			if(i > N)
			int curr = count[i];
			if(max < count[i]) {
				answer = 0;
				break;
			}
			if(curr == 1) flag = true;
			max = Math.min(max, curr);
			if(curr != 0) answer *= curr;
		}
		if(flag) answer  *= 2;
		System.out.println(answer);
	}

}
