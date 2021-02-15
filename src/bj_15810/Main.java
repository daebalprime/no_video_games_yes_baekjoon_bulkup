package bj_15810;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2)-> {
			long ret = (o1[0]+o1[1]-o2[0]-o2[1]);
			return  ret < 0 ? -1 : (ret == 0 ? 0 : 1);
//			return (int) (o1[0]+o1[1]-o2[0]-o2[1]);
		});
		long answer = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			pq.offer(new long[] {Integer.parseInt(st.nextToken()), 0});
		}
		for(int i = 0; i < M; i++) {
			long[] tmp = pq.poll();
//			System.out.println(Arrays.toString(tmp));
			answer = Math.max(answer, tmp[0]+tmp[1]);
			tmp[1] += tmp[0];
			pq.offer(tmp);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}

//생성자
//초기화
//자바예외 종류 예외처리 방법 *** runtime exception 공부 하기
//String toString
//boolean equals
//serializable -> 객체 직렬화 실패!
//catch  e.printStackTrace();\
//compareTo - 정수 마이너스 대신에 래퍼 클래스의 compareTo 사용하기