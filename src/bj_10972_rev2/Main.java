package bj_10972_rev2;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] input;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		if(!np()) {
			sb.append(-1);
		}
		else {
			for(int x : input) {
				sb.append(x+ " ");
			}
			sb.setLength(sb.length()-1);
		}
	
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static boolean np() {
		int i = 0;
		for(i = N-1; i > 0; i--) {
			if(input[i-1] < input[i]) break;
		}
		if(i==0)return false;
		int j = 0;
		for(j = N-1; j > i-1; j--) {
			if(input[i-1] < input[j])break;
		}
		swap(i-1,j);
		int k = N-1;
		while(i<k) {
			swap(i++, k--);
		}
		return true;
	}
	
	static void swap(int l, int r) {
		int temp = input[l];
		input[l] = input[r];
		input[r] = temp;
	}

}
