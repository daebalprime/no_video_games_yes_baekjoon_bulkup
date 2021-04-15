package bj_1786;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String text = br.readLine();
		String pattern = br.readLine();
		int tLength = text.length(), pLength = pattern.length();
		int[] fail = new int[pLength];
		int j = 0;
		for(int i = 1; i < pLength; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = fail[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)) fail[i] = ++j;
		}

		int count = 0;
		ArrayList<Integer> points = new ArrayList<>();
		j = 0;
		for(int i = 0; i < tLength; i++) {
			while(j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = fail[j-1];
			}
			if(text.charAt(i) == pattern.charAt(j)) {
				if(j == pLength-1) {
					count++;
					points.add(i-pLength+2);
					j = fail[j];
				}else {
					j++;
				}
			}
		}
		
//		System.out.println(Arrays.toString(fail));
//		System.out.println(answer);
		StringBuilder sb = new StringBuilder();
		sb.append(count+"\n");	
		for(int i : points) {
			sb.append(i+" ");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
