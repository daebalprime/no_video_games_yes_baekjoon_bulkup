package bj_2477;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] set = new int[6][2];
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			set[i][0] = Integer.parseInt(st.nextToken());
			set[i][1] = Integer.parseInt(st.nextToken());
		}
		boolean flag = true;
		int answer = 0;		
		for(int i = 0; i < 6; i++) {
			if(set[a(i)][0] == set[a(i+2)][0] &&
					set[a(i+1)][0] == set[a(i+3)][0]) {
				answer = set[a(i+5)][1]*set[a(i+4)][1]-set[a(i+1)][1]*set[a(i+2)][1];
				break;
			}
		}
		System.out.println(answer*N);
		br.close();
	}
	
	static int a(int i) {
		return i%6;
	}

}
