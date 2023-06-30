package practice.baekjoon;

/*
 * 나무 자르기
 * 입력 1: 나무의 수 N, 필요한 나무 길이 M (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
 * 입력 2: 나무 N개의 각 높이 (≤ 1,000,000,000)
 * 출력: M미터의 나무를 가져가기 위한 절단기 높이의 최댓값 H (나무-H를 가져감)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2805 {

	static boolean isPossible(int [] tree, int cutH, int M) {
		long sum = 0;
		for(int h : tree) {
			if(h > cutH) sum += h - cutH;
		}
		return sum >= M;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int [] tree = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i]>max)max = tree[i];
		}
		
		// 절단기의 높이, 절단기 높이가 높을수록 나무를 적게 가져간다.
		int ans = 1;
		int l = 0;
		int r = max - 1;
		
		while(l<=r) {
			int m = (l + r) / 2;
			if(isPossible(tree, m, M)) {	// 절단기 높이를 높인다.
				ans = m;
				l = m + 1;
			}else {	// 절단기 높이를 낮춘다.
				r = m - 1;
			}
		}
		
		System.out.println(ans);
		
	}
}
