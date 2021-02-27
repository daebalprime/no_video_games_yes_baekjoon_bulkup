package bj_2578;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, int[]> bingo = new HashMap<>();
		for(int j = 0; j < 5; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 5; i++) {
				bingo.put(Integer.parseInt(st.nextToken()),new int[] {i,j});
			}
		}
		int[] col = new int[5];
		int[] row = new int[5];
		int[] dia1 = new int[9];
		int[] dia2 = new int[9];
		int tot = 0;
		for(int j = 0; j < 5; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 5; i++) {// find
				int[] curr = bingo.get( Integer.parseInt(st.nextToken()));
				int x = curr[0];
				int y = curr[1];
				col[x]++;
				if(col[x] == 5) tot++;
				row[y]++;
				if(row[y] == 5) tot++;
				dia1[4+y-x]++;
				if(dia1[4+(y-x)] == 5) tot++;
				dia2[x+y]++;
				if(dia2[x+y] == 5) tot++;
				if(tot >= 3) {
					System.out.println(5*j + i + 1);
					System.exit(0);
				}
			}
		}
		br.close();
	}

}
