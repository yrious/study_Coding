package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 부분합
 * 입력 1: 수열의 길이 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)
 * 입력 2: 수열 (≤ 10,000, 자연수)
 * 출력: 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이, 없으면 0
 * 
 */
public class Baekjoon1806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int [] arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int currentSum = arr[0];
		int minLength = 100001;
		int rightIndex = 0;
		for (int i = 0; i < N; i++) {
			while(currentSum < S && rightIndex < N-1 ) {
				currentSum += arr[++rightIndex];
			}
			if(currentSum >= S) {
				minLength  = Math.min(minLength, rightIndex-i+1);
			}
			currentSum -= arr[i];
		}
		System.out.println(minLength == 100001 ? 0 : minLength);
	}

}
