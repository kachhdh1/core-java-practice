package com.dharmik.programming.linkedlist;

//custom linked list implementation class
class BasicLinkedList<T> {
	private Node first;
	private Node last;
	private int nodeCount;

	BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}

	/**
	 * add method with the use of 'last' pointer. performance O(1)
	 * 
	 * @param item
	 */
	public void add(T item) {
		// this condition means we are adding something for the first time.
		if (first == null) {
			first = new Node(item);
			last = first;
		}
		// otherwise, we want to grab the last node and update it's value
		else {
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}

	/**
	 * this method adds the node in the last of the linked list but without the
	 * use of last pointer but with traversing and going to the last node
	 * performance O(n)
	 * 
	 * @param item
	 */
	public void addTraverse(T item) {
		// this condition means we are adding something for the first time.
		if (first == null) {
			first = new Node(item);
		}
		// otherwise, we want to grab the last node and update it's value
		else {
			Node newLastNode = new Node(item);
			Node current = first;

			// Let's check for NPE before iterate over current
			if (current != null) {

				// starting at the head node, crawl to the end of the list and
				// then add element after last node
				while (current.getNextNode() != null) {
					current = current.getNextNode();
				} // at this point, current points to the null which is last
					// the last node's "next" reference set to our new node
				current.setNextNode(newLastNode);
			}

			// increment the number of elements variable
			nodeCount++;
		}
	}

	/**
	 * this method inserts an item at specified position
	 * 
	 * @param item
	 * @param position
	 */
	public void insert(T item, int position) {
		if (size() < position) {
			throw new IllegalStateException("The LinkedList is smaller than the position to insert at: " + position);
		}

		Node currentNode = first; // start with the first node

		//start at 1 because we are already on the first node
		for (int i = 1; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();// traverse to position
		}

		// create the new node and reconnects with new node
		Node newNode = new Node(item);
		newNode.setNextNode(currentNode.getNextNode());
		currentNode.setNextNode(newNode);
		nodeCount++;
	}
	
	/**
	 * function removes the node from the first position. 
	 * performance O(1)
	 * @return
	 */
	public T remove(){
		if(first == null){
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		
		T nodeItem = first.getNodeItem();
		//adjust the new first node
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;
	}
	
	public T removeAt(int position){
		if(first == null){
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		
		Node currentNode = first;
		Node previousNode = first;
		//start at 1 because we are already on the first node
		for (int i = 1; i < position && currentNode != null; i++) {
			previousNode = currentNode; //set previous node one node behind current
			currentNode = currentNode.getNextNode();// traverse to position
		}
		//extract the item from current node position
		T nodeItem = currentNode.getNodeItem();
		//now update the pointers and throw away the old first
		previousNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return nodeItem;
	}
	
	public T get(int position) {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to get");
		}

		Node currentNode = first;
		for(int i = 1; i < size() && currentNode != null; i++) {
			if(i == position) {
				return currentNode.getNodeItem();
			}

			currentNode = currentNode.getNextNode();
		}
		
		//if we didn't find it then return null
		return null;
	}
	
	public int find(T item) {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}

		Node currentNode = first;
		for(int i = 1; i < size() && currentNode != null; i++) {
			if(currentNode.getNodeItem().equals(item)) {
				return i;
			}

			currentNode = currentNode.getNextNode();
		}
		
		//if we didn't find it, then return -1
		return -1;
	}

	// useful for pretty print
	public String toString() {
		StringBuffer contents = new StringBuffer();
		Node curNode = first;

		while (curNode != null) {
			contents.append(curNode.getNodeItem());
			curNode = curNode.getNextNode();

			if (curNode != null) {
				contents.append(", ");
			}
		}
		return contents.toString();
	}

	public int size() {
		return nodeCount;
	}

	// inner class to hold the node data
	class Node {
		private T nodeItem;
		private Node nextNode;

		public Node(T item) {
			this.nodeItem = item;
			this.nextNode = null;
		}

		public T getNodeItem() {
			return nodeItem;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

	} // inner class node ends

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

}// linked list implementation ends

