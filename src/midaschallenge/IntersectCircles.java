package midaschallenge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class IntersectCircles {
	public static void main(String[] args) {
		new IntersectCircles().solve();
	}
	
	public void solve() {
		List<Circle> circles = readCircles();
		
		Collections.sort(circles);
		
		List<Pair> result = compare(circles);
		
		print(result);
	}
	
	List<Circle> readCircles() {
		List<Circle> circles = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int id;
		double x, y, r;
		
		for(int i = 0; i < count; i++) {
			id = sc.nextInt();
			x = sc.nextDouble();
			y = sc.nextDouble();
			r = sc.nextDouble();
			
			circles.add(new Circle(id, x, y, r));
		}
		
		sc.close();
		
		return circles;
	}
	
	List<Pair> compare(List<Circle> circles) {
		List<Pair> pairs = new ArrayList<>();
		double distance;
		Circle a, b;
		
		for(int i = 0; i < circles.size(); i++) {
			a = circles.get(i);
			for(int j = i + 1; j < circles.size(); j++) {
				b = circles.get(j);
				
				distance = Math.pow(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2), 0.5);
				if(a.r + b.r > distance) {
					pairs.add(new Pair(a, b));
				}
			}
		}
		
		return pairs;
	}
	
	void print(List<Pair> pairs) {
		for(Pair pair : pairs) {
			System.out.println(pair);
		}
	}
	
	static class Pair {
		final Circle a, b;
		
		public Pair(Circle a, Circle b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public String toString() {
			return a.id + " " + b.id;
		}
	}
	
	static class Circle implements Comparable<Circle>{
		final int id;
		final double x, y, r;
		
		public Circle(int id, double x, double y, double r) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.r = r;
		}

		@Override
		public int compareTo(Circle o) {
			return id - o.id;
		}
	}
	
}
