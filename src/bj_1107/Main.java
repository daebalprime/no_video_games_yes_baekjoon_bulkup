package bj_1107;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String tmp = null;
		int N = Integer.parseInt(tmp = st.nextToken());
		int BC = Integer.parseInt(br.readLine());
		boolean[] isBroken = new boolean[10];
		int answer = Integer.MAX_VALUE;
		
		if(BC != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < BC; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true; 
			}
		}
		
		answer = Math.min(Math.abs(N-100), answer);
		for(int i = 0; i < 1000000; i++) {
			//length 계산
			String iStr = Integer.toString(i);
			boolean flag = true;
			for(int k = 0; k < iStr.length(); k++) {
				if(isBroken[iStr.charAt(k)-'0']) {
					flag = false;
					break;
				}
			}
			if(flag) {
				answer = Math.min(answer, Math.abs(i-N)+iStr.length());
			}
			//
		}
		
		System.out.println(answer);
		br.close();
	}
}

/*
836
9
6 9 1 8 3 4 7 2 5

736
 
444445
9
0 1 2 3 5 6 7 8 9

7

500000
2
1 5

7

0
1
0

2
 * */
