package LinkedLists;

public class CircularlyLinkedList<E>
{
	private static class Node<E>
	{
		private E element; // reference to the element stored at this node

		private Node<E> next; // reference to the subsequent node in the list

		public Node(E e, Node<E> n) // overloaded constructor
		{
			element = e;
			n = next;
		}

		public E getElement() {
			return element;
		}
			
		public void setNext(Node<E> n) {
			this.next = n;
		}

		public Node<E> getNext() {
			return next; 
			}
	}//end of node
	
	private Node<E> tail = null; // only store tail, not head
	
	private int size = 0;
	
	public CircularlyLinkedList() {};
	
	public int size() {return size;};
	
	public boolean isEmpty() {return size == 0; }
	
	public E first()  // returns first element of list
	{
		if (isEmpty()) return null;
		
		return tail.getNext().getElement();
	}//end of first
	
	public E last() // returns last element of list
	{
		if (isEmpty()) return null;
		
		return tail.getNext().getElement();
	}//end of last
	
	public void rotate() // rotate first element to back of list
	{
		if(tail != null)
			tail = tail.getNext(); // old head becomes new tail
	}//end of rotate
	
	public void addFirst(E e) //adds element to front of list
	{
		if (size == 0)
		{
			tail = new Node<>(e, null); 
			tail.setNext(tail); // links to self
		}
		else
		{
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}//end of addFirst
	
	public void addLast(E e) // adds element to end of list
	{
		addFirst(e);
		tail = tail.getNext();//new element becomes tail
	}//end of addLast
	
	public E removeFirst() //removes and returns first element
	{
		if(isEmpty())
			return null;
		
		Node<E> head = tail.getNext();
		if(head == tail)//sets tail to null if nothing else left
			tail = null;
		else
			tail.setNext(head.getNext());
		
		size--;
		return head.getElement();
	}
}
