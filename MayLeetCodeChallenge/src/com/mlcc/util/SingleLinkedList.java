package com.mlcc.util;

public class SingleLinkedList {

	public Node head;

	public void insertAtBegin(int val) {
		Node node = new Node(val);
		Node temp = head;

		if (temp == null) {
			head = node;
			return;
		}else {
			node.next = temp;
			head = node;
		}
		
		
	}
	
	public void add(int val) {
		insertAtEnd(val);
	}

	public void insertAtEnd(int val) {
		Node temp = head;
		Node node = new Node(val);

		if (temp == null) {
			head = node;
			return;
		}

		while (temp != null && temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	private void display() {
		display(this.head);
	}
	
	public  void display(Node head) {
		Node temp = head;
		if(temp == null) {
			return;
		}
		while (temp.next != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		sll.insertAtEnd(10);
		sll.insertAtEnd(20);
		sll.insertAtEnd(30);
		sll.display();
		sll.insertAtEnd(40);
		sll.insertAtBegin(50);
		sll.display();
	}

	

}
