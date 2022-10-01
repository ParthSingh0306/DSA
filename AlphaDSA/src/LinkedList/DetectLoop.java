package LinkedList;

import LinkedList.Linkedlist.Node;

public class DetectLoop {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.head = new Node(1);
		ll.head.next = new Node(2);
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = ll.head;
		System.out.println(isCycle(ll));
	}

	private static boolean isCycle(Linkedlist ll) {
		Node head = ll.head;
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next; //+1
			fast = fast.next.next; //+2
			if(slow == fast) return true; //cycle exists
		}
		return false; //cycle doesnt exist
	}

}
