package practice.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 수 정렬하기 3
 * 입력 1 : 수의 개수 N (1 <= N <= 10,000,000)
 * 입력 2 : N개의 수 ( 0 < 수 < = 10,000)
 * 출력 : N개의 줄로 나누어 오름차순 출력
 */
public class Baekjoon10989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [10001];
		
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		// 오름차순 정렬 
		for (int i = 1; i <= 10000; i++) {
			while(arr[i]-- > 0) {
				bw.write(i+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
