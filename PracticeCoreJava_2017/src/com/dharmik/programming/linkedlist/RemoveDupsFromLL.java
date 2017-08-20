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
		removeDupsWithoutBuffer(null);
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

	private static void removeDupsWithoutBuffer(BasicLinkedList<TrainCar> train) {
		BasicLinkedList<TrainCar>.Node head = train.getFirst();

		// start looping over elements starting from the head
		while (head != null) {
			//TODO
		}

		System.out.println(train);
	}
}
