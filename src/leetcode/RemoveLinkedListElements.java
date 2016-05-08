package leetcode;

/**
	[E] 203. Remove Linked List Elements - https://leetcode.com/problems/remove-linked-list-elements/
	
	 Remove all elements from a linked list of integers that have value val.

	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author nnoco
 *
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if(null == head) return null;
		
		ListNode before = null;
		ListNode current = head;
		ListNode next = current.next;
		
		while(current != null) {
			if(current.val == val) {
				if(null == before && null == next) { 	// 노드가 1개인 경우
					return null;
				} else if (null == before) {			// 가장 앞 노드
					current.val = next.val;
					next = next.next;
					current.next = next;
				} else if(null != before && null != next) { // 중간 노드
					before.next = next;
					current = next;
					next = next.next;
				} else { // 마지막 노드
					before.next = null;
					break;
				} 
			} else {
				before = current;
				current = next;
				next = null != next ? next.next : null;
			}
		}
		
		return head;
		
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(6);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(2);
		ListNode n7 = new ListNode(1);
		ListNode n8 = new ListNode(6);
		
		n8.next = n7;
		n7.next = n6;
		n6.next = n5;
		n5.next = n4;
		n4.next = n3;
		n3.next = n2;
		n2.next = n1;
		
		ListNode n01 = new ListNode(1);
		ListNode n02 = new ListNode(1);
		n01.next = n02;
		
		
		ListNode result = new RemoveLinkedListElements().removeElements(n01, 1);
		
		while(null != result) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}
}
