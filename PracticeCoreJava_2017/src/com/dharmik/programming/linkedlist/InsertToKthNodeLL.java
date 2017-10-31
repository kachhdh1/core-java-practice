package com.dharmik.programming.linkedlist;

public class InsertToKthNodeLL {

	public static void main(String[] args) {
		SimpleNode head = new SimpleNode(1);
		head.appendToTail(2);
		head.appendToTail(4);
		InsertNth(head, 3, 2);
	}
	
	static void InsertNth(SimpleNode head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method. 
			SimpleNode newNode = new SimpleNode();
		    newNode.data = data;
		    
		   if(head == null){
			   newNode.next = null;
			   head = newNode;
		   }
		   else{
			   if(position ==0){
				   newNode.next = head;
				   head = newNode;
			   }else{
				   
				   SimpleNode current = head;
				   SimpleNode previous = head;
				   while(position>0 && current!=null){
					   previous = current;
					   current = current.next;
					   position--;
				   }
				   //these two lines can be source of infinite loop
				   //you can check if current!=previous. if we have not checked
				   // if(position==0), current and previous would have both
				   //pointed to head and next two lines will result in infinite loop - IMP
				   newNode.next = current;
				   previous.next = newNode;
			   }
			   
		   }
		    
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
