package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 최솟값 최댓값 구하기
 * 입력 : N, N개의 정수 ( 1 <= N <= 1,000,000)
 * 출력 : 최솟값, 최댓값 (-1,000,000 <= number <= 1,000,000)
 */
public class Baekjoon10818{
	public static void main(String[] args) throws IOException {
		
		int min = 1000000;
		int max = -1000000;
		int num = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// 최솟값, 최댓값 계산
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num>max) {max=num;}
			if(num<min) {min=num;}
		}
		
		// 출력
		System.out.printf("%d %d",min,max);
	}
}