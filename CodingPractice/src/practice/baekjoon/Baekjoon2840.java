package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 행운의 바퀴
 * 바퀴를 시계방향으로 S칸 돌릴때마다 화살표가 가리키는 글자가 주어질 때
 * 바퀴의 각 칸에 적어놓은 알파벳을 알아내자
 * 
 * 입력 1: 바퀴칸 수 N, 돌리는 횟수 K (2 <= N <= 25, 1<= K <= 100)
 * 입력 2(K번): 회전 후 화살표가 가리키는 글자, 몇번 바뀌었는지 나타내는 S(=몇칸이동 했는지)(1 <= S <= 100)
 * 출력: 화살표가 가리키는 문자부터 시계방향 알파벳으로 바퀴에 적은 알파벳 출력
 * (어떤글자인지 결정못하면 '?', 없다면 '!') 
 */
public class Baekjoon2840 {

	public static void main(String[] args) throws IOException {
		// 바퀴의 커서 인덱스를 S만큼 움직인다. (커서 인덱스가 배열범위를 벗어나면 조정)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// 바퀴 칸 수
		int N = Integer.parseInt(st.nextToken());
		// 회전 수
		int K = Integer.parseInt(st.nextToken());
		
		char[] wheel = new char[N];
		Arrays.fill(wheel, '?');
		int curIndex = 0;
		
		while(K -- > 0) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			int step =  Integer.parseInt(st2.nextToken());
			char nextAlphabet = st2.nextToken().charAt(0);
			
			int nextIndex = ((curIndex - step) % N + N) % N; // 음수 % 는 음수 이므로 +N 해서 한번더 % 해준다.
			
			if(wheel[nextIndex] == '?')wheel[nextIndex]=nextAlphabet;
			else if(wheel[nextIndex] != nextAlphabet) {
				System.out.println("!");
				return ;
			}
			curIndex = nextIndex;
		}
		
		boolean [] used = new boolean[26];
		for (int i = 0; i < N; i++) {
			if(wheel[i] == '?') continue;
			if(used[wheel[i] - 'A']) {
				System.out.println("!");
				return ;
			}
			used[wheel[i] - 'A'] = true;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(wheel[(curIndex + i) % N]);
		}
	}

}
