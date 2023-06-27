package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 세 수의 합
 * 입력 1: 자연수 N (5 ≤ N ≤ 1,000)
 * 입력 N: 집합 U의 원소 (≤ 200,000,000, 중복 없음, 답 존재)
 * 출력: 집합 U의 원소의 세 수의 합 중 가장 큰 값(집합 U에 포함)  
 */
public class Baekjoon2295 {

//	static boolean isExist(int[] arr, int target) {
//		int l = 0;
//		int r = arr.length - 1;
//		
//		while(l <= r) {
//			int k = (l + r) / 2;
//			if(arr[k] < target) l = k+1 ;
//			else if(arr[k] > target) r = k-1;
//			else { return true; }
//		}
//		return false;
//	}
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] U = new int [N];
		for (int i = 0; i < N; i++) {
			U[i] = Integer.parseInt(br.readLine());
		}
		
		// A + B + C = X -> A + B = X - C
		// 1. A+B 집합 만들기
		int [] sums = new int[N * (N+1) / 2]; // 1~N까지의 합
		int sumsIndex = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				sums[sumsIndex++] = U[i] + U[j]; 
			}
		}
		
		Arrays.sort(sums);
		
		// 2. 모든 X-C에 대해 A+B집합에 존재하는지 확인
		// 3. A+B = X-C 을 만족하는 X 중 최대값을 출력 
		int ans = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int target = U[i] - U[j];
				if(Arrays.binarySearch(sums, target) >= 0)
//				if(isExist(sums, target))
					ans = Math.max(ans, U[i]);
			}
		}
		System.out.println(ans);
		
		
		
		
	}


}
