package bj_2941;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int size = str.length();
		int answer = 0;
		for(int i = 0; i < size; i++) {
			char curr = str.charAt(i);
			switch (curr) {
			case 'd':
				if(i < size-1 && str.charAt(i+1)=='-') i++;
				else if(i < size - 2 && str.charAt(i+1)=='z' &&
						str.charAt(i+2)=='=') {
					i += 2;
				}
				break;
			case 'l':
			case 'n':
				if(i < size-1 && str.charAt(i+1)=='j') i++;
				break;
			case 'c':
				if(i < size-1 && (str.charAt(i+1)=='-')) {
					i++;
				}
			case 's':
			case 'z':
				if(i < size-1 && (str.charAt(i+1)=='=')) {
					i++;
				}
				break;
			default:
				break;
			}
			
			answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
