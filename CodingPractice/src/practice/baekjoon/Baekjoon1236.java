package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 성 지키기
 * 모든 행과 열에는 한 명 이상의 경비원이 있어야 한다.
 * 입력 1 : 성의 크기 N(세로) M(가로) (0<N<=50, 0<M<=50)
 * 입력 2 : 성의 상태 .은 빈 칸, X는 경비원이 있는 칸
 * 출력 : 추가해야하는 경비원의 최솟값
 */
public class Baekjoon1236 {

	public static void main(String[] args) throws IOException {
		// 경비원이 없는 행의 개수, 열의 개수를 각각 구한 후 큰 값 출력

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());// 세로
		int m = Integer.parseInt(st.nextToken());// 가로
		char[][] arr = new char [n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
//		풀이 1
		int countN = 0;
		int countM = 0;
		
		// 보호받지 못하는 행구하기
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j]=='X')break;
				if(j==m-1) {
					countN++;
				}
			}
		}
		
		// 보호받지 못하는 열구하기
		for (int j = 0; j < m; j++) {
			for(int i = 0; i < n; i++) {
				if(arr[i][j]=='X')break;
				if(i==n-1) {
					countM++;
				}
			}
		}
		
//		풀이 2
		// 1. 각 행/열에 대해 경비원이 있는지 확인한다.
/*		boolean [] existN = new boolean[n];
		boolean [] existM = new boolean[m];
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j]=='X') {
					existN[i]=true;
					existM[j]=true;
				}
			}
		}
		
		// 2. 보호받지 못하는 행/열의 개수를 구한다.
		int countN = n;
		int countM = m;
		for(int i = 0; i < n; i++) {
			if(existN[i]) {
				countN--;
			}
		}
		for(int i = 0; i < m; i++) {
			if(existM[i]) {
				countM--;
			}
		}
*/
		// 3. 둘 중 큰 값을 출력한다.
		System.out.println(Math.max(countN,countM));
		
	}

}
