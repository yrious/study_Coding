package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 애너그림 만들기
 * 애너그램 관계 - 두 영어 단어가 철차의 순서를 뒤바꾸어 같아질 수 있을 때
 * occurs 와 succor는 애너그램 관계
 * dared 와 bread는 d와 b를 제외하면 (ared와 read) 애너그램 관계가 됨
 * 제거해야하는 최소 문자 개수를 구하는 프로그램 만들기
 * 입력 : 첫째줄/둘째줄 영어단어 소문자 (한글자 이상, 1000자 이내)
 * 출력 : 최소 문자 개수
 */
public class Baekjoon1919 {
	
	// 알파벳 카운트
	public static int[] getAlphabetCount(String str) {
		int[] count = new int[26];
		for(int i = 0; i < str.length(); i++) {
			count[str.charAt(i)-'a']++;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		// 없애야하는 문자 : 공통 문자를 제외한 전부, 알파벳 카운트 이용
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		
		// 알파벳 26자 들어갈 배열 생성, 카운트
		int[] countA = getAlphabetCount(a);
		int[] countB = getAlphabetCount(b);
		
		// answer : a배열과 b배열의 차이를 모두 더해준다.
		int answer = 0;
		for (int i = 0; i < 26; i++) {
			answer += Math.abs(countA[i]-countB[i]);
		}
		System.out.println(answer);
	}

}
