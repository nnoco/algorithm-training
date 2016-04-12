package dovelet;

import java.util.Scanner;

public class BoiSquint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double result = Math.pow(sc.nextDouble(), 0.5);
		System.out.println((long)Math.ceil(result));
		
		sc.close();
	}
}
