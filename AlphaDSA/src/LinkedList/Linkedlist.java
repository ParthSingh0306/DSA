package LinkedList;

public class Linkedlist {
	
	public static class Node{
		int val;
		Node next;
		
		public Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	public static Node head;
	public static Node tail;
	public static int size;
	
	public void addFirst(int val) {
		Node node = new Node(val);
		size++;
		if(head == null) {
			head = tail = node;
			return;
		}
		node.next = head;
		head = node;
	}
	
	public void addLast(int val) {
		Node node = new Node(val);
		size++;
		if(head == null) {
			head = tail = node;
			return;
		}
		tail.next = node;
		tail = node;
	}
	
	public void add(int idx, int val) {
		if(idx == 0) {
			addFirst(val);
			return;
		}
		Node node = new Node(val);
		size++;
		Node temp = head;
		int i = 0;
		while(i < idx-1) {
			temp = temp.next;
			i++;
		}
		
		node.next = temp.next;
		temp.next = node;
	}
	
	public int removeFirst() {
		if(size == 0) {
			System.out.println("Linkedlist is Empty");
			return Integer.MIN_VALUE;
		}else if(size == 1) {
			int val = head.val;
			head = tail = null;
			size = 0;
			return val;
		}
		int val = head.val;
		head = head.next;
		size--;
		return val;
	}
	
	public int removeLast() {
		if(size == 0) {
			System.out.println("Linkedlist is Empty");
			return Integer.MIN_VALUE;
		}else if(size == 1) {
			int val = head.val;
			head = tail = null;
			size = 0;
			return val;
		}
//		prev: size-2
		Node prev = head;
		for(int i=0; i<size-2; i++) {
			prev = prev.next;
		}
		
		int val = prev.next.val; //tail.val
		prev.next = null;
		tail = prev;
		size--;
		return val;
	}
	
	public void display() {
		if(head == null) {
			System.out.println("Linkedlist is Empty");
		}else {	
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.val + "->");
				temp = temp.next;
			}
			System.out.println("null");
		}
	}
	
	public int itrSearch(int key) {
		Node temp = head;
		int i = 0;
		while(temp != null) {
			if(temp.val == key) {
				return i;
			}
			temp = temp.next;
			i++;
		}
		return -1;
	}
	
	public int RecSearch(Node head, int key){
		if(head == null) return -1;
		if(head.val == key) {
			return 0;
		}
		
		int ans = RecSearch(head.next, key);
		if(ans == -1) return -1;
		return ans + 1;
	}

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(4);
		ll.addLast(5);
		ll.add(2, 3);
		ll.display();
//		System.out.println(ll.size);
//		
//		ll.removeFirst();
//		ll.display();
//		System.out.println(ll.size);
//		
//		ll.removeLast();
//		ll.display();
		System.out.println(ll.size);
		System.out.println(ll.itrSearch(3));
		System.out.println(ll.RecSearch(ll.head, 4));
		
	}

}
