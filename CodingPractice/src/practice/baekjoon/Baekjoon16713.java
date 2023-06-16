package practice.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
 * Generic Queries
 * 
 * 입력 1: 수열 길이 N (1<=N<=10^6), 쿼리 Q개(1<=Q<=3*10^6)
 * 입력 2: a1 a2 ... an (0<=ai<=10^9)
 * 입력 Q: 쿼리 si, ei (1<=si<=ei<=N)
 * 출력: 모든 쿼리 XOR
 */
public class Baekjoon16713{
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int [] arr = new int [N+1];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1. 누적 XOR 배열 구하기
		int [] acc = new int [N+1];
		for (int i = 1; i <= N; i++) {
			acc[i] = acc[i-1] ^ arr[i];
		}
		
		// 2. Q번의 [s:e] 쿼리에 대해 누적XOR 배열을 사용하여 구간 XOR 구하기
		int ans = 0;
		while(Q-- > 0) {
			st = new StringTokenizer(br.readLine()," ");
			int s =  Integer.parseInt(st.nextToken());
			int e =  Integer.parseInt(st.nextToken());
			ans ^= acc[e] ^ acc[s-1];
		}
		
		System.out.println(ans);
	}

}
