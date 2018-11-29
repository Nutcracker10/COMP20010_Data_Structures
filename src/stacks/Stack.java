package stacks;

public interface Stack<E>
{
	//returns number of elements
	int size();
	
	//returns true if empty
	boolean isEmpty();
	
	// Inserts element at top of stack
	void push(E e);
	
	//element at top of stack
	E top();
	
	//returns and removes element at top of stack
	E pop();
	
}
