package bj_3109;

import java.io.*;
import java.util.*;

public class Main {
	static int R,C, answer;
	static boolean[][] map;
	static int[] dj = {-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) == '.';
			}
		}
		for(int j = 0; j < R; j++) {
			back(0,j);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static boolean back(int x, int y) {
		if(x == C-1) {
			answer++;
			return true;
		}
		if(!map[y][x]) {
			return false;
		}
		
		boolean flag = false;
		for(int k = 0; k < 3; k++) {
			if(y+dj[k] >= 0 && y+dj[k] < R) flag = back(x+1, y+dj[k]);
			if(flag) break;
		}
		map[y][x] = false;
		return flag;
	}

}

/* TEST CASES

100 5
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
.....
...x.
...x.
.....
...x.
...x.
...x.
.....
.....
..x..
..x..
.....
..x..
.....
..x..
.....

//92

5 5
..x..
..x..
..x..
...x.
...x.

//1

7 7
.x...x.
.x.x..x
....x..
..x....
...x.x.
.x.x.x.
.....x.
//3

6 6
.x....
.x.x..
.x.x..
.x.x..
.x.x..
...x..

//0
 
18 5
.....
.....
.....
...x.
...x.
.....
...x.
...x.
...x.
.....
.....
..x..
..x..
.....
..x..
.....
..x..
.....
 
//10
 
 
6 10
..x.......
.....x....
.x....x...
...x...xx.
..........
....x.....
//5

2 5
.x...
..xxx
//1
 
 
 
 */