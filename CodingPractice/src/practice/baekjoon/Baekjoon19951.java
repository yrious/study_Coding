package practice.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/*
 * 입력 1: 연병장 크기 N(1 ≤ N ≤ 100,000), 조교 수 M(1 ≤ M ≤ 100,000)
 * 입력 2: 각 칸의 높이 H1....Hn (-10,000 ≤ Hi ≤ 10,000)
 * 입력 M: 조교의 지시 a, b, k (1 ≤ a ≤ b ≤ N, |k| ≤ 100)
 * k ≥ 0 Ha~Hb + |k| 
 * k < 0 Ha~Hb - |k| 
 * 출력 : 
 */
public class Baekjoon19951 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] H = new int [N+1];
		st = new  StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= N; i++) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		
		// 조교의 지시
		int [] delta = new int [N+2]; // 해당칸부터 마지막 칸 까지 적용되는 변화량 기록
		for (int i = 0; i < M; i++) {
			st = new  StringTokenizer(br.readLine()," ");
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			int k =  Integer.parseInt(st.nextToken());
			
			delta[a] += k;
			delta[b+1] -= k;
		}
		int [] accDelta = new int [N+1]; // 실제 변화량
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			accDelta[i] = accDelta[i-1] + delta[i];
			sb.append(H[i]+accDelta[i]).append(" ");
		}
		System.out.println(sb);
	}

}
