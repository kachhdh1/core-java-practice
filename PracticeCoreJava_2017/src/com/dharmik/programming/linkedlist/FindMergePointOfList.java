package com.dharmik.programming.linkedlist;

public class FindMergePointOfList {

	public static void main(String[] args) {
		
		//data setup
		SimpleNode head1 = new SimpleNode(1);
		SimpleNode m = new SimpleNode(3);
		head1.append(new SimpleNode(2)).append(m).append(new SimpleNode(4));
		// head1 = 1->2->3->4

		SimpleNode head2 = new SimpleNode(5);
		head2.append(m).append(new SimpleNode(6));
		// head2 = 5->3->6

		// intersection will be 3 which is node m
		System.out.println(FindMergeNodeBook(head1, head2));
	}

	/**
	 * Make an interating pointer like this: it goes forward every time till the
	 * end, and then jumps to the beginning of the opposite list, and so on.
	 * Create two of these, pointing to two heads. Advance each of the pointers
	 * by 1 every time, until they meet. This will happen after either one or
	 * two passes
	 * @param headA
	 * @param headB
	 * @return
	 */
	static int FindMergeNode(SimpleNode headA, SimpleNode headB) {
		SimpleNode runner1 = headA;
		SimpleNode runner2 = headB;

		while (runner1 != runner2) {
			// if you reach the end of the list, start at the
			// beginning of the next head ---IMP

			// runner1
			if (runner1 == null) {
				runner1 = headB;
			} else {
				runner1 = runner1.next;
			}

			// runner2
			if (runner2 == null) {
				runner2 = headA;
			} else {
				runner2 = runner2.next;
			}
		}
		return runner2.data;
	}
	
	/**
	 *  1. Run through each linked list to get the lengths and the tails.
		2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
		3. Set two pointers to the start of each linked list.
		4. On the longer linked list, advance its pointer by the difference in lengths.
		5. Now, traverse on each linked list until the pointers are the same.
	 * @param headA
	 * @param headB
	 * @return
	 */
	static int FindMergeNodeBook(SimpleNode headA, SimpleNode headB) {
		if(headA ==null || headB ==null){
			return 0;
		}
		
		Result result1 = new FindMergePointOfList().getTailAndSize(headA);
		Result result2 = new FindMergePointOfList().getTailAndSize(headB);
		
		//make the pointer to the start of the list
		SimpleNode shorter = result1.size < result2.size ? headA : headB;
		SimpleNode longer = result1.size < result2.size ? headB : headA;
		
		/* Advance the pointer for the longer linked list by difference in lengths. */
		longer = getKthNode(longer, Math.abs(result1.size -result2.size));
		
		//now advance both the pointer at same speed until they are equal and 
		//it is the merge point
		while(shorter!=longer){
			shorter = shorter.next;
			longer = longer.next;
		}
		
		//we can return data from any of the list
		return shorter.data;
	}
	
	/*
	 * this class holds tail and size of a linked list
	 */
	class Result{
		SimpleNode node;
		int size;
		
		Result(SimpleNode node,int size){
			this.node = node;
			this.size = size;
		}
		
	}
	
    Result getTailAndSize(SimpleNode list){
		if(list ==null){
			return null;
		}
		int size = 0;
		SimpleNode current = list;
		while(current!=null){
			current = current.next;
			size++;
		}
		return new Result(current, size);
	}
	
	static SimpleNode getKthNode(SimpleNode head,int k){
		
		SimpleNode current = head;
		
		while(k>0 && current!=null){
			current = current.next;
			k--;
		}
		
		return current;
	}

}
