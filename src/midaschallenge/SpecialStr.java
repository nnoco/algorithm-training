package midaschallenge;
import java.util.Scanner;
import java.util.Stack;


public class SpecialStr {
	public static void main(String[] args) {
		new SpecialStr().solve();
	}
	
	public void solve() {
		String str = readString();
		
		boolean result = isSpecial(str);
		
		System.out.println(result ? "True" : "False");
	}
	
	String readString() {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		
		return str;
	}
	
	boolean isSpecial(String str) {
		char[] charArray = str.toCharArray();
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : charArray) {
			char top = peek(stack);
			
			if(c == top) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		
		return stack.size() == 0;
	}
	
	char peek(Stack<Character> stack) {
		// peek 시 비어있는 경우 EmptyStack 예외 발생하므로 반환값으로 null 문자 처리
		return stack.isEmpty() ? '\0' : stack.peek();
	}
}
