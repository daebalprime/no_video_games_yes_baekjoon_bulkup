package bj_17406;
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, answer, localAns;
	static int[][] orgMap, cmds;
	static int[] di = new int[] {0,1,0,-1};
	static int[] dj = new int[] {1,0,-1,0};
	static int[] nums;
	static boolean[] visited;
	
//	static void
	
	static void perm(int cnt) {
		if(cnt == K) {
			localAns = Integer.MAX_VALUE;
			int[][] srcMap = orgMap;
			for(int n : nums) {
				int[] cmd = cmds[n]; 
				for(int lev = cmd[2]; lev >= 1; lev--) {					
					srcMap = rotate(lev, srcMap, cmd[1]-1, cmd[0]-1);
				}
			}
			for(int[] row : srcMap) {
				int tmp = 0;
				for(int i = 0; i < row.length; i++) {
					tmp += row[i];
				}
				localAns = Math.min(localAns, tmp);
			}
			answer = Math.min(localAns, answer);
			return;
		}
		for(int i = 0; i < K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				nums[cnt] = i;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
	
	public static int[][] deepCopy(int[][] original) {
	    if (original == null) {
	        return null;
	    }

	    int[][] result = new int[N][M];
	    for (int i = 0; i < original.length; i++) {
	        System.arraycopy(original[i], 0, result[i], 0, original[i].length);
	    }
	    return result;
	}
	
	
	static int[][] rotate(int level, int[][] srcMap, int xs, int ys) {
		int maxLength = (2*level+1)*(2*level+1) - (2*level-1)*(2*level-1);
//		System.out.println("len "+ maxLength);
		int x = -level+xs;
		int y = -level+ys;
		int ox = -level+xs;
		int oy = -level+ys;
		int ori = -1;
		int oori = -1;
		int count = 1;
		int[][] newMap = deepCopy(srcMap);
		for(int i = 0; i < count+maxLength; i++) {
			if((x == level+xs || x == xs-level) && (y == level+ys|| y == ys-level)) {
				ori = (ori+1) % 4;
			}
			x += di[ori];
			y += dj[ori];
			if(i >= count) {
				if((ox == level+xs || ox == -level+xs) && (oy == level+ys || oy == -level+ys)) {
					oori = (oori+1) % 4;
				}
				ox += di[oori];
				oy += dj[oori];
				newMap[oy][ox] = srcMap[y][x]; 
			}
		}
		return newMap;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // number of cmds
		orgMap = new int[N][M];
		cmds = new int[K][3];
		visited = new boolean[K];
		nums = new int[K];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				orgMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				cmds[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// initialize
		
		int[][] newMap = new int[N][M];
		perm(0);
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		br.close();
	}
}
