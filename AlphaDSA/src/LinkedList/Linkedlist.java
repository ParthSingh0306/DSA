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

	public static void main(String[] args) {
		Linkedlist ll = new Linkedlist();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(4);
		ll.addLast(5);
		ll.add(2, 3);
		ll.display();
		System.out.println(ll.size);
	}

}
