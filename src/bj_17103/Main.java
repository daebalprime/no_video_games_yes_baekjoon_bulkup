package bj_17103;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] isPrime = new boolean[1000001];
		isPrime[0] = true;
		isPrime[1] = true;
		int count = 999999;
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i = 2; i < 1000001; i++) {
			if(!isPrime[i]) {
				primes.add(i);
				--count;
			}
			int t = i;
			while(true) {
				 t += i;
				 if(t > 1000000) break;
				 if(!isPrime[t]) {
					 --count;
					 isPrime[t] = true;
				 }
			}
		}
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int K = Integer.parseInt(br.readLine());
			int next = Collections.binarySearch(primes, K-2);
			System.out.println(primes.get(-next-1));
		}
		StringBuilder sb = new StringBuilder();
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
