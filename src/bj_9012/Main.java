package bj_9012;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int N = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < N; tc++){
			Stack<Character> a = new Stack<>();
			boolean answer = true;
			str = br.readLine();
			for(int i = 0; i < str.length(); i++) {					
				Character tmp = str.charAt(i);
				if(tmp.equals('(')) {
					a.add(tmp);
				}
				else{
					if(a.size() == 0 || !a.pop().equals('(')) {
						answer = false;
						break;
					}
				}
			}
			if(a.size() != 0) {
				answer = false;
			}
			bw.append(answer ? "YES" : "NO");
			bw.newLine();
		}
		bw.flush();
	}
}
