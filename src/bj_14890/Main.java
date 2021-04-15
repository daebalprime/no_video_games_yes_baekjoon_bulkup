
package bj_14890;



import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int h = map[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for(int j = 0; j < N; j++) {
			int prev = map[j][0];
			int streak = 0; // 같은 블럭이 몇연속인지
			boolean flag = true;
			for(int i = 0; i < N; i++) {
				if(prev - 1 == map[j][i]) { // 높->낮
					if(N-i < X) { // 활주로를 세울 수 없는 경우
						flag = false;
						break;
					}
					else { //활주로를 세울 공간이 확보되었을 때 평지인지 확인
						for(int x = 0; x < X-1; x++) {
							if(map[j][i+x]!=map[j][i+x+1]) {
								flag = false;
								break;
							}
						}
						prev = map[j][i]; // 이전 블럭의 높이 갱신
						i += X-1; // 평지인지 확인한만큼 점프
						streak = 0; // 연속된 정보 초기화
					}
				}else if(prev + 1 == map[j][i]) { // 낮->높
					if(streak < X) { // 만약 지나온 같은 높이의 블럭이 활주로 길이보다 짧을 경우
						flag = false;
						break;
					}else { // 활주로를 세울 수 있을 경우 계속 검사
						prev = map[j][i];
						streak = 1;
						
					}
				}else if(prev == map[j][i]){ // 같은 높이 블럭이 연속할 경우 연속 카운터 ++
					streak++;
				}else { // 높이가 2이상 차이나는 경우 ㅂㅂ
					flag = false;
					break;
				}
			}
			if(flag) {
				++answer; // 만약 활주로를 세울 수 있는 경우 경우 ++
			}
		}
		for(int j = 0; j < N; j++) {
			int prev = map[0][j];
			int streak = 0;
			boolean flag = true;
			for(int i = 0; i < N; i++) {
				if(prev - 1 == map[i][j]) {
					if(N-i < X) {
						flag = false;
						break;
					}
					else {
						for(int x = 0; x < X-1; x++) {
							if(map[i+x][j]!=map[i+x+1][j]) {
								flag = false;
								break;
							}
						}
						prev = map[i][j]; 
						i += X-1;
						streak = 0;
					}
				}else if(prev + 1 == map[i][j]) {
					if(streak < X) {
						flag = false;
						break;
					}else {
						prev = map[i][j];
						streak = 1;
					}
				}else if(prev == map[i][j]){
					streak++;
				}else {
					flag = false;
					break;
				}
			}
			if(flag)++answer;
		}
		
		System.out.println(answer);
		br.close();
	}
}