package LinkedList;

import LinkedList.Linkedlist.Node;

public class FindRemoveN {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		Remove(ll, ll.size, 5);
		ll.display();
	}

	private static void Remove(Linkedlist ll, int size, int i) {
		int idx = size - i;
		int j = 1;
		Node temp = ll.head;
		if(i == size) {
			ll.head = ll.head.next;
			return;
		}
		while(j < idx) {
			temp = temp.next;
			j++;
		}
		temp.next = temp.next.next;
	}

}
