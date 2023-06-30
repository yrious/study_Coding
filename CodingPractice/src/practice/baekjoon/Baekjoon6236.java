package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 용돈 관리
 * 정확히 M번 K원을 인출하여 사용할 때 인출 금액 K의 최소값?
 * (인출시 남은 돈은 다시 통장에 넣는다)
 * 입력 1: N일 M번  (1 ≤ N ≤ 100,000, 1 ≤ M ≤ N)
 * 입력 N: i번째 날에 이용할 금액 (1 ≤ 금액 ≤ 10000)
 * 출력: 통장에서 인출해야 할 최소 금액 K 
 */
public class Baekjoon6236 {

	static boolean isFillM(int[] dayMoney, int m, int M) {
		int num = 1;
		int now = m;
		for (int day : dayMoney) {
			if(now - day < 0) {
				num ++;
				now = m;
			}
			now -= day;
		}
		return num <= M;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] dayMoney = new int [N];
		int r = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			dayMoney[i] = temp;
			r += temp;
			if(max<temp)max=temp;
		}
		// 통장에서 인출해야할 최소 금액 K
		int l = max;
		int K = -1;
		
		while(l<=r) {
			int m = (l + r) / 2;
			if(isFillM(dayMoney, m, M)) {
				K = m;
				r = m - 1;
			}else {
				l = m + 1;
			}
		}
		
		System.out.println(K);
	}
}
