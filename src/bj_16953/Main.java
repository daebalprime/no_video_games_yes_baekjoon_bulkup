package bj_16953;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		br.close();
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {B, 0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int num = curr[0];
			int depth = curr[1];
			if(num == A) {
				System.out.println(depth+1);
				return;
			}
			
			if(num%2 == 0 && num / 2 >= A) {
				q.offer(new int[] {num/2,depth+1});
			}
			if(num%10 == 1 && num / 10 >= A) {
				q.offer(new int[] {num/10,depth+1});
			}
		}
		System.out.println(-1);
	}

}
