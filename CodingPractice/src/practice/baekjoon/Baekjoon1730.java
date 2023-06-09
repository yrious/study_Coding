package practice.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
 * 판화
 * NxN 처음은 (0,N) 시작
 * 입력 1: N (2 <= N <=10)
 * 입력 2: 로봇팔의 움직임 위 U, 아래 D, 왼 L, 오 R (길이 최대250)
 * 출력: 지나지않으면 .(46), 수직이동 |(124), 수평이동 -(45) 수직/수평 +(43) 표기
 */
public class Baekjoon1730 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char [] robot = (br.readLine()).toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean[][] passVertical = new boolean[N][N];	// 세로로 경유한적이 있는가?
		boolean[][] passHorizontal = new boolean[N][N];	// 가로로 경유한적이 있는가?
		int curR = 0;	// 로봇팔의 현재 위치
		int curC = 0;
		
		for(int i = 0; i<robot.length; i++) {
			char cmd = robot[i];
			if(cmd == 'D') {
				if (curR == N-1) continue;
				passVertical[curR][curC] = passVertical[curR+1][curC] = true;
				curR++;
			}else if(cmd == 'U') {
				if (curR == 0) continue;
				passVertical[curR][curC] = passVertical[curR-1][curC] = true;
				curR--;
			}else if(cmd == 'R') {
				if (curC == N-1) continue;
				passHorizontal[curR][curC] = passHorizontal[curR][curC+1] = true;
				curC++;
			}else if(cmd == 'L') {
				if (curC == 0) continue;
				passHorizontal[curR][curC] = passHorizontal[curR][curC-1] = true;
				curC--;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(passVertical[i][j] && passHorizontal[i][j]) {
					sb.append("+");
				}else if(passVertical[i][j]) {
					sb.append("|");
				}else if(passHorizontal[i][j]) {
					sb.append("-");
				}else{
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
