package LinkedList;

import LinkedList.Linkedlist.Node;

public class RemoveCycle {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.head = new Node(1);
		Node temp = new Node(2);
		ll.head.next = temp;
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = temp;
		removeLoop(ll);
		ll.display();
	}

	private static void removeLoop(Linkedlist ll) {
		Node head = ll.head;
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next; //+1
			fast = fast.next.next; //+2
			if(slow == fast) {
				break;
			}
		}
		Node entry = null;
		slow = head;
		while(slow != fast) {
			entry = fast;
			slow = slow.next;
			fast = fast.next;
		}
		
		entry.next = null;
		
	}

}
