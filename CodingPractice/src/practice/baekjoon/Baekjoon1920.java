package practice.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
 * 수 찾기
 * 입력 1: 자연수 N (1 ≤ N ≤ 100,000)
 * 입력 2: N개의 정수 (A[1], A[2], …, A[N])
 * 입력 3: M (1 ≤ M ≤ 100,000)
 * 입력 4: M개의 수 
 * 출력 M: M개의 수들이 N개의 수 중에 존재하면 1, 존재하지 않으면 0
 */
public class Baekjoon1920 {

	public static void main(String[] args) throws IOException {
		
		// N개의 수, M개의 수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] nArray = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			nArray[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int [] mArray = new int [M];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			mArray[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(nArray);
		
		StringBuilder sb = new StringBuilder();
		
		// 이분탐색
		for (int i = 0; i < M; i++) {
			int idx = Arrays.binarySearch(nArray, mArray[i]);
			if(idx < 0) {sb.append("0").append("\n");}
			else{sb.append("1").append("\n");}
		}
		
		/* 이분탐색 구현
		int k = 0;
		for (int i = 0; i < M; i++) {
			int l = 0;
			int r = N;
			while(l <= r) {
				k = (l+r) / 2;
				if(mArray[i] < nArray[k]) {
					r = k-1;}
				else if (mArray[i] > nArray[k]) {
					l = k+1;}
				else {
					sb.append("1").append("\n");
					break;
				}
			}
			if(l > r) {sb.append("0").append("\n");}
		}
		*/
		
		System.out.println(sb);
	}

}
