package bj_6549;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer stt = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stt.nextToken());
			if(N == 0) break;
			int[] histogram = new int[N+1];
			int answer = 0;
			Stack<Integer> st = new Stack<>();
			for(int i = 0; i < N; i++) {
				histogram[i] = Integer.parseInt(stt.nextToken());
			}
			histogram[N] = 0;
//		histogram[0] = 0;
			for(int i = 0; i < N+1; i++) {
				if(st.isEmpty()) {
					st.push(i);
				}
				else {
//				System.out.println(i+"--------");
					while(!st.isEmpty() && histogram[st.peek()] >= histogram[i]) {
						if(histogram[st.peek()] == histogram[i]) {
							st.pop();
						}
						else {
							int prev = st.pop();
							int width = 0;
							if(st.isEmpty()) {
								width = i;
							}
							else {
								width = i - st.peek() - 1; 
							} 
//						System.out.println(prev+" "+(width)*histogram[prev]);
							answer = Math.max((width)*histogram[prev], answer);
						}
					}
					st.push(i);
				}
			}
//		System.out.println(st.size());
			System.out.println(answer);
		}
	}
}
