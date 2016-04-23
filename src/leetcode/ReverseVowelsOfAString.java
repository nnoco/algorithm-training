package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
345. Reverse vowles of a string - https://leetcode.com/problems/reverse-vowels-of-a-string/

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

W와 Y는 모음이 아닌 건가..?

 * @author nnoco
 *
 */
public class ReverseVowelsOfAString {
	public static void main(String[] args) {
		System.out.println(new ReverseVowelsOfAString().reverseVowels(" "));
	}
	
	public String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		
		char[] characters = s.toCharArray();
		
		int forward=0, backward = characters.length - 1;
		
		while(forward <= backward) {
			if(vowels.contains(characters[forward]) && vowels.contains(characters[backward])) {
				swap(characters, forward, backward);
				
				forward++;
				backward--;
				
				continue;
			}
			
			forward += vowels.contains(characters[forward]) ? 0 : 1;
			backward += vowels.contains(characters[backward]) ? 0 : -1;
		}
		
		return new String(characters);
        
    }
	
	void swap(char[] characters, int i, int j) {
		char temp = characters[i];
		characters[i] = characters[j];
		characters[j] = temp;
	}
}
