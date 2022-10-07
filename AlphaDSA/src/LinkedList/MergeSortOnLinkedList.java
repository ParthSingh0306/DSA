package LinkedList;

import LinkedList.Linkedlist.Node;

public class MergeSortOnLinkedList {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addFirst(7);
		ll.addLast(2);
		ll.addLast(1);
		ll.display();
		ll.head =  mergeSort(ll.head);
		ll.display();
	}
	
	public static Node mergeSort(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node mid = mid(head);
		
		Node Righthead = mid.next;
		mid.next = null;
		
		Node newLeft = mergeSort(head);
		Node newRight = mergeSort(Righthead);
		
		return merge(newLeft, newRight);
	}
	
	private static Node merge(Node head1, Node head2) {
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;
		
		while(head1 != null && head2 != null) {
			if(head1.val <= head2.val) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			}else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		
		while(head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		
		while(head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		
		return mergedLL.next;
	}

	public static Node mid(Node head) {
		Node slow = head;
		Node fast = head.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
