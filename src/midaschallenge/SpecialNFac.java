package midaschallenge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class SpecialNFac {
	public static void main(String[] args) {
		new SpecialNFac().solve();
	}
	
	public void solve() {
		List<Number> numbers = getFactorialPrimeFactor(read());
		String result = join(numbers);
		print(result);
	}
	
	void print(String result) {
		System.out.println(result);
	}
	
	List<Number> getFactorialPrimeFactor(int n) {
		Map<Integer, Number> numbers = new HashMap<>();
		for(int i = n ; i > 1 ; i--) {
			toPrimeFactor(i, numbers);
		}
		
		List<Number> list = new ArrayList<>(numbers.values());
		
		Collections.sort(list);
		
		return list;
	}
	
	String join(List<Number> numbers) {
		if(numbers.size() == 0) return "";
		
		StringBuilder builder = new StringBuilder(numbers.get(0).toString());
		
		for(int i = 1; i < numbers.size(); i++) {
			builder.append('*').append(numbers.get(i));
		}
		
		
		return builder.toString();
	}
	
	Set<Integer> primeNumbers = new HashSet<>();
	
	boolean isPrimeNumber(int num) {
		if(num  < 2) return false;
		if(primeNumbers.contains(num)) return true;
		
		int half = num / 2;
		
		for(int i = 2; i <= half; i++) {
			if(num % i == 0) return false;
		}
		
		primeNumbers.add(num);
		
		return true;
	}
	
	void toPrimeFactor(int n, Map<Integer, Number> numbers) {
		int half = n / 2;
		int d = n, i = 2;
		
		while(d > 1 && i <= half) {
			if(d % i == 0 && isPrimeNumber(i)) {
				d /= i;
				
				Number number = getNumber(numbers, i);
				
				number.increaseExponential();
				
			} else {
				i++;
			}
		}
		
		if(d == n) {
			Number number = getNumber(numbers, d);
			number.increaseExponential();
		}
	}
	
	Number getNumber(Map<Integer, Number> numbers, int num) {
		Number number = numbers.get(num);
		
		if(null == number) {
			number = Number.create0(num);
			numbers.put(num, number);
		}
		
		return number;
	}
	
	int read() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		return n;
	}
	
	static class Number implements Comparable<Number>{
		private int exponential;
		final int number;
		
		private Number(int number, int exponential) {
			this.number = number;
			this.exponential = exponential;
		}
		
		public int increaseExponential() {
			return ++exponential;
		}
		
		public static Number create0(int number) {
			return new Number(number, 0);
		}
		
		public static Number create1(int number) {
			return new Number(number, 1);
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof Number) {
				return ((Number)o).number == number;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return number;
		}
		
		@Override
		public String toString() {
			return number + "^" + exponential;
		}

		@Override
		public int compareTo(Number o) {
			return number - o.number;
		}
	}
}
