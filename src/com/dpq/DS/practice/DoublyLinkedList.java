package com.dpq.DS.practice;

import com.dpq.DS.practice.LinkedList.Node;

public class DoublyLinkedList<T> {
	
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
			newNode.setPrev(current);
			incrementCounter();
			flag = true;
		}
		return flag;
	}
	
	public boolean add(int index,T data) {
		boolean flag = false;
		
		Node<T> newNode = new Node<T>(data);
		
		if(head==null) {
			head = newNode;
			return true;
		}else{
			Node<T> current = head;
			
			if(index==0) {
				newNode.setNext(current);
				current.setPrev(newNode);
				head=newNode;
			}else {
				for(int i = 0 ; i<index-1 && current.getNext() != null ; i++) {
					current = current.getNext();
				}
				Node<T> nextNode = null;
				if(current.getNext()!=null) {
					nextNode = current.getNext();
					nextNode.setPrev(newNode);
				}
				newNode.setNext(nextNode);
				newNode.setPrev(current);
				current.setNext(newNode);
			}
			
			incrementCounter();
			flag = true;
		}
		return flag;
	}
	
	public T get(int index) {
		if(index <0 || index>size()) return null;
		else {
			Node<T> current = head;
			for(int i=0 ; i<index ; i++) {
				current = current.getNext();
			}
			return current.getData();
		}
	}
	
	public boolean remove(int index) {
		if(index <0 || index>size()) return false;
		else {
			Node<T> current = head;
			if(index==0) {
				head = head.getNext();
				head.setPrev(null);
				return true;
			}else {
				Node<T> prevNode = null;
				
				for(int i = 0 ; i<index && current.getNext() != null ; i++) {
					prevNode = current;
					current = current.getNext();
				}
				Node<T> nextNode = null;
				if(current != null && current.getNext() != null) {
					nextNode = current.getNext();
					prevNode.setNext(nextNode);
					nextNode.setPrev(prevNode);
				}else {
					prevNode.setNext(null);
					current=prevNode;
				}
				
				return true;
			}
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(30);
		list.add(50);
		list.add(60);
		
		System.out.println(list);
		
		list.add(2,25);
		
		System.out.println(list);
		list.add(0,5);
		System.out.println(list);
		
		list.add(size()+1,70);
		System.out.println(list);
		System.out.println(list.get(-1));
		System.out.println(list.get(100));
		System.out.println(list.get(0));
		System.out.println(list.get(3));
		System.out.println(list.get(size()));
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		list.remove(size());
		System.out.println(list);
	}
	public String toString() {
		String output = "";
 
		if (head != null) {
			Node<T> crunchifyCurrent = head;
			Node<T> prevNode = head;
			while (crunchifyCurrent != null) {
				prevNode=crunchifyCurrent;
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getNext();
				
			}
			output = output +" REVERSE ";
			crunchifyCurrent = prevNode;
			while (crunchifyCurrent != null) {
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getPrev();
			}
 
		}
		return output;
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
		private Node<T> prev;
		
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
		

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		public void setData(T data) {
			this.data = data;
		}

		 @Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + ", prev=" + prev + "]";
		}	
		
		
	}
}