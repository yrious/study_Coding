package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 입력 1 : 테스트 케이스의 개수
 * 입력 2 : 자연수 K (3 <= K <= 1000) (T개)
 * 출력 : 3개의 삼각수 합 가능 1, 불가능 0 (테스트케이스별)
 */
public class Baekjoon10448{
	
	static boolean[] isEurekaNumber = new boolean [1001];
	
	public static void preprocess() {
		// 1. K보다 작은 삼각수를 모두 구한다.
		int [] triangleNumbers = new int [50];
		int triangleNumberCount = 0;
		for (int i = 1; ; i++) {
			int triangleNumber = i*(i+1)/2;
			if (triangleNumber >= 1000)break;
			triangleNumbers[triangleNumberCount++] = triangleNumber;
		}
		// 2. 구해진 삼각수 세개의 합으로 K를 나타낼 수 있는지 확인한다.
		boolean[] isSumOfTriangleNumber = new boolean[1000];
		for (int i = 0; i < triangleNumberCount; i++) {
			for (int j = 0; j < triangleNumberCount; j++) {
				int sum = triangleNumbers[i] + triangleNumbers[j];
				if (sum < 1000) isSumOfTriangleNumber[sum] = true;
			}
		}
		
		for (int i = 1; i < 1000; i++) {
			if(!isSumOfTriangleNumber[i]) continue;
			for (int j = 0; j < triangleNumberCount; j++) {
				int sum = i + triangleNumbers[j];
				if(sum <= 1000) isEurekaNumber[sum] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
	
		preprocess();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(isEurekaNumber[k] ? "1":"0");
		}
	
	
	}
}
