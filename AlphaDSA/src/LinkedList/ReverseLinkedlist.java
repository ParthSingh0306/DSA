package LinkedList;

import LinkedList.Linkedlist.Node;

public class ReverseLinkedlist {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		Reverse(ll);
		ll.display();
	}
	
	public static void Reverse(Linkedlist ll) {
		Node curr = ll.head;
		Node prev = null;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		ll.head = prev;
		
	}

}
