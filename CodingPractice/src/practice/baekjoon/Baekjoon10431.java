package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 줄세우기
 * 입력 1 : 테스트 케이스의 수 P (1 <= P <= 1000)
 * 입력 2 : 테스트 케이스 번호 T, 양의 정수 20개(아이들 키)
 * 출력 : 각 테이스 케이스에 대한 뒤로 물러난 걸음 수
 */
public class Baekjoon10431 {

	public static void main(String[] args) throws IOException {
		// 1. 줄 서 있는 학생 중에 자신보다 큰 학생을 찾는다.
		// 1-1. 찾지 못했다면 줄의 가정 뒤에 선다. 
		// 2. 찾았다면, 그 학생의 앞에 선다.
		// 3. 그 학생과 그 뒤의 학생이 모두 한칸씩 물러선다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());
		int [] student = new int [20];
		
		// 풀이 1
/*		// p번 반복
		for (int i = 0; i < p; i++) {
			int [] sorted = new int [20];
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			// 테스트 케이스 번호
			st.nextToken();
			// 학생 20명 순서대로 입력
			for(int j = 0; j < 20; j++ ) {
				student[j] = Integer.parseInt(st.nextToken());
			}
			// j번째 학생
			for(int j = 0; j < 20; j++ ) {
				boolean find = false;
				// 줄 서 있는 학생 중 자신(j)보다 큰 학생(k) 찾기
				for (int k = 0; k < j; k++) {
					if(sorted[k] > student[j]) {
						find = true;
						for (int l = j-1 ; l >= k; l--) {
							sorted[l+1] = sorted[l];
							count++;
						}
							sorted[k] = student[j];
							break;
					}
				}
				// 찾지 못했다면 줄의 가장 뒤에 선다.
				if(!find) {
					sorted[j]=student[j];}
				
			} 
			System.out.printf("%d %d\n",i+1,count);
		}*/
		
		// 풀이2 - 물러난 횟수의 걸음 수 = 현재 학생(j) 보다 큰 수의 개수의 총합
		for (int i = 0; i < p; i++) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			// 테스트 케이스 번호
			st.nextToken();
			// 학생 20명 순서대로 입력
			for(int j = 0; j < 20; j++ ) {
				student[j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < 20; j++ ) {
				for (int k = 0; k < j; k++) {
					if(student[k]>student[j]) {
						count++;
					}
				}
			}
			System.out.printf("%d %d\n",i+1,count);
		}
	}
}
