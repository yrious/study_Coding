package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 대소문자 바꾸기
 * 입력 : 영어 소문자와 대문자로 이루어진 단어 (길이 최대 100)
 * 출력 : 소문자는 대문자, 대문자는 소문자로 변환
 */
public class Baekjoon2744 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		for(int i=0 ; i<str.length(); i++) {
//			// 대문자라면
//			if(str.charAt(i) < 97 ) {
//				sb.append((char)(str.charAt(i)+32));
//			}// 소문자라면
//			else {
//				sb.append((char)(str.charAt(i)-32));
//			}
			char ch = str.charAt(i);
			if('A' <= ch && ch <='Z')
				sb.append((char)('a' + ch - 'A'));
			else {
				sb.append((char)('A' + ch - 'a'));
			}
			
		}
		System.out.println(sb);
	}

}
