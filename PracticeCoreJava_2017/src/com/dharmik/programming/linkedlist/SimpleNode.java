package com.dharmik.programming.linkedlist;

class SimpleNode {
	SimpleNode next = null;
	int data;

	SimpleNode(){}
	public SimpleNode(int d) {
		data = d;
	}

	void appendToTail(int d) {
		SimpleNode end = new SimpleNode(d);
		SimpleNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	// this function is used to add same Node
	// to two different linked list
	SimpleNode append(SimpleNode newNode) {
		SimpleNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = newNode;
		return n;
	}

}
