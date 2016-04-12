package dovelet;

/*
프로그램 명: koi_369
제한시간: 1 초
여러 사람이 둘러 앉아 즐기는 369 게임은 다음과 같은 규칙을 가지고 있다.

규칙: 양의 정수 A 에서 시작하여 차례로 사람들이 돌아가면서 숫자를 하나씩 증가하면서 불러 나간다. 단, 부르는 숫자가 3의 배수이거나 그 숫자에 3, 6, 9중 하나라도 들어 있는 경우에 숫자는 부르지 않고 박수를 친다.

예를 들어, 369 게임을 17부터 시작하는 경우를 생각해보자. 박수를 X로 표현하면, 이 게임의 진행은 17-X-X-20-X-22-X-X-25?X?X-28-X-X …과 같을 것이다.

시작하는 양의 정수 A 와 끝나는 양의 정수 B가 주어졌을 때, 박수를 치는 총 횟수를 구하는 프로 그램을 작성하시오.

수행시간은 1초를 넘을 수 없다. 사용하는 메모리는 128MB를 넘을 수 없다.

입력

한 줄에 시작하는 양의 정수 A 와 끝나는 양의 정수 B 가 순서대로 주어진다. 두 수의 범위는 1 ≤A ≤B ≤ 10^100,000 이다. 단, 좁은 범위 1 ≤A ≤B ≤10^6인 경우의 입력에 대해서만 올바른 답을 출력해도 점수의 30%를 받을 수 있다.
출력

박수치는 총 횟수를 20,150,523으로 나눈 나머지를 출력한다.
입출력 예

입력

1 12

출력

4

입력

29 39

출력

11

입력

12345 123456789

출력

17517670
출처:koi 중등 32 회 지역본선 3/4
 */
public class Koi369 {
	public static void main(String[] args) {
		int last1 = 0, last2 = 0, sum=0;
		for(int i = 0 ; i < 600 ; i++) {
			System.out.printf("%-15d", i);
			if(i % 3 == 0) {
				System.out.print(" O  " + (i-last1) + "\t");
				last1=i;
			} else {
				System.out.print("\t\t");
			}
			
			String num = Integer.toString(i);
			
			if(num.contains("3") || num.contains("6") || num.contains("9")) {
				sum ++;
				System.out.print("X  " + (i-last2) +"  " + sum);
				last2 = i;
			}
			
			System.out.println();
		}
	}
}
