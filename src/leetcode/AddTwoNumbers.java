package leetcode;

/**
2. Add Two Numbers : https://leetcode.com/problems/add-two-numbers/
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

코드가 너저분...

 * @author nnoco
 *
 */
public class AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		void print() {
			ListNode temp = this;
			while (temp != null) {
				System.out.print(temp.val + " -> ");
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		ListNode l1, l2;
		
		l1 = new ListNode(3);
		l1.next = new ListNode(7);
//		l1.next.next = new ListNode(9);
//		l1.next.next.next = new ListNode(3);
		
		l2 = new ListNode(9);
		l2.next = new ListNode(2);
//		l2.next.next = new ListNode(3);
//		l2.next.next.next = new ListNode(5);
//		l2.next.next.next.next = new ListNode(8);
		
		
		new AddTwoNumbers().addTwoNumbers(l1, l2).print();;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode last = result;
		ListNode node1 = l1, node2 = l2, node3 = result;

		int sum = 0, carry = 0;
		do {
			System.out.print("-> " + node1.val + " + " + node2.val + " + " + node3.val + " = ");
			sum = node1.val + node2.val + node3.val;

			carry = sum / 10;
			sum = sum % 10;
			
			System.out.println(carry*10 + ", " + sum);

			node3.val = sum;
			node3.next = new ListNode(carry);
			last = node3;
			node3 = node3.next;
			
			node1 = node1.next;
			node2 = node2.next;

		} while (node1 != null && node2 != null);

		if (node1 == null && node2 == null) {
			if (last.next.val == 0) {
				last.next = null;
			}
		} else if (node1 == null) {
			handleRemains(last, node2);
		} else if (node2 == null) {
			handleRemains(last, node1);
		}

		return result;
	}

	public void handleRemains(ListNode n1, ListNode n2) {
		
		System.out.println("hello?");
		int sum = 0, carry = 0;
		
		n1 = n1.next;
		ListNode last = n1;
		while (n2 != null) {
			sum = n1.val + n2.val;
			
			System.out.println("hello - " + n1.val + ", " + n2.val);
			carry = sum / 10;
			sum = sum % 10;

			n1.val = sum;
			last = n1;
			n1.next = new ListNode(carry);
			n1 = n1.next;
			
			n2 = n2.next;
		}

		if (last.next.val == 0) {
			last.next = null;
		}
	}
	
	/* 모범 답안 'ㅅ'
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
    }
	 */
}
