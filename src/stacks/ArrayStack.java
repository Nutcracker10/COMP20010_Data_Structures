package stacks;

import java.util.Arrays;

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
	
	@Override
	public String toString()
	{
		String outputs = new String();
		int i=0;
		
		while (data[i] != null)
		{
			if(i%10 == 0)
				outputs += "\n" + data[i] + " ";
			else
				outputs += data[i] + " ";
			i++;
		}
		return outputs;
	}
	
	public static void main(String[] args)
	{
		ArrayStack<String> stack = new ArrayStack<>();
		//a string for testing pop function
		String[] temp = new String[5];
		//Print data before entries
		System.out.println("The stack size is " + stack.size());
		//add some generic data
		String[] family = {"Gerry", "James", "Joan", "Beth", "Mandy", "Trip", "Ruth", "Jean", "Brian", "Paula", "Rory"};
		for(int i=0; i<family.length; i++)
		{
		  stack.push(family[i]);
		}
		//Demonstrate top is working
		System.out.println(stack.top());
		//Demonstrates toString method + new stack size
		System.out.println("\nThe stack size is " + stack.size());
		System.out.println(stack + "\n");
		
		//Demonstrate pop function
		for(int i=0; i<5; i++)
		{
			temp[i] = stack.pop();
		}
		System.out.println(stack);
		System.out.print(Arrays.toString(temp) + "\n");
		//demonstrate push is working
		stack.push("Laura");
		System.out.println("The stack size is " + stack.size());
		System.out.println(stack + "\n");
		
	}
	
}
