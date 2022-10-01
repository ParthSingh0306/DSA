package LinkedList;

import LinkedList.Linkedlist.Node;

public class CheckLLPalindrome {

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(6);
		ll.addLast(2);
		ll.addLast(1);
		ll.display();
		System.out.println(palindrome(ll));
	}
	
	public static boolean palindrome(Linkedlist ll) {
		Node left = ll.head;
		if(left == null || left.next == null) {
			return true;
		}
		Node mid = findMid(ll);
		Node right = Reverse(mid);
		while(right != null) {
			if(right.val != left.val) {
				return false;
			}
			right = right.next;
			left = left.next;
		}
		return true;
	}
	
	public static Node findMid(Linkedlist ll) {
		Node slow = ll.head;
		Node fast = ll.head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static Node Reverse(Node head) {
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
