package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
/*
 * 좌표압축
 * 좌표압축 : 정렬, 중복제거
 * 입력 1: N개의 좌표 (1<=N<=1,000,000)
 * 입력 2: 공백으로 구분된 좌표값 X1 ... Xn (-10^9 <= Xi <= 10^9)
 * 출력: 좌표압축을 적용한 결과(인덱스) X'1 ... X'n
 */
public class Baekjoon18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new TreeSet<>();
		int [] x = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(st.nextToken());
			set.add(x[i]);
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for (int i : set) {
			map.put(i, index++);
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(map.get(x[i])).append(" ");
		}
		
		System.out.println(sb);
	}

}
