package bj_13300;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] boys = new int[6];
		int[] girls = new int[6];
		int answer = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) {
				girls[Integer.parseInt(st.nextToken())-1]++;
			}else {
				boys[Integer.parseInt(st.nextToken())-1]++;
			}
		}
		br.close();
		for(int i = 0; i < 6; i++) {
			int b = boys[i];
			int g = girls[i];
//			System.out.println(b+ " " + g);
			answer = b == 0? answer : answer + ((b-1) / K)+1;
			answer = g == 0? answer : answer + ((g-1) / K)+1;
		}
		System.out.println(answer);
	}

}
