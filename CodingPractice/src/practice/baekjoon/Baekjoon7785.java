package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


/*
 * 회사에 있는 사람
 * 
 * 입력 1: 출입 기록 수 n (2 <= n <= 10^6)
 * 입력 n: 출입 기록 '이름' '출퇴근(enter/leave)'
 * (이름 : 동명이인없음, 대소문자구분, 5글자 이하) 
 * 출력 : 현재 회사에 있는 사람 내림차순
 */
public class Baekjoon7785 {

	// 풀이1. Set
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			String status = st.nextToken();
			if(status.equals("enter"))// 집합에 추가
				set.add(name);
			else // 제거
				set.remove(name);
		}
		
		String[] ordered = set.toArray(new String[set.size()]);
		for(int i = ordered.length - 1; i >= 0; i--) {
			sb.append(ordered[i]).append("\n");
		}
		System.out.println(sb);
	}
}
	// 풀이2. 객체
	/* 
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Member2 [] members = new Member2[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			members[i] = new Member2(st.nextToken(), st.nextToken());
		}
		
		Arrays.sort(members);
		
		for (int i = 0; i < n; i++) {
			if(i!=n-1 && members[i].name.equals(members[i+1].name)) {
				i++;
				continue;
			}
			sb.append(members[i].name).append("\n");
		}
		System.out.println(sb);
	}

}
class Member2 implements Comparable<Member2>{
	String name;
	String status;
	
	public Member2(String name, String status) {
		this.name = name;
		this.status = status;
	}
	
	@Override
	public int compareTo(Member2 o) {
		return o.name.compareTo(this.name);
	}
	
}*/
