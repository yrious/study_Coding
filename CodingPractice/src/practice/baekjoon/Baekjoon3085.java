package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 사탕 게임
 * N×N (색은 모두 같지 않을 수도 있다)
 * 입력 1: 보드의 크기 N (3 ≤ N ≤ 50)
 * 입력 2: 사탕의 색상 (빨C, 파P, 초Z, 노Y)
 * 출력 : 먹을 수 있는 사탕의 최대 개수
 */
public class Baekjoon3085 {
	public static void swapCandy(char [][] candy, int r1, int c1, int r2, int c2) {
		char tmp = candy[r1][c1];
		candy[r1][c1] = candy[r2][c2];
		candy[r2][c2] = tmp;
	}
	public static int maxColumn(char [][] candy) {
		int N = candy.length;
		int maxColumn = 0;
		for(int c = 0; c < N; c++) {
			int len = 1;
			for(int r = 1; r < N; r++) {
				if(candy[r][c] == candy[r-1][c]) len++;
				else {
					maxColumn = Math.max(maxColumn, len);
					len = 1;
				}
			}
			maxColumn = Math.max(maxColumn, len);
		}
		return maxColumn;
	}
	public static int maxRow(char [][] candy) {
		int N = candy.length;
		int maxRow = 0;
		for(int r = 0; r < N; r++) {
			int len = 1;
			for(int c = 1; c < N; c++) {
				if(candy[r][c] == candy[r][c-1]) len++;
				else {
					maxRow = Math.max(maxRow, len);
					len = 1;
				}
			}
			maxRow = Math.max(maxRow, len);
		}
		return maxRow;
	}
	
	public static void main(String[] args) throws IOException {
//		1. 가능한 모든 쌍의 사탕을 서로 교환한다.
//		2. 교환한 상태에서 가장 긴 연속 부분 행/열을 찾는다.
//		3. 교환한 사탕을 원복한다. 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char [][] candy = new char[N][N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			candy[i] = (br.readLine()).toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if( j+1 < N && candy[i][j] != candy[i][j+1]) {
					swapCandy(candy, i, j, i, j+1);
					max = Math.max(max, Math.max(maxColumn(candy), maxRow(candy)));
					swapCandy(candy, i, j, i, j+1);
				}
				if( i+1 < N && candy[i][j] != candy[i+1][j]) {
					swapCandy(candy, i, j, i+1, j);
					max = Math.max(max, Math.max(maxColumn(candy), maxRow(candy)));
					swapCandy(candy, i, j, i+1, j);
				}
			}
		}
		System.out.println(max);
	}

}
