package LinkedLists;

import java.util.Iterator;


public class DoublyLinkedList<E> {
	
	private Node<E> header; // node @beginning
	
	private Node<E> trailer; // node @end of list
	
	private int size = 0;

	private static class Node<E> 
	{
		
		private E element; // ref to element stored in this nodeter
		
		private Node<E> prev; // ref to previous node in list
		
		private Node<E> next; // ref to next node in list
		
		public Node(E e, Node<E> p, Node<E> n)//overloaded constructor
		{
			element = e;
			prev = p;
			next = n;
		}
		
		public E getElement() // gets element in current node
		{
			return element;
		}
		
		public Node<E> getPrev() // returns previous node
		{
			return prev;
		}
		
		public Node<E> getNext() // returns next node
		{
			return next;
		}
		
		public void setPrev(Node<E> p) // sets ref to previous 
		{
			prev = p;
		}
		
		public void setNext(Node<E> n) // sets ref to next node
		{
			next = n;
		}
	}//end of node

	public DoublyLinkedList()
	{
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
	}
	
	public int size() // returns size of list
	{
		return size;
	}

	public boolean isEmpty() // returns true / false if list is empty
	{
		return size == 0;
	}
	
	public E first()
	{
		if(isEmpty())
			return null;
		
		return header.getNext().getElement();
	}
	
	public E last()
	{
		if( isEmpty()) return null;
		
		return trailer.getPrev().getElement();
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor)
	{
		Node<E> newest = new Node<E>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	private E remove(Node<E> node)
	{
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		
		size--;
		return node.getElement();
	}
	
	public void addFirst(E e)
	{
		addBetween(e, header, header.getNext()); // places after header
	}
	
	public void addLast(E e)
	{
		addBetween(e, trailer.getPrev(), trailer); // places before trailer
	}
	
	public E removeFirst()
	{
		if(isEmpty()) return null; // nothing to remove
		return remove(header.getNext()); // last element is before trailer
	}
	
	public Iterator<E> iterator() 
	{
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> 
	{
		Node<E> curr;
		
		public ListIterator()
		{
			curr = header;
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
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() 
	{
		 String output = new String();
		  Node<E> tmp = header.getNext();
		  
		  while (tmp != trailer)
		  {
			  output += "[" + tmp.getElement() + "]\n";
			  tmp = tmp.getNext();
		  }
		  return output;
	}

	public static void main(String[] args) 
	{
		DoublyLinkedList<String> SList = new DoublyLinkedList<String>();
		
		SList.addFirst("Gerry");
		SList.addLast("Beth");
		SList.addLast("Joan");
		SList.addLast("James");
		
		System.out.println(SList);
	}
}
