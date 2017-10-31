package com.dharmik.programming.linkedlist;

public class ReverseLL {

	public static void main(String[] args) {
		SimpleNode head = new SimpleNode(1);
		head.appendToTail(2);
		head.appendToTail(4);
		ReversePrint(head);
	}
	
	static void ReversePrint(SimpleNode head) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method. 
			SimpleNode current = head;
			SimpleNode previous = null;
			SimpleNode next = null;
			while(current!=null){
				next = current.next;
				current.next = previous;
				previous = current;
				current = next; //increment 
			}
			head = previous;
			printNodes(head);
			
		}

	private static void printNodes(SimpleNode head) {
		while(head!=null){
			System.out.print(head.data+"-->");
			head = head.next;
		}
		System.out.print("null");
	}

}
