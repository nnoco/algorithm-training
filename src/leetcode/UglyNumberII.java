package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UglyNumberII {
	public static void main(String[] args) {
		List<UglyPrimeFactor> uglyNumbers = new ArrayList<UglyPrimeFactor>();
		
		for(int i = 0 ; i < 10; i++) {
			for(int j = 0 ; j < 10; j++) {
				for(int k = 0 ; k < 10; k++) {
					uglyNumbers.add(new UglyPrimeFactor(i, j, k));
				}
			}
		}
		
		Collections.sort(uglyNumbers);
		uglyNumbers.forEach(number -> {
			// System.out.println(number);
		});
		
		for(int i = 0, last = i ; i < uglyNumbers.size() ; i++) {
			UglyPrimeFactor number = uglyNumbers.get(i);
			if(number.p3 == 0 && number.p5 == 0) {
				System.out.println(i + ", " + number + " - " + (i-last));
				last = i;
			}
		}
		System.out.println("=============");
		for(int i = 0, last = i ; i < uglyNumbers.size() ; i++) {
			UglyPrimeFactor number = uglyNumbers.get(i);
			if(number.p2 == 0 && number.p5 == 0) {
				System.out.println(i + ", " + number + " - " + (i-last));
				last = i;
			}
		}
		System.out.println("=============");
		for(int i = 0, last = i ; i < uglyNumbers.size() ; i++) {
			UglyPrimeFactor number = uglyNumbers.get(i);
			if(number.p2 == 0 && number.p3 == 0) {
				System.out.println(i + ", " + number + " - " + (i-last));
				last = i;
			}
		}
	}
	
}

class UglyPrimeFactor implements Comparable<UglyPrimeFactor> {
	final long p2;
	final long p3;
	final long p5;
	final long product;
	
	public UglyPrimeFactor(int p2, int p3, int p5) {
		this.p2 = p2;
		this.p3 = p3;
		this.p5 = p5;
		
		this.product = (long)(Math.pow(2, p2) * Math.pow(3, p3) * Math.pow(5, p5));
	}

	@Override
	public int compareTo(UglyPrimeFactor o) {
		return product >= o.product ? 1 : -1;
	}
	
	@Override
	public String toString() {
		return String.format("%5d %5d %5d = %d", p5, p3, p2, product);
	}
	
}
