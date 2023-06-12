package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 나이순 정렬
 * 1. 나이 오름차순 정렬
 * 2. 나이가 같으면 먼저 가입한 사람이 앞에 온다.
 * 입력 1: 회원 수 N (1 <= N <= 100,000)
 * 입력 N: 나이 이름 (1 <= 나이 <= 200)(이름.length <= 100, 알파벳 대소문자)
 */
public class Baekjoon10814 {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Member[] member = new Member[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			member[i] = new Member(Integer.parseInt(st.nextToken()),st.nextToken());
		}
		
		Arrays.sort(member);
		
		for (Member mb : member) {
			sb.append(mb.age).append(" ").append(mb.name).append("\n");
		}
		System.out.println(sb);
	}
}

class Member implements Comparable<Member> {
	String name;
	int age;
	
	Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int compareTo(Member o) {
		return this.age - o.age;
	}
	
}