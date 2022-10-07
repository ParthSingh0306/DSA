package LinkedList;

import LinkedList.Linkedlist.Node;

public class ZigZagLinkedList {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.addLast(6);
		ll.display();
		zigzag(ll.head);
		ll.display();
	}
	
	public static void zigzag(Node head) {
		Node mid = mid(head);
		Node leftH = head;
		Node rightH = reverse(mid);
		Node nextL, nextR;
		
		while(leftH != null && rightH != null) {
			nextL = leftH.next;
			leftH.next = rightH;
			nextR = rightH.next;
			rightH.next = nextL;
			
			leftH = nextL;
			rightH = nextR;
		}
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
	
	public static Node reverse(Node head) {
		Node curr = head;
		Node prev = null;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		return head;
	}

}
