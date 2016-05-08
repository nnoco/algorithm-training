package midaschallenge;
import java.util.Scanner;


public class TwoNumSum {
	public static void main(String[] args) {
		new TwoNumSum().solve();
	}
	
	void solve() {
		// read
		Scanner sc = new Scanner(System.in);
		
		int result = sc.nextInt() + sc.nextInt();
		
		sc.close();
		
		System.out.println(result);
	}
	
	int sum(int a, int b) {
		return a + b;
	}
}
