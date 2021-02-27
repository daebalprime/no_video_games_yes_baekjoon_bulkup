package bj_2491;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int prev = -1;
		int streakL = 0;
		int streakS = 0;
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x >= prev) {
				streakL++;
				answer = Math.max(answer,streakL);
			}
			else {
				streakL = 1;
			}
			if(x <= prev) {
				streakS++;
				answer = Math.max(answer,streakS);
			}
			else {
				streakS = 1;
			}
			prev = x;
		}
		System.out.println(answer);
		br.close();
	}

}
