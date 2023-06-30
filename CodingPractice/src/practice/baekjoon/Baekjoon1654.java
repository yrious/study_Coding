package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 랜선 자르기
 * 입력 1: 이미 가지고 있는 랜선 K개, 필요한 랜선 N개
 * 		(K <= 10,000, 1 <= N <=1,000,000, K <= N)
 * 입력 K: 랜선 길이 (<=2^31 - 1)
 * 출력: N개를 만들 수 있는 랜선의 최대 길이
 */

public class Baekjoon1654 {
	static boolean isPossibleN(long [] cable, long m, int N) {
		int nNum = 0;
		for (long c : cable) {
			nNum += c / m;
		}
		return nNum >= N;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long [] cable = new long [K];
		long min = (1L << 31) - 1;
		for (int i = 0; i < K; i++) {
			cable[i] = Integer.parseInt(br.readLine());
			if(cable[i]>min)min=cable[i];
		}
		// 숫자가 작을 수록 더 많은 랜선을 만들 수 있다.
		long l = 0;
		long r = min;
		long ars = 0;
		while(l<=r) {
			long m = (l+r) / 2;
			if(isPossibleN(cable, m, N)) {
				ars = m;
				l = m + 1;
			}else {
				r = m - 1;
			}
		}
		System.out.println(ars);
	}

}
