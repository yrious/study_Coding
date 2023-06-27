package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

/*
 * 두 용액
 * 입력 1: 전체 용액의 수 N (2 <= N <= 100,000)
 * 입력 2: 특성값 N개 ( -1,000,000,000 이상 1,000,000,000 이하, 중복X) 
 * 출력 : 두 개의 특성 값의 합이 0에 가장 가까운 경우 두 용액의 특성값
 */
public class Baekjoon2470 {

	static int findOptimalPairValue(int[] arr, int l, int r, int value) {
		int optimalPairAbs = 2000000000;
		int optimalPairValue = 0;
		while(l <= r) {
			int m = (l + r) / 2;
			int sum = value + arr[m];
			
			int sumAbs = Math.abs(sum);
			if( sumAbs < optimalPairAbs) {
				optimalPairValue = arr[m];
				optimalPairAbs = sumAbs;
			}
			
			if(sum < 0) l = m + 1;
			else if (sum > 0) r = m - 1;
			else return arr[m];
		}
		return optimalPairValue;
	}
	public static void main(String[] args) throws IOException {
		// | A + B | 가 가장 작은 경우

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int [] arr = new int [N]; // 용액 집합
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1. 첫 번째 용액에 대해 최적쌍이 되는 두번째 용액을 찾는다. (binarySearch)
		Arrays.sort(arr);
		
		int ansAbs = 2000000000;
		int ansA = -1;
		int ansB = -1;
		for (int i = 0; i < N - 1 ; i++) {
			int pairValue = findOptimalPairValue(arr, i+1, N-1, arr[i]);
			int abs = Math.abs(arr[i] + pairValue);
			if(abs < ansAbs) {
				ansAbs = abs;
				ansA = arr[i];
				ansB = pairValue;
			}
		}
		
		// 2. 두 용액의 합이 0에 가장 가까운 쌍을 출력한다.
		System.out.println(ansA + " " + ansB);
		
	}


}
