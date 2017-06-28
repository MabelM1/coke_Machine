import java.util.Scanner;

public class CokeMachine {
	
	Scanner scanner = new Scanner(System.in);
	
	private static int coins;
	
	//Constructor that initializes coins value to 0
	public CokeMachine() {
		coins = 0;
	}
	
	/* Method that prompts user to enter a coin. If a valid denomination is entered it 
	 * updates the total number of coins received. Once the total coins value reaches $1 or more 
	 * it calls the dispenseItem method. 
	 */
	public void insertCoin() {		
		while (true && coins < 100) {
			System.out.println("Insert coin: ");
			int input= scanner.nextInt();
			
			if (input == 5 || input == 10 || input == 25) {	
				coins += input;
				System.out.println("Amount inserted: " + coins);	
			} else {
				System.out.println("Rejecting " + input + " cent coin\n"
				+ "Amount inserted: " + coins);
			}		
		}		
		dispenseItem();		
	}
	
	
	
	/* Method that display the menu of items available and accepts a selection. If
	 * a valid selection is made it display what was selected and calls the returnChange method.
	 */
	public void dispenseItem () {
		int selection;
		String drink;
		
		do {
				System.out.println("Please make selection:\n" +
				"1 - Coke\n" +
				"2 - Coke Zero\n" +
				"3 - Caffeine Free Diet coke\n");
				
				selection = scanner.nextInt();
				
		} while (selection < 1 || selection >3);
			
		if (selection == 1) {
			drink = "Coke";
		} else if (selection == 2) {
			drink = "Coke Zero";			
		} else {
			drink = "Caffeine Free Diet Coke";
		}	
		System.out.println("Your choice: " + selection + "\nDispensing " + drink);
		returnChange();
	}
	
	/* Method that calculates if change is required. Then resets the coin total to 0 and calls
	 * the insertCoin method to continue vending items.
	 * 
	 */
	public void returnChange() {
		int change = coins - 100;
		
		while (change > 0) {
			
			if ((change % 10) == 0 )
			{
				System.out.println("Returning dime");
				change -= 10;
			} else {
				System.out.println("Returning Nickel");
				change -= 5;
			}			
		}
		coins = 0;
		System.out.println("\n");
		insertCoin();		
	}
	
	public static void main(String[] args) {
		
		CokeMachine mymachine = new CokeMachine();
		mymachine.insertCoin();
		
	}

}
