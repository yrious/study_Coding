package practice.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
 * 구간 합 구하기 5
 * 입력 1: 표 크기 N(1<=N<=1024), 합을 구해야하는 횟수 M(1<=M<=100,000) 
 * 입력 N: 주어진 표의 수 ( <= 1000)
 * 입력 M: x1 y1 x2 y2 (x1 <= x2, y1 <= y2)
 * 출력 M: (x1, y1)부터 (x2, y2)까지의 합
 */
public class Baekjoon11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int [N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][] acc = new int [N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + arr[i][j];
					
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
				sb.append(acc[x2][y2]-acc[x1-1][y2]-acc[x2][y1-1]+acc[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb);
	}

}
