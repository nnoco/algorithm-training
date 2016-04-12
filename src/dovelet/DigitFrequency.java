package dovelet;

import java.util.Scanner;

/**
 * http://59.23.113.171/30stair/dfreq/dfreq.php?pname=dfreq
 * @author nnoco
 */
public class DigitFrequency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		char d=(char)(sc.nextInt() + '0');
		
		String s = "";
		for(int i=0 ; i <=	 n ; i++) {
			s+=i;
		}
		char[] cs = s.toCharArray();
		int i = 0;
		for(char c : cs) {
			if(c==d)i++;
		}
		
		System.out.println(i);
	}
}
