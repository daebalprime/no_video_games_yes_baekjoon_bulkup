package bj_2231;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			int tmp = i;
			tmp += i % 10;
			int divider = 10;
			while((i / divider) != 0) {
				tmp += (i / divider) % 10;
				divider *= 10;
			}
			if(tmp == N) {
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
