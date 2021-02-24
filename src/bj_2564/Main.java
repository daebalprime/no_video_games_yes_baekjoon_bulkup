package bj_2564;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int tot = 2*W+2*H-4;
		int[] stores = new int[N+1];
		int answer = 0;
		for(int i = 0; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			if(X == 1) { // North
				stores[i] = D;
			}else if(X == 4) { //East
				stores[i] = W + D;
			}else if(X == 2) { // South
				stores[i] = W + H + (W-D);
			}else if(X == 3) { // West
				stores[i] = 2*W + H + (H-D);
			}
//			System.out.println(stores[i]);
		}
		for(int i = 0; i < N; i++) {
			int a = Math.abs(stores[i] - stores[N]);
			int b = 2*W + 2*H - a;
//			System.out.println(a+" "+b);
			answer += Math.min(a, b);
		}
		System.out.println(answer);
		br.close();
	}

}
