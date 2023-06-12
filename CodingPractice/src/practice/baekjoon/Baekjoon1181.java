package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/*
 * 단어 정렬
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 * 3. 중복이면 하나만 남기고 제거
 * 입력 1: 단어의 개수 N ( 1 <= N <= 20,000)
 * 입력 N: 단어 (lenghth <= 50)
 */
public class Baekjoon1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		String [] words = new String [N];
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())
					return o1.compareTo(o2); // 사전 순 정렬
				return o1.length() - o2.length();
			}
		});
		
		// 정렬 후 중복이 아니면 출력
		sb.append(words[0]).append("\n");
		for (int i = 1; i < N; i++) {
			if(!words[i].equals(words[i-1]))
				sb.append(words[i]).append("\n");
		}
		System.out.println(sb);
	}

}
