package com.dharmik.programming.linkedlist;

import java.util.HashSet;

import com.dharmik.programming.linkedlist.CustomLinkedListDriver.TrainCar;

public class RemoveDupsFromLL {

	public static void main(String[] args) {
		CustomLinkedListDriver trainApp = new CustomLinkedListDriver();
		//build the train
		trainApp.buildTrainWithDuplicateData();
		
		///provide train to function to remove duplicates
		removeDupsWithBuffer(trainApp.train);
		removeDupsWithoutBuffer();
	}

	private static void removeDupsWithBuffer(BasicLinkedList<TrainCar> train) {
		HashSet<TrainCar> set = new HashSet<>();//buffer
		BasicLinkedList<TrainCar>.Node current = train.getFirst();
		BasicLinkedList<TrainCar>.Node previous = null;
		while(current!=null){
			if(set.contains(current.getNodeItem())){
				previous.setNextNode(current.getNextNode());
			}
			else{
				set.add(current.getNodeItem());
				previous = current;
			}
			current = current.getNextNode();
		}
		System.out.println(train);
	}

	private static void removeDupsWithoutBuffer() {

	}
}
