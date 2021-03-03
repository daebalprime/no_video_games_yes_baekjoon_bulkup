package bj_17840;
import java.io.*;
import java.util.*;

public class Main {
	static long cycle = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dp = new int[3*M*M-1];
		dp[0] = 1;
		dp[1] = 1;
		cycle = getDP(dp, M);
//		System.out.println(cycle);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			long N = Long.parseLong(br.readLine()) - 1;
			int mod = (int) (N%cycle);
			sb.append(dp[mod]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int getDP(int[] dp, int M) {
		int idx = 1;
		int prev = dp[0];
		int curr = dp[1];
		while(true) {
			int z = (prev+curr) % M;
			int temp = z;
			if(temp / 100 > 0) {
				dp[++idx] = temp / 100;
				temp = temp % 100;
				dp[++idx] = temp / 10;
				temp = temp % 10;
				dp[++idx] = temp;
			}
			else if(temp / 10 > 0) {
				dp[++idx] = temp / 10;
				temp = temp % 10;
				dp[++idx] = temp;
			}
			else {
				dp[++idx] = temp;
			}
			prev = curr;
			curr = z;
			if(prev == 1 && curr == 0 )break;
		}
		//returns period of mod of fibonacci.
		return idx+1;
	}
}
//		int count = 3;
//		int prev = 1;
//		int curr = 1;
//		while(true) {
//			int temp = (prev+curr)%1000;
//			prev = curr; 
//			curr = temp;
//			if(prev == 1 && curr == 0) {
//				System.out.println(count);
//				System.exit(0);
//				break;
//			}
//			count++;
//		} // 피사노주기, bj9471참조. https://en.wikipedia.org/wiki/Pisano_period