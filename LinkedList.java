/**
 * Project: Social Agent Simulation
 * File: LinkedList.java
 * Author: Ryan Mogauro
 * Date: 3/18/2022
 * Course: CS231
 */
import java.util.Iterator;    // defines the Iterator interface
import java.util.ArrayList;   
import java.util.Collections; // contains a shuffle function

public class LinkedList<T> implements Iterable<T> {
	private Node<T> head; 
	private int size;
	
	private class Node <T>{
		private Node<T> next; 
		private T data;
		
		// a constructor that initializes next to null and the container field to item.
		public Node(T item) {
			this.data = item; 
			this.next = null; 
		}
		
		//returns the value of the container field.
		public T getThing() {
			return this.data;
		}
		
		//sets next to the given node.
		public void setNext(Node<T> n) {
			this.next = n; 
		}
		
		//returns the next field.
		public Node<T> getNext() {
			return this.next; 
		}
	}
	//constructor that initializes the fields so it is an empty list.
	public LinkedList() {
		this.head = null;
		this.size = 0; 
	}
	
	//empties the list (resets the fields so it is an empty list).
	public void clear() {
		this.head = null; 
		this.size = 0; 
	}
	//returns the size of the list.
	public int size() {
		return this.size; 
	}
	
	//inserts the item at the beginning of the list.
	public void addFirst(T item) {
		Node<T> holder = this.head; 
		this.head = new Node<T>(item); 
		head.next = holder; 
		this.size++;
		
		
	}
	
	//appends the item at the end of the list.
	public void addLast(T item) {
		if(this.head == null) {
			this.addFirst(item);
		} else {
			int index = 0;
			Node<T> newNode = new Node<T>(item); 
			Node<T> current = head; 
		
			while(current!=null) {
				
				index++; 
				if(index == size()) {
					current.setNext(newNode);
				}
				current = current.next;
			}
			size++; 
		}
	}
	
	//inserts the item at the specified poistion in the list.
	public void add(int index, T item) {
		if ( index < 0 || index > size() ) {
			throw new IndexOutOfBoundsException();
		}
		if ( index == 0){
			addFirst(item);
		} else {
			Node<T> newNode = new Node<T>(item);
			newNode.setNext(head); 
			Node<T> currNode = head;
			for (int i = 1; i < index ; i++) {
				currNode = currNode.getNext();
			}
			newNode.setNext(currNode.getNext());
			currNode.setNext(newNode);
			size++;
		}
	}
	//removes the item at the specified position in the list.
	public T remove(int pos) {
		Node<T> current = head;
		Node<T> previous = head;
		int count = 0;
		if(pos == 0) {
			this.head = head.next; 
			
		}
		while(current != null){
			if (count == pos) {
				previous.setNext(current.getNext());
				size--;
				return current.getThing();
			}
 			previous = current;
 			current = current.getNext();
 			count++;
 		}
 		return null;
 	}
	// Return a new LLIterator pointing to the head of the list
	public Iterator<T> iterator() {
	    return new LLIterator( this.head );
	}
	
	private class LLIterator implements Iterator<T>{
		private Node<T> nextNode; 
		
		//the constructor for the LLIterator given the head of a list.
		public LLIterator(Node<T> head) {
			this.nextNode = head; 
		}
		
		//returns true if there are still values to traverse (if the current node reference is not null).
		public boolean hasNext() {
			return (this.nextNode != null); 
		}
		
		//returns the next item in the list, which is the item contained in the current node. The method also needs to move the traversal along to the next node in the list.
		public T next() {
			T result = this.nextNode.getThing(); 
			this.nextNode = nextNode.next;
			return result; 
		}
		
		//does nothing. Implementing this function is optional for an Iterator.
//		public void remove() {
//			
//		}
	}
	
	//returns an ArrayList of the list contents in order.
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<T>(); 
		Node<T> index = this.head; 
		for(int i = 0; i < this.size(); i++) {
			list.add(index.getThing()); 
			index = index.getNext();
		}
		return list;
	}
	
	// returns an ArrayList of the list contents in shuffled order.
	public ArrayList<T> toShuffledList(){
		ArrayList<T> list = this.toArrayList();
		Collections.shuffle(list);
		return list;
	}
	
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
