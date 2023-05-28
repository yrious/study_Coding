package practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 소금 폭탄
 * 물컵에 시간이 되면 로봇팔이 소금을 잔뜩 집어 넣는다. 시간 구하기
 * 입력 : 'hh:mm:ss' 첫째줄 현재 시간 / 둘째줄 소금 투하 시간
 * 		(0<=h<=23, 0<=m<=59, 0<=s<=59)
 * 출력 : 'hh:mm:ss' 로봇팔이 소금을 투하할때까지 필요한 시간 (1초이상, 24시간이하)
 */
public class Baekjoon13223 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int time1 = 3600 * Integer.parseInt(str1.split(":")[0])
		+ 60 * Integer.parseInt(str1.split(":")[1])
		+ Integer.parseInt(str1.split(":")[2]);
		
		
		int time2 = 3600 * Integer.parseInt(str2.split(":")[0])
		+ 60 * Integer.parseInt(str2.split(":")[1])
		+ Integer.parseInt(str2.split(":")[2]);
		
		int result = time2 - time1;
		// 00:00:00 가 안나오게 =를 꼭 넣어줘야한다!
		if(result <= 0) {
			result += 24 * 3600;
		}
		
		int resultHour = result / 3600;
		int resultMinute = (result % 3600) / 60;
		int resultSecond = result % 60;
		
		System.out.printf("%02d:%02d:%02d",resultHour,resultMinute,resultSecond);
	}

}
