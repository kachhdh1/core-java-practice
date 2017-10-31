package com.dharmik.programming.linkedlist;

import com.dharmik.programming.linkedlist.CustomLinkedListDriver.TrainCar;

/**
 * this class implements logic for deleting node in the middle 
 * providing only access to that node
 * 	Input: the node 'c' from the linked list a->b->c->d->e
	Result: nothing is returned, but the new linked list looks like a->b->d->e
 * @author Dharmik
 *
 */
public class DeleteNodeInMiddle {

	public static void main(String[] args) {
		// Not necessary the node can be in middle.
		//but the only access is provided the node 
		//WHICH NEEDS TO BE REMOVED ONLY
		
		CustomLinkedListDriver trainApp = new CustomLinkedListDriver();
		// build the train
		trainApp.buildInitialTrain();
		
		BasicLinkedList<TrainCar> train = trainApp.getTrain();
		
		//creating dummy data to get the node which we want to remove
		//traverse to the node which we need to remove, lets say fifth(5) node
		BasicLinkedList<TrainCar>.Node head = train.getFirst(); //get the head
		BasicLinkedList<TrainCar>.Node runner = head;
		///traverse to desired position
		int position = 0; //we want to get access to 5th node
		while(runner.getNextNode() !=null && position <4){
			runner = runner.getNextNode();
			++position;
		}
		System.out.println("Node to be removed is --> "+runner.getNodeItem());
		System.out.println("Is node deleted? "+deleteNode(runner));
		System.out.println("Äfter deletetion --> "+train);

	}

	private static boolean deleteNode(BasicLinkedList<TrainCar>.Node runner) {
		if(runner==null || runner.getNextNode()==null){
			//This problem can not be solved if the node to be deleted is 
			//the last node in the linked list ------ IMP
			return false; //failure
		}
		BasicLinkedList<TrainCar>.Node nextNode = runner.getNextNode();
		//copy the content of the next node to the runner node 
		//and this will in turn delete the runner node.
		runner.setNextNode(nextNode.getNextNode());
		runner.setNodeItem(nextNode.getNodeItem());
		return true;
	}

}
