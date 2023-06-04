package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * H층, 층마다 W개의 방 (1<=H, W<=99)
 * 입력 1: 테스트 데이터 T개
 * 입력 2: H, W, N(층 수, 층별 방 수, 몇번째 손님) (1 <= N <= H × W)
 * 출력: N번째 손님에게 배정되어야하는 방 번호
 */
public class Baekjoon10250 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int i = 0;
			int j = 0;
			
			if(n%h==0) {
				i=h;
				j=n/h;
			} else{
				i = n % h;
				j = 1+ (n / h);
			}
			
			System.out.printf("%d%02d\n",i,j);
		}
		
		
	}

}
