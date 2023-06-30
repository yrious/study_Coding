package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 공유기 설치
 * 입력 1:  집의 개수 N, 공유기의 개수 C
 *  	  (2 ≤ N ≤ 200,000, 2 ≤ C ≤ N)
 * 입력 N: 집의 좌표 xi (0 ≤ xi ≤ 1,000,000,000)
 * 출력: 가장 인접한 두 공유기 사이의 최대 거리
 */

public class Baekjoon2110 {
	// m의 거리에 대해 배치할 수 있는 공유기 개수
	static int calculateCount(int[] home, int distance) { 
		int count = 1;
		int pastX = home[0];
		for (int i = 1; i < home.length; i++) {
			// (내가 설치한 공유기 좌표 - 바로이전 공유기좌표)거리가 내가 지정한 최소 거리이상 -> 설치
			if(home[i] - pastX >= distance) {
				pastX = home[i];
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int [] home = new int [N];
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		
		// 1. 공유기 사이의 거리 탐색 범위를 정한다.
		int l = 1; 
		int r = home[N-1] - home[0];
		int ans = -1;
		// 2. 인접한 공유기 사이의 거리에 대해
		while(l <= r) {
			int m = (l + r) / 2;
			// 2-1. 해당 거리를 지키면서 모든 공유기를 설치할 수 있다면 공유기 사이 거리를 늘려본다.
			if(calculateCount(home, m) >= C) {
				ans = m;
				l = m + 1;
			}else {
			// 2-2. 모든 공유기를 설치하는게 불가능하다면 공유기 사이 거리를 좁혀본다.
				r = m - 1;
			}
		}
		
		// 3. 가능한 공유기 사이의 최대 거리를 출력한다.
		System.out.println(ans);
		
		
	}

}
