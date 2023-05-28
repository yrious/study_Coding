package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문서검색
 * 영어로 이루어진 문서 검색 - 중복되어 세는 것은 제외
 * ababab 문서에서 ababa단어를 찾으려면 1번만(0시작 또는 2시작)
 * 입력 : 첫째줄 문서 (최대 2500자) / 둘째줄 단어 (최대 50) (알파벳소문자, 공백)
 * 출력 : 단어 수 (최대, 중복없이)
 */
public class Baekjoon1543 {

	public static void main(String[] args) throws IOException{
//		풀이1 - indexOf()
  		
/*		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String document = br.readLine();
		String search = br.readLine();
		
		int count = 0;
		int startIndex = 0;
		
		while(true) {
			int findIndex = document.indexOf(search, startIndex);
			if(findIndex < 0){
				break;
			}
			count++;
			startIndex = findIndex + search.length();
		}
		System.out.println(count);
*/
		
		
//		풀이2 - replace()
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		
		String document = br.readLine();
		String search = br.readLine();
		
		String replaced = document.replace(search, "");
		count = (document.length() - replaced.length()) / search.length();
		
		System.out.println(count);
	}
}
