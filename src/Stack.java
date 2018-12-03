public class Stack 
{
	private int pointer;
	FArray stack;

	public Stack() 
	{
		stack = new FArray();
		pointer = 0;
	}
	public void push(char Klammer) 
	{
		//add the letter on the stack
		stack.setValue(pointer++, Klammer);		
	}
	public char pop() 
	{
		//delete a char where pointer is, an return the char 
		char inhalt = stack.getValue(pointer-1);
		stack.setValue(pointer--, '\u0000'); 
		return inhalt;
	}
}