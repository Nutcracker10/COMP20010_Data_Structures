package LinkedLists;

import java.util.*;

public class SinglyLinkedList<E> implements Iterable<E>{
	/**
	 * Node of a singly linked list, which stores a reference to its element and to
	 * the subsequent node in the list (or null if this is the last node).
	 */
	private static class Node<E> {

		/** The element stored at this node */
		private E element; // reference to the element stored at this node

		/** A reference to the subsequent node in the list */
		private Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e: the element to be stored
		 * @param n: reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> n) // overloaded constructor
		{
			element = e;
			n = next;
		}

		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n
		 *            the node that should follow this one
		 */
		public void setNext(Node<E> n) {
			this.next = n;
		}
	} 

	// instance variables of the SinglyLinkedList
	/** The head node of the list */
	private Node<E> head = null; // head node of the list (or null if empty)

	/** The last node of the list */
	private Node<E> tail = null; // last node of the list (or null if empty)

	/** Number of nodes in the list */
	private int size = 0; // number of nodes in the list

	/** Constructs an initially empty list. */
	public SinglyLinkedList() {
	} 

	// access methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns (but does not remove) the first element of the list
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() { // returns (but does not remove) the first element
		if(head != null)
			return (E) head.getElement();
		
		else
			return null;
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() { // returns (but does not remove) the last element
		if(tail != null)
			return (E) tail.getElement();
					
		else
			return null;
	}

	// update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e
	 *            the new element to add
	 */
	public void addFirst(E e) 
	{ // adds element e to the front of the list
		Node<E> tmp = head;
		Node<E> oldhead = tmp;
		Node<E> newhead = new Node<E>(e, tmp);
		
		newhead.setNext(oldhead);
		head = newhead;
		
		if(isEmpty())
		{
			tail = head;
		}
		size++;
	}


	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e
	 *            the new element to add
	 */
	public void addLast(E e) { // adds element e to the end of the list
		Node<E> tmp = head;
		while(tmp.getNext() != null)
		{
			tmp = tmp.getNext();
		}
		Node<E> newtail = new Node<E>(e, null); // creates new node
		tmp.setNext(newtail);
		size++;
	}

	public void insertBefore(E key, E content) // adds element into the list before the key
	{
		Node<E> tmp = head;
		Node<E> tmpnext = tmp.getNext();//tmpnext is always one link ahead of tmp in the list
		while(tmp.getNext() != null)
		{
			tmp = tmp.getNext();
			tmpnext = tmp.getNext();
			
			if(tmpnext.getElement() == key)//if tmpnext is equal to the key, break the loop and create the node
				break;
		}
		Node<E> newcontent = new Node<E>(content, tmp);
		tmp.setNext(newcontent);//sets new node
		size++;
		
	}

	public void remove(E key) //removes node at key
	{
		Node<E> tmp = head;
		
		if(tmp.getElement() == key)//checks if head is the node to remove
		{
			head = head.next;
			return;
		}
		
		while(tmp.getNext() != null)//iterates through loop 
		{
			tmp = tmp.getNext();
			
			if(tmp.getElement() == key)//finds and removes key node
			{
				tmp = tmp.next;
				return;
			}
		}
		size--;
	}
	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() { // removes and returns the first element
		E removed;
		head = head.getNext();
		removed = (E) head;
		return removed;
	}

	public Object copy()
	{
		SinglyLinkedList<E> twin = new SinglyLinkedList<E>();
		Node<E> tmp = head;
		while(tmp != null)
		{
			twin.addLast(tmp.getElement());
			tmp = tmp.next;
		}
		return twin;
	}
	
	public boolean equals(Object o) //looks for a node equal to o
	{
		Node<E> tmp = head;
		while (tmp.getNext() != null)
		{
			tmp = tmp.getNext();
			
			if(o == tmp)//if a node equal to o is found, return true
				return true;
		}
		return false;//if no equal node is found return false
	}


	public Iterator<E> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<E>{
		Node<E> curr;
		
		public ListIterator()
		{
			curr = head;
		}
		
		public boolean hasNext()
		{
			return curr != null;
		}
		
		@Override
		public E next()
		{
			E res = (E) curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}
	/**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() 
  {
	  String output = new String();
	  Node<E> tmp = head;
	  
	  while (tmp != null)
	  {
		  output += "[" + tmp.getElement() + "]\n";
		  tmp = tmp.getNext();
	  }
	  return output;
  }
  
  public static void main(String[] args) 
  {
	  SinglyLinkedList<String> SList = new SinglyLinkedList<String>();
	  
	  SList.addFirst("Joan");
	  SList.addLast("Beth");
	  SList.addFirst("Gerry");
	  SList.addFirst("James");
	  
	  System.out.println(SList);
	  
	  SinglyLinkedList<Integer> IList = new SinglyLinkedList<Integer>();
	  
	  IList.addFirst(2);
	  IList.addLast(3);
	  IList.addFirst(1);
	  IList.addLast(4);
	  
	  System.out.print(IList);
	  
  }
}
