package com.dpq.DS.practice;

public class LinkedList<T> {
	
	private Node<T> head;
	private static int counter;
	
	public boolean add(T data) {
		boolean flag = false;
		
		Node<T> newNode = new Node<T>(data);
		
		if(head==null) {
			head = newNode;
			return true;
		}else{
			Node<T> current = head;
			while(current!=null && current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
			incrementCounter();
			flag = true;
		}
		return flag;
	}
	
	public boolean add(T data, int index) {
		boolean flag = false;
		
		Node<T> newNode = new Node<T>(data);
		
		if(head==null) return flag;
		else if(size()+1 < index) {
			System.out.println("Array index out of bound " + data);
			return flag;
		}
		else{
			Node<T> current = head;
			
			for(int i=0 ; i<index-1 && current.getNext()!=null ; i++) {
				current = current.getNext();
			}
			if(index==0) { //to add at begining
				newNode.setNext(current);
				head = newNode;
			}
			else {
				newNode.setNext(current.getNext());
				current.setNext(newNode);
			}
			
			incrementCounter();
			flag = true;
		}
		return flag;
	}
	
	public T get(int index) {
		
		if(head==null) new RuntimeException("List cant be null or empty");
		else if(size() < index) new RuntimeException("List retrival index is out of bound..");
		else{
			Node<T> current = head;
			
			for(int i=0 ; i<index ; i++) {
				current = current.getNext();
			}
			return current.getData();
		}
		return null;
	}
	
	public boolean remove(int index) {
		boolean flag = false;
		
		if(head == null) return flag;
		else if(size() < index) return flag;
		else{
				Node<T> current = head;
				
				for(int i=0 ; i < index-1 && current.getNext()!=null ; i++) {
					current = current.getNext();
				}
				if(index == 0) {
					head=current.getNext();
				}else
					current.setNext(current.getNext().getNext());
				
				decrementCounter();
				flag = true;
		}
		return flag;
	}
	
	public boolean remove(Node<T> nodeToBeDeleted) {
		boolean flag = false;
		
		if(head == null) return flag;
		else{
				Node<T> current = head;
				Node<T> prevNode = null;
				
				while(current!= null) {
					if(current.getData() == nodeToBeDeleted.getData()) {
						flag = true;
						break;
					}else {
						prevNode = current;
						current = current.getNext();
					}
				}
				
				if(flag && prevNode!=null) {
					prevNode.setNext(current.getNext());
				}
				else if(flag && prevNode == null)
					head = current.getNext();
				else if(prevNode!=null && prevNode.getData() == nodeToBeDeleted.getData()) {
					head = prevNode.getNext();
				}
				decrementCounter();
				
		}
		return flag;
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
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(30);
		list.add(50);
		list.add(60);
		list.add(15,1);
		list.add(35,5);
		list.add(60, 7);
		list.add(68, 7);
		list.add(6100, size()+1);
		list.add(5,0);
		System.out.println(list);
		
		java.util.LinkedList<Integer> linkedList = new java.util.LinkedList<>();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(40);
		linkedList.add(30);
		linkedList.add(50);
		linkedList.add(60);
		linkedList.add(1,15);
		linkedList.add(5,35);
		linkedList.add(7, 60);
		linkedList.add(7, 68);
		linkedList.add(linkedList.size(), 6100);
		linkedList.add(0,5);
		System.out.println(linkedList);
		
		System.out.println(list.remove(0));
		System.out.println(list);
		LinkedList.Node node = list.new Node(6100);
		list.remove(node);
		System.out.println(list);
		
	
		
	}

	public String toString() {
		String output = "";
 
		if (head != null) {
			Node<T> crunchifyCurrent = head;
			while (crunchifyCurrent != null) {
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
 
		}
		return output;
	}
	
	
}
