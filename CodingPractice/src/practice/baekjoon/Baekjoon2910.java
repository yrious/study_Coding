package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 * 빈도정렬
 * stable
 * 입력 1: 메세지의 길이 N, C (1<=N<=1,000, 1<=C<=1,000,000,000)
 * 입력 2: 수열
 * 출력: 빈도 정렬 후 출력
 */
public class Baekjoon2910 {
	/* 방법 1) 객체 이용
	
	// 입력 수열
	static class InputC{
		int num;
		int index;
		public InputC(int num, int index) {
			this.num = num;
			this.index = index;
		}
	}
	// 빈도 수
	static class Frequency{
		int num;
		int count;
		int firstIndex;
		public Frequency(int num, int count, int firstIndex) {
			this.num = num;
			this.count = count;
			this.firstIndex = firstIndex;
		}
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
	
		InputC [] input = new InputC[N];
		for (int i = 0; i < N; i++) {
			input[i] = new InputC(Integer.parseInt(st.nextToken()), i);
		}

		// 정렬1) 빈도수를 세기위해 오름차순으로 정렬
		Arrays.sort(input, new Comparator<InputC>() {
			@Override
			public int compare(InputC o1, InputC o2) {
				return o1.num - o2.num;
			}
		});
		
		// 카운팅
		Frequency[] frequencies = new Frequency[N];
		int frequencyIndex = 0;
		frequencies[frequencyIndex] = new Frequency(input[0].num, 1, input[0].index);
		for (int i = 1; i < N; i++) {
			if(input[i].num != input[i-1].num) {
				frequencies[++frequencyIndex] = new Frequency(input[i].num, 0, input[i].index);
			}
			frequencies[frequencyIndex].count++;
		}
		
		// 정렬2) 빈도수 만큼 정렬
		Arrays.sort(frequencies, 0, frequencyIndex + 1, new Comparator<Frequency>() {
			@Override
			public int compare(Frequency o1, Frequency o2) {
				if(o1.count == o2.count)return o1.firstIndex-o2.firstIndex;
				return o2.count-o1.count;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= frequencyIndex; i++) {
			while(frequencies[i].count-- > 0) {
				sb.append(frequencies[i].num).append(" ");
			}
		}
		
		System.out.println(sb);
	}
	*/
	
	/* 방법 2) Map (HashArrayList 이용) */
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		// key : num, value : count
		Map<Integer, Integer> maps = new LinkedHashMap<>();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			maps.put(input, maps.getOrDefault(input, 0) + 1);
		}
		
		Integer [] arr = maps.keySet().toArray(new Integer[maps.size()]);
		
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// key값을 이용해서 map value값 비교(내림차순)
				return maps.get(o2) - maps.get(o1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < maps.size(); i++) {
			int count = maps.get(arr[i]);
			while(count-- > 0) {
				sb.append(arr[i]).append(" ");
			}
		}
		System.out.println(sb);
	}

}
