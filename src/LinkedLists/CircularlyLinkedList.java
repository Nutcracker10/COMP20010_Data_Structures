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
	}//end of removeFirst
	
	public void remove(E key) //removes node at key
	{
		Node<E> tmp = tail;
		
		if(tmp.getElement() == key)//checks if tail is the node to remove
		{
			tail = tail.next;
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
	}//end of remove
	
	public void insertBefore(E key, E content) // adds element into the list before the key
	{
		Node<E> tmp = tail;
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
	}//end of insertBefore
	
	 public String toString() 
	  {
		  String output = new String();
		  Node<E> tmp = tail;
		  
		  while (tmp != null)
		  {
			  output += "[" + tmp.getElement() + "]\n";
			  tmp = tmp.getNext();
		  }
		  return output;
	  }//end of toString
	 
	 public static void main(String[] args)
	{
		CircularlyLinkedList CList = new CircularlyLinkedList<>();
		
	}
	
	
}
