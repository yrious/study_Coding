package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 베스트셀러
 * 입력 1: 오늘 팔린 책의 개수 N (N <= 1000)
 * 입력 N: 책의 제목 (book.length<=50, 소문자)
 * 출력: 가장 많이 팔린 책(여러개일 때 사전 순 가장 앞)
 * 
 */
public class Baekjoon1302 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		Map<String, Integer> maps = new HashMap<>();
		
		while(N-- > 0) {
			String title = br.readLine();
			maps.put(title,  maps.getOrDefault(title, 0) + 1);
		}
		
		String maxTitle = null;
		int maxCount = 0;
		
		for (Map.Entry<String, Integer> map : maps.entrySet()) {
			String title = map.getKey();
			int count = map.getValue();
			
			if (count > maxCount || (count == maxCount && title.compareTo(maxTitle) < 0 )) {
				maxTitle = title;
				maxCount = count;
			}
		}
		
		System.out.println(maxTitle);
	
		
	}

}
