package LinkedList;

import LinkedList.Linkedlist.Node;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(2);
		ll.addLast(1);
		deleteMiddle(ll.head);
		ll.display();
		
	}
	
	public static void deleteMiddle(Node head) {
        if(head.next == null){
            head = head.next;
            return;
        }
        Node slow = head;
        Node fast = head;
        Node entry = null;
        while(fast != null && fast.next != null){
            entry = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        entry.next = entry.next.next;
    }

}
