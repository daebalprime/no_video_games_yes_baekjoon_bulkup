package bj_10799;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] par = br.readLine().toCharArray();
//		br.close();
		
		int stack = 0;
		long answer = 0;
		char prev = ' ';
		for(int i = 0; i < par.length; i++) {
			char curr = par[i];
			if(curr=='(') {
				++stack;
				++answer;
			}
			else {
				--stack;
				if(prev == '(') {
					(answer) += stack;
					--answer;
				}
			}
			prev = curr;
		}
		System.out.println(answer);
	}
}
