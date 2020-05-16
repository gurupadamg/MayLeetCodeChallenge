package com.mlcc.week3;

import com.mlcc.util.Node;
import com.mlcc.util.SingleLinkedList;

public class OddEvenLinkedList {

	/*
	 * 
	 * 
	 * Given a singly linked list, group all odd nodes together followed by the even
	 * nodes. Please note here we are talking about the node number and not the
	 * value in the nodes.
	 * 
	 * You should try to do it in place. The program should run in O(1) space
	 * complexity and O(nodes) time complexity.
	 * 
	 * Example 1:
	 * 
	 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL Example 2:
	 * 
	 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL Note:
	 * 
	 * The relative order inside both the even and odd groups should remain as it
	 * was in the input. The first node is considered odd, the second node even and
	 * so on ...
	 */
	
	  public static Node oddEvenList(Node head) {
	        if (head == null) return null;
	        Node odd = head, even = head.next, evenHead = even;
	        while (even != null && even.next != null) {
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        return head;
	    }
	  
	  public static void main(String[] args) {
		  /* Test Case 1 */
		  SingleLinkedList sll = new SingleLinkedList();
		  sll.add(1);
		  sll.add(2);
		  sll.add(3);
		  sll.add(4);
		  sll.add(5);
		  System.out.println("Test Case 1 : ");
		  sll.display(oddEvenList(sll.head)); //1->3->5->2->4
		
	}
}
