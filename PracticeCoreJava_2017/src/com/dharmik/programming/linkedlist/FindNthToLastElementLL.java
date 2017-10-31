package com.dharmik.programming.linkedlist;

import com.dharmik.programming.linkedlist.CustomLinkedListDriver.TrainCar;

public class FindNthToLastElementLL {

	public static void main(String[] args) {
		CustomLinkedListDriver trainApp = new CustomLinkedListDriver();
		// build the train
		trainApp.buildInitialTrain();

		nthToLast(trainApp.getTrain().getFirst(),2);
	}
	
	/**
	 * 1. Create two pointers, p1 and p2, that point to the beginning of the node.
	 * 2. Increment p2 by n-1 positions, to make it point to the nth node from the 
	 * 	  beginning (to make the distance of n between p1 and p2).
	 * 3. Check for p2->next == null if yes return value of p1, otherwise increment p1 and p2. 
	 * 	  If next of p2 is null it means p1 points to the nth node from the last as the distance between the two is n.
	 * @param head
	 * @param n
	 */
	public static void nthToLast(BasicLinkedList<TrainCar>.Node head, int n){
		
		BasicLinkedList<TrainCar>.Node current = head; 
		BasicLinkedList<TrainCar>.Node runner = head; 
		
		//forward the runner node by n nodes forward 
		while(runner!=null && n!=0){
			runner = runner.getNextNode();//move one position forward
			n--;
		}
		
		//now move both the pointers with same speed
		while(runner!=null){
			//make current one forward
			current = current.getNextNode();
			
			//make runner one node forward, but it is already nth node ahead
			//of the current node so it will end of the list before current
			runner = runner.getNextNode();
		}
		
		System.out.println(current.getNodeItem());
	}
	
	//TODO do this logic with recursion

}
