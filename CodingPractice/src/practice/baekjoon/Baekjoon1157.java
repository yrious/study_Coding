package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 단어 공부
 * 입력 : 알파벳 대소문자로된 단어 (1,000,000이하, 대소문자구분 없음)
 * 출력 : 가장 많이 사용된 알파벳, 대문자로 (여러개 존재할 때 ?)출력
 */
public class Baekjoon1157 {
	
	public static int[] getAlphabetCount(String str) {
		int [] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)-'A']++;
		}
		return count;
	}

	public static void main(String[] args) throws IOException{
		
		int maxCount = -1;
		char maxAlphabet = '?';
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 입력값 알파벳 대문자로 toUpper
		String str = br.readLine().toUpperCase();

		// 2. 알파벳 카운트(int countStr)
		int [] countStr = getAlphabetCount(str);
		
		// 3. maxCount 찾기, 4. 동일한 값 있는지 찾기
		for (int i = 0; i < 26; i++) {
			if(maxCount < countStr[i]) {
				maxCount = countStr[i];
				maxAlphabet = (char)('A' + i);
			}
			else if ( maxCount == countStr[i] ) {
				maxAlphabet = '?';
			}
		}
		System.out.println(maxAlphabet);
		
		br.close();
	}
/*	풀이 2
	public static void main(String[] args) throws IOException{
		int maxCount = -1;
		char maxAlphabet = '?';
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// (1)
		String str = br.readLine().toUpperCase();
		// (2)
		int [] countStr =  new int[26];
		int now = 0;
		for (int i = 0; i < str.length(); i++) {
			now = str.charAt(i)-'A';
			countStr[now]++;
			if(maxCount < countStr[now]) {
				maxCount = countStr[now];
				maxAlphabet = str.charAt(i);
			}else if ( maxCount == countStr[now] ) {
				maxAlphabet = '?';
			}
			
		}
		System.out.println(maxAlphabet);
		
		br.close();
	}
*/
}