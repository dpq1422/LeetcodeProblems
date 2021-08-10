package com.dpq.DS.practice;

public class CircularLinkedList<T> {
	private Node<T> head;
	private static int counter;
	
	public String toString() {
		
		String output = "";
 
		if (head != null) {
			Node<T> crunchifyCurrent = head;
			while (true) {
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getNext();
				if(crunchifyCurrent == head) break;
			}
 
		}
		return output;
	}
	
	public boolean add(T data) {
		Node<T> newNode = new Node<>(data);
		if(head == null) {
			newNode.setNext(newNode);
			head = newNode;
			return true;
		}else {
			Node<T> current = head;
			while(current.getNext()!=head) {
				current = current.getNext();
			}
			newNode.setNext(head);
			current.setNext(newNode);
		}
		incrementCounter();
		return true;
	}
	
	public boolean add(int index , T data) {
		Node<T> newNode = new Node<>(data);
		if(index == 0 && head == null) {
			newNode.setNext(newNode);
			head = newNode;
			return true;
		}else if(size() == index || index == 0) {
			Node<T> current = head;
			while(current.getNext()!=head) {
				current = current.getNext();
			}
			if(size() == index) {
				newNode.setNext(head);
				current.setNext(newNode);
			}else {
				newNode.setNext(head);
				current.setNext(newNode);
				head = newNode;
				return true;
			}
			
		}else{
			 Node<T> current = head;
			 Node<T> prevNode = null;
			 for(int i=0 ; i < index ; i++){
				prevNode = current;
				current = current.getNext();
			 }
			 prevNode.setNext(newNode);
			 newNode.setNext(current);
		}
		incrementCounter();
		return true;
	}
	
	public static void main(String[] args) {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.add(10);list.add(20);list.add(30);list.add(40);list.add(50);
		System.out.println(list);
		list.add(0,5);
		System.out.println(list);
		list.add(3,25);
		System.out.println(list);
		list.add(size(),55);
		System.out.println(list);
	}
	
	public static void incrementCounter() {
		counter++;
	}
	
	public static void decrementCounter() {
		counter--;
	}
	
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public static int size() {
		return counter;
	}
	public class Node<T> {
		
		private T data;
		private Node<T> next;
		
		public Node (T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}
		
		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}	
		
		
	}

}
