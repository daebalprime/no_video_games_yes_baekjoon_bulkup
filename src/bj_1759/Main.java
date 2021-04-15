package bj_1759;

import java.io.*;
import java.util.*;

public class Main {
	static char[] vowels = {'a','e','i','o','u'};
	static char[] cand ;
	static int L, C;
	static StringBuilder sb ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		cand = new char[C];
		sb=  new StringBuilder();
		for(int i = 0; i < C; i++) {
			cand[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(cand);
//		System.out.println(Arrays.toString(cand));
		comb(0,0,new char[L], 0);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static void comb (int cnt, int start, char[] picks, int vowelCount) {
		if(cnt == L) {
			if(vowelCount == 0) return;
			if(cnt - vowelCount <= 1) return;
			for(char c : picks) sb.append(c);
			sb.append("\n");
			return;
		}
		for(int i = start; i < C; i++) { // 여기 주의하기
			picks[cnt] = cand[i];
			boolean flag = false;
			for(char v: vowels) {
				if(cand[i] == v) {
					flag = true;
					break;
				}
			}
			comb(cnt+1, i+1, picks, flag? vowelCount + 1 : vowelCount);
		}
	}
}
