package midaschallenge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class SubsetMake {
	public static void main(String[] args) {
//		new SubsetMake().solve();
		
		test(5, new HashSet<Integer>(), 0);
	}
	
	static void test(int max, Set<Integer> set, int level) {
		
		if(level == max) return;
		
		
		for(int i = 0 ; i < max ; i++) {
			Set<Integer> subset = new HashSet<>(set);
			subset.add(i);
			System.out.println(subset);
			test(max, subset, level+1);
		}
		
	}
	
	public void solve() {
		Input input = readSet();
		
		toSubset(input);
	}
	
	void toSubset(Input input) {
		
	}
	
	Input readSet() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] set = new int[count];
		
		for(int i = 0; i < count; i++) {
			set[i] = sc.nextInt();
		}
		
		int d = sc.nextInt();
		
		sc.close();
		
		return new Input(set, d);
	}
	
	String indent(int count) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < count; i++) {
			builder.append(' ');
		}
		
		return builder.toString();
	}
	
	static class Subset {
		List<Number> numbers;
		int sum;
		
		public Subset() {
			numbers = new ArrayList<>();
		}
		
		public int count() {
			return numbers.size();
		}
		
		
	}
	
	static class Number {
		final int number;
		final int index;
		
		public Number(int number, int index) {
			this.number = number;
			this.index = index;
		}
	}
	static class Input {
		final int[] set;
		final int d;
		
		public Input(int[] set, int d) {
			this.set = set;
			this.d = d;
		}
		
		public int length() {
			return set.length;
		}
	}
}
