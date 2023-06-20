package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 생명 게임
 * 입력 1: 세로 N, 가로 M(1 ≤ N, M ≤ 100), 시간 T(1 ≤ T ≤ 300)
 * 입력 2: 주위의 기준 정수 K, 다음 칸 상황을 결정하는 정수 a, b(0 ≤ a, b < (2×K+1)^2)
 * 입력 N: 처음 상태 (길이 M, 생명 O : *, 빈칸 : .)
 * 출력 : T 시간 후 바둑판의 상태
 */
public class Baekjoon17232 {

	// 현재 시간의 누적합
	static int[][] getPrefixSum(char [][] board){
		int [][] acc = new int[board.length][board[0].length];
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1]
							+(board[i][j] == '*' ? 1 : 0);
			}
		}
		return acc;
	}
	
	// 주변 생명 구하기
	static int getRangeSum(int[][] acc, int r, int c, int K) {
		 int r1 = Math.max(r - K, 1);
		 int c1 = Math.max(c - K, 1);
		 int r2 = Math.min(r + K, acc.length-1);
		 int c2 = Math.min(c + K, acc[0].length-1);
		 
		 return acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1];
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int K = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		char [][] board = new char [N+1][M+1];
		for (int i = 1; i <= N; i++) {
				String str = br.readLine();
				for(int j = 1; j <= M; j++) {
				board[i][j] = str.charAt(j - 1);
				}
		}

		// 현재 칸에 생명이 있을 때 주위에 (2k+1)
		// a <= L(생명개수) <= b -> 현재 칸 생명 생존
		// L < a || L > b -> 죽음
		// 현재 칸에 생명이 없을 때
		//  a < L <= b 생명 탄생
		
		// T시간
		while(T-- > 0) {
			// 누적합 이용
			int[][] acc = getPrefixSum(board);
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					// 주변 생명 개수 파악
					int nearAlive = getRangeSum(acc, i, j, K);
					
					if(board[i][j] == '*') {
						nearAlive--;	// 자기자신 제외
						if(nearAlive < a || b < nearAlive) {
							board[i][j] = '.';
						}
					}
					else if (a < nearAlive && nearAlive <= b) {
						board[i][j] = '*';
					}
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
