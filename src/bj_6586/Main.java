package bj_6586;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			boolean[] row = new boolean[N];
			boolean[] col = new boolean[N];
			int rowCnt, colCnt = rowCnt = N;
			// false -> parity
			// true -> non-parity
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					if(st.nextToken().charAt(0) == '1') {
						col[j] ^= true;
						row[i] ^= true;
						rowCnt = row[i] ? rowCnt + 1 : rowCnt-1;
						colCnt = col[j] ? colCnt + 1 : colCnt-1;
					}
				}
			}
//			System.out.println(rowCnt + " " + colCnt);
			if(rowCnt == N && colCnt == N) sb.append("OK\n");
			else if(Math.abs(rowCnt - N) == 1 && Math.abs(colCnt - N) == 1) {
				boolean flag = true;
				for(int i = 0; i < N; i++) {
					if(!flag) break;
					if(row[i]){
						for(int j = 0; j < N; j++) {
							if(col[j]) {
								sb.append("Change bit ("+(i+1)+","+(j+1)+")\n");
							}
						}
					}
				}
			}else {
				sb.append("Corrupt\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
