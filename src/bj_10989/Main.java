package bj_10989;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] counting = new int[10001];
		for(int i = 0; i < N; i++) {
			counting[Integer.parseInt(br.readLine())]++;
		}
//		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= 10000; i++) {
			while(counting[i]-- != 0) {
				bw.write(i+"\n");
			}
		}
//		bw.write(sb.toString());
//		bw.flush();
		br.close();
		bw.close();
	}
}
