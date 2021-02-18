package bj_2292;

import java.io.*;
import java.util.*;

public class Main {
	static int getRange(int i) {
		return 3*(i-1)*i;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine())-1;
		if(N == 0) {
			bw.write(Integer.toString(1));
			bw.flush();
			return;
		}
		int answer = 0;
		for(int i = 1; i < 100000000; i++) {
			if(getRange(i-1) < N && getRange(i) >= N) {
				answer = i;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
