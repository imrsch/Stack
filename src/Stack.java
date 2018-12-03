public class Stack 
{
	private int pointer;
	FArray stack;

	//method:stack
	public Stack() 
	{
		stack = new FArray();
		pointer = 0;//array starts at 0
	}
	//add char on the stack
	public void push(char symbol) 
	{
		stack.setValue(pointer++, symbol);		
	}
	//delete char where the pointer is and return the new size of the stack
	public char pop() 
	{
		char size = stack.getValue(pointer-1);
		stack.setValue(pointer--, '\u0000');//deleted char = \u0000(null)
		return size;
	}
}