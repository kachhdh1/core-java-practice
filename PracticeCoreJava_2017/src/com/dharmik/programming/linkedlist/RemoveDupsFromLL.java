package com.dharmik.programming.linkedlist;

import java.util.HashSet;

import com.dharmik.programming.linkedlist.CustomLinkedListDriver.TrainCar;

public class RemoveDupsFromLL {

	public static void main(String[] args) {
		CustomLinkedListDriver trainApp = new CustomLinkedListDriver();
		// build the train
		trainApp.buildTrainWithDuplicateData();

		// /provide train to function to remove duplicates
		removeDupsWithBuffer(trainApp.train);
		removeDupsWithoutBuffer(trainApp.train);
	}

	/**
	 * this method removes duplicate with an additional buffer which is used to
	 * hold the list element in set Time complexity o(N) and space complexity
	 * o(N)
	 * 
	 * @param train
	 */
	private static void removeDupsWithBuffer(BasicLinkedList<TrainCar> train) {
		HashSet<TrainCar> set = new HashSet<>();// additional buffer
		BasicLinkedList<TrainCar>.Node current = train.getFirst();
		BasicLinkedList<TrainCar>.Node previous = null;
		while (current != null) {
			if (set.contains(current.getNodeItem())) {
				previous.setNextNode(current.getNextNode()); //---IMP 
			} else {
				set.add(current.getNodeItem());
				previous = current; //adjust the previous
			}
			current = current.getNextNode();
		}
		System.out.println(train);
	}

	/**
	 * this function does not take additional buffer.
	 * Time - O(N2) and space O(1)
	 * @param train
	 */
	private static void removeDupsWithoutBuffer(BasicLinkedList<TrainCar> train) {
		BasicLinkedList<TrainCar>.Node head = train.getFirst();

		//we need to pointers, one outer loop and one inner loop
		BasicLinkedList<TrainCar>.Node current = head;
		BasicLinkedList<TrainCar>.Node runner = head;
		
		// start looping over elements starting from the head
		while (current != null) {
			
			while(runner.getNextNode()!=null){
				if(current.getNodeItem() == runner.getNextNode().getNodeItem()){
					runner.setNextNode(runner.getNextNode().getNextNode());
				}
				runner=runner.getNextNode();
			}
			
			current = current.getNextNode();
		}

		System.out.println(train);
	}
}
