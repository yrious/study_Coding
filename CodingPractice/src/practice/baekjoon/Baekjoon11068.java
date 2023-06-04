package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 회문인 수
 * 회문인 수 : 왼/오 부터 읽어도 같을 때 (747, 255(FF(16))
 * 입력 1: 테스트 케이스 T개
 * 입력 2: 테스트 데이터 정수 N (64 <= N <= 1,000,000)
 * 출력 : 회문인 수 1, 아니면 0 (B진법 2<=B<=64)
 */
public class Baekjoon11068 {
	public static String reverse(String str) {
		String reverseStr = "";
		for (int i = str.length()-1; i >= 0; i--) {
			reverseStr += str.charAt(i);
		}
		return reverseStr;
	}
	public static void main(String[] args) throws IOException {
//		입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int result  = 0;
			
			String testString = br.readLine();
			int testNum = Integer.parseInt(testString);
			
			if(testString.equals(reverse(testString))) { 
				result = 1;
			}
			else {
				for (int i = 2; i <= 64; i++) {
					if(i==10)continue;
					// i 진법으로 변환
					String changeString = "";
					int num = testNum;
					while(num > 0) {
						int remainder = num % i;
						num /= i;
						if(remainder < 10)changeString+=remainder;
						else changeString+=(char)(remainder + 55);
						}
					
					if(changeString.equals(reverse(changeString))) {
						result = 1;
						break;
					}
				
				}
				
			}
			System.out.println(result);
		}

	}

}
