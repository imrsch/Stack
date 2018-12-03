import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		
		System.out.println("Bitte gib deinen Klammerausdruck ein, den du prüfen möchtest: ");
		//Scanner
		Scanner sc = new Scanner(System.in);
		
		String Input = sc.nextLine();	
		System.out.println("Der Ausdruck ist " + (pruefCorrectness(Input) ? "richtig." : "falsch."));//boolean true/false	
		System.out.println("Exit.");
	}

	//This method checks the expression for the correctness of the bracket
	public static boolean pruefCorrectness(String Input) 
	{
		Stack storage = new Stack();
		for (int i = 0; i < Input.length(); i++) 
		{
			//variable place gets the input of the user
			char place = Input.charAt(i);
			//if input = opened bracket -> push bracket on the stack
			if (place == '(' || place == '{' || place == '[') 
			{	
				storage.push(Input.charAt(i));
			} 
			//if input != closed bracket -> pop storage
			else if ((place == ')') || (place == '}') || (place== ']')) 
			{		
				char bracket = storage.pop();
				//check if the brackets are from the same kind
				if (!((bracket == '(' && place == ')') || 
					  (bracket == '{' && place == '}') || 
					  (bracket== '[' && place == ']'))
				   ) 
				{
					System.out.println("Falsches Zeichen an Stelle:  " + i);
					return false;
				}
			}
		}
		//check if the stack is not empty
		if (storage.pop() != '\u0000') 
		{
			System.out.println("Falsches Zeichen an Stelle:  "+Input.length());
			return false;
		}
		return true;
	}
}