
public class ArrayStack<E> implements Stack<E>
{
	public static final int CAPACITY=1000; // default capacity
	
	private E[] data; // generic array used for data
	
	private int t = -1;
	
	public ArrayStack() { this(CAPACITY);}
	
	@SuppressWarnings({"unchecked"})
	public ArrayStack(int capacity) // constructs the stack with capacity
	{
		data =( (E[]) new Object[capacity]); // casts , ignoring compiler warning
	}
	
	@Override
	public int size()
	{
		return (t + 1);
	}
	
	@Override
	public E top()
	{
		if (isEmpty())
			return null;
		return data[t];
	}
	
	@Override
	public boolean isEmpty()
	{
		return (t == -1);
	}
	
	@Override
	public void push(E e) // element will be added to top of stack
		throws IllegalStateException
		{
			if (size() == data.length)
				throw new IllegalStateException("Stack is full");
			data[++t] = e; // important to preincrement t
		}
	
	@Override
	public E pop() // element will be removed and returned from stack
	{
		if (isEmpty())
			return null;
		
		E answer = data[t];
		
		data[t] = null;
		t--;
		return answer;
	}
	
}
