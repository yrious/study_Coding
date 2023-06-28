package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 숫자 카드 2
 * 입력 1: 상근이가 가지고 있는 숫자카드 개수 N (1 ≤ N ≤ 500,000)
 * 입력 2: N개의 숫자 카드에 적혀있는 정수 (-10,000,000 ≤ num2 ≤ 10,000,000)
 * 입력 3: M (1 ≤ M ≤ 500,000)
 * 입력 4: 상근이가 가지고 있는지 판별할 M개의 정수 (-10,000,000 ≤ num4 ≤ 10,000,000)
 * 출력: 입력 4에 대한 답
 */
public class Baekjoon10816 {

	static int findLowerBoundIndex(int[] arr, int x) {
		// x 이상의 값이 처음으로 나타나는 위치
		int lowerBoundIndex = arr.length;
		int l = 0;
		int r = arr.length -1;
		
		while(l<=r) {
			int m = (l + r) / 2;
			if (arr[m] < x) l = m + 1;
			else {
				r = m - 1;
				lowerBoundIndex = m;
			}
		}
		return lowerBoundIndex;
	}
	static int findUpperBoundIndex(int[] arr, int x) {
		// x 이상의 값이 처음으로 나타나는 위치
		int upperBoundIndex = arr.length;
		int l = 0;
		int r = arr.length -1;
		
		while(l<=r) {
			int m = (l + r) / 2;
			if (arr[m] <= x) l = m + 1;
			else {
				r = m - 1;
				upperBoundIndex = m;
			}
		}
		return upperBoundIndex;
	}

	public static void main(String[] args) throws IOException {
		// 1. 이분탐색으로 찾는다.
		// 2. map으로 찾는다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 방법 1. 이분탐색으로 찾기
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 1. x 이상의 값이 처음으로 나타나는 위치를 구한다.
			int lowerBoundIndex = findLowerBoundIndex(arr, num);
			// 2. x 초과의 값이 처음으로 나타나는 위치를 구한다.
			int upperBoundIndex = findUpperBoundIndex(arr, num);
			// 3. 두 값을 이용해 x의 개수를 센다.
			sb.append(upperBoundIndex - lowerBoundIndex).append(" ");
			
		}
		// 방법 2 map으로 찾기
		/*
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(num,0)).append(" ");
		}
		*/
		System.out.println(sb);
	}


}
