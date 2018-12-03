import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		
		System.out.println("Bitte gib deinen Klammerausdruck an: (Exit ist Ende)"); // NUtte
		Scanner sc = new Scanner(System.in);	
		String EingabeString = sc.nextLine();
				
		System.out.println("Die Eingabe ist " + (pruefKlammern(EingabeString) ? "korrekt." : "falsch."));		
		System.out.println("Programm Ende");
	}


	public static boolean pruefKlammern(String EingabeString) 
	{
		/*This method checks the entered string to the semantic correctness of the brackets.
		 *To do this, a stack is created as a storage area, to which an open bracket is added each time one occurs in the string.  
		 *When a closed bracket appears, it is compared with the top bracket on the stack to see if it belongs to the same kind.
		 *If they do not match, an error message is output.
		 *After this process it is checked if the stack is empty. If the stack is not empty, an error message is also output.
		 * */
		Stack ablage = new Stack();
		for (int i = 0; i < EingabeString.length(); i++) 
		{
			char Platzhalter = EingabeString.charAt(i);
	
			if (Platzhalter == '(' || Platzhalter == '{' || Platzhalter == '[') 
			{	
				//push a bracket on the stack
				ablage.push(EingabeString.charAt(i));
			} 
			else if ((Platzhalter == ')') || (Platzhalter == '}') || (Platzhalter == ']')) 
			{		
				char StackKlammer = ablage.pop();
				//check if the brackets are from the same kind
				if (!((StackKlammer == '(' && Platzhalter == ')') || 
					  (StackKlammer == '{' && Platzhalter == '}') || 
					  (StackKlammer== '[' && Platzhalter == ']'))
				   ) 
				{
					System.out.println("Falsches Zeichen an Stelle:  " + i);
					return false;
				}
			}
		}
		//check is the storage is empty
		if (ablage.pop() != '\u0000') 
		{
			System.out.println("Falsches Zeichen an Stelle:  "+EingabeString.length());
			return false;
		}
		return true;
	}
}