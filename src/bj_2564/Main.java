package bj_2564;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] stores = new int[N+1][2];
		for(int i = 0; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int ori = stores[i][0] = Integer.parseInt(st.nextToken()); 
			int tmp = Integer.parseInt(st.nextToken());
			if(ori == 1) stores[i][1] = tmp;
			else if(ori == 4) stores[i][1] = W + tmp;
			else if(ori == 2) stores[i][1] = H + W + (W-tmp);
			else if(ori == 3){
				stores[i][1] = H+ 2*W + (H-tmp);
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			int dist = Math.abs(stores[N][1] - stores[i][1]);
			answer += Math.min(dist, 2*W+2*H-dist);
		}
		System.out.println(answer);
		br.close();
	}

}
