package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 진법 변환2
 * 입력 1 : N (0 < N <= 10억) B (2 <= B <= 36)
 * 출력 : N을 B진법으로 출력
 */
public class Baekjoon11005{

	public static void main(String[] args)  throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		while(N > 0) {
			int remainder = N % B;
			N /= B;
			if(remainder < 10) sb.append(remainder);
			else sb.append((char)(remainder + 55));
		}
		System.out.println(sb.reverse());
	}

}
