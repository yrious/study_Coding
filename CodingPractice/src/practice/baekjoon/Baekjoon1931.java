package practice.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/*
 * 회의실 배정
 * 입력 1: 회의의 수 N (1 <= N <= 100,000)
 * 입력 N: 시작시간T 끝나는시간T (T <= 2^31-1 || T == 0)
 * 출력: 사용할 수 있는 회의의 최대 개수
 */
public class Baekjoon1931 {
	static class Meeting {
		int startTime;
		int endTime;
		Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Meeting [] meetings = new Meeting [N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		// 정렬
		// 1. 종료시간이 빠른 회의 먼저
		// 2. 종료시간이 같다면 시작시간이 빠른 회의 먼저
		Arrays.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1,Meeting o2) {
				if(o1.endTime==o2.endTime)return o1.startTime-o2.startTime;
				return o1.endTime-o2.endTime;
			}
		});
		
		int count = 0;
		int ended = 0;
		for (Meeting meeting : meetings) {
			if(ended <= meeting.startTime) {
				count++;
				ended = meeting.endTime;
			}
		}
		System.out.println(count);
	}

}
