package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 문자열 집합
 * 입력 1: 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)
 * 입력 N: 집합 S에 포함되어 있는 문자열
 * 입력 M: 검사해야하는 문자열 (소문자, length ≤  500, 중복없음)
 * 출력: M개 문자열 중 집합 S에 포함된 문자열의 개수
 */
public class Baekjoon14425 {

	public static void main(String[] args) throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String [] sArray = new String[N]; 
		for (int i = 0; i < N; i++) {
			sArray[i] = br.readLine();
		}
		String [] mArray = new String[M]; 
		for (int i = 0; i < M; i++) {
			mArray[i] = br.readLine();
		}
		
		Arrays.sort(sArray);
		
		int num = 0;
		for (int i = 0; i < M; i++) {
			if(Arrays.binarySearch(sArray, mArray[i])>=0)
				num++;
		}
		
		System.out.println(num);
	}
}
