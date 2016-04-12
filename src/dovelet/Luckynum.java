package dovelet;

import java.util.Scanner;

/*
 	http://59.23.113.171/30stair/luckynum/luckynum.php?pname=luckynum
 	
	4 나 7로 이루어져있는 수를 행운의 숫자라고 한다.
	다음은 처음 5개의 행운의 숫자다.
	
	4, 7, 44, 47, 74...
	정수 k가 주어졌을 때 k번 째 행운의 숫자를 구하는게 문제다.
	
	입력
	
	정수 k( 1<= k <= 10^9) 가 주어진다.
	출력
	
	k번 째 행운의 숫자를 출력한다.
	입출력 예
	
	입력
	
	5
	
	출력 
	
	74
	출처: 2010-2011 October COCI Q3
	번역+추천: likepad
 */
public class Luckynum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		
		System.out.println(solve(k));
	}
	
	static String solve(int k) {
		int d = unstrictLog2(k);
		
		int num = k - (int)Math.pow(2, d) + 1;
		
		String binary = Integer.toBinaryString(num);
		String result = padding(binary, d);
		
		return replace(result);
	}
	
	static String replace(String binary) {
		return binary.replace('0', '4').replace('1', '7');
	}
	
	static String padding(String binary, int digits) {
		int diff = digits - binary.length();
		StringBuilder builder = new StringBuilder();
		if(0 != diff) {
			for(int i = 0 ; i < diff ; i++) {
				builder.append('0');
			}
		}
		
		return builder.append(binary).toString();
	}
	
	static int unstrictLog2(double num) {
		int d = 1;
		
		while(num/2 > 2) {
			num /= 2;
			d++;
		}
		
		return d;
	}
}
