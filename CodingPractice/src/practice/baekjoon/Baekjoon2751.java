package practice.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 수 정렬하기2
 */
public class Baekjoon2751{

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer [] sort = new Integer [N];
		
		
		for (int i = 0; i < N; i++) {
			sort[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(sort);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(sort[i]+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
