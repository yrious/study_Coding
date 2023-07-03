package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 수들의 합 2
 * 입력 1: N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)
 * 입력 2: A[1], A[2], …, A[N] (A[x] ≤ 30,000)
 * 출력: A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수
 */
public class Baekjoon2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int [] A = new int [N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int j = 0;
		int currentSum = A[0];
		int ars = 0;
		for (int i = 0; i < N; i++) {
			// 현재 구간의 합이 M보다 크거나 같을 때까지 j 이동
			while(currentSum < M && j < N - 1) {
				currentSum += A[++j];
			}
			if(currentSum == M)ars++;
			currentSum -= A[i];
		}
		System.out.println(ars);
	}

}
