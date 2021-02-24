package bj_3344;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] sol = new int[N];
		if(N % 6 != 2 && N % 6 != 3) {
//			System.out.println("1");
			int i = 0;
			for(i = 0; i < N; i++) {
				if(2*i+1 > N) break;
				sol[i] = 2*i+1;
			}
			for(int k = i; k < N; k++) {
				sol[k] = 2*(k-i+1);
			}
		}
		else if(N % 6 == 2) {
//			System.out.println("2");
			for(int i = 0; i < N/2; i++) {
				sol[i] = (i+1)*2;
			}
			sol[N/2] = 3;
			sol[N/2+1] = 1;
			int i = 0;
			for(i = N/2+2; i < N-1; i++) {
				sol[i] = 2*(i-N/2+1)+1;
			}
//			sol[N-1] = sol[N-2];
			sol[N-1] = 5;
		}else {
			for(int i = 0; i < N/2-1; i++) {
				sol[i] = (i+2)*2;
			}
			sol[N/2-1] = 2;
			for(int i = N/2; i < N-2; i++) {
				sol[i] = (i-N/2+2)*2+1;
			}
			sol[N-2]=1;
			sol[N-1]=3;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(sol[i]+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
//		comb(0);
	}
}