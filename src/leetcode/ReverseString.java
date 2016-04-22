package leetcode;

/**
344. Reverse String - https://leetcode.com/problems/reverse-string/

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

 * @author nnoco
 *
 */
public class ReverseString {
	public static void main(String[] args) {
		System.out.println(new ReverseString().reverseString("hello"));
	}
	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
    }
}
