package bj_2578;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sz = Integer.parseInt(st.nextToken());
			long a = 0, b = 0;
			for(int x = 0; x < sz; x++) {
				a += 1<<((Integer.parseInt(st.nextToken())-1)*10);
			}
			st = new StringTokenizer(br.readLine());
			sz = Integer.parseInt(st.nextToken());
			for(int x = 0; x < sz; x++) {
				b += 1<<((Integer.parseInt(st.nextToken())-1)*10);
			}
			if(a>b) System.out.println("A");
			else if(a<b) System.out.println("B");
			else System.out.println("D");
		}
	}
}
