import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int userChoice;
		String userChoiceString = null;
		String compChoiceString = null;
		String roundResult = null;
		
		while(true) { // game loop
			int ties = 0;
			int userWins = 0;
			int compWins = 0;
			
			System.out.println("Please enter number of rounds to play (1 to 10): ");
			int rounds = input.nextInt();
			if (rounds < 1 || rounds > 10) {
				System.out.println("Invalid number!");
				System.out.println("Exiting game!");
				break;
			}
			for(int i = 0;i < rounds;i++) { //rounds loop
				System.out.println("Round: "+(i+1)+"\n");
				
				while(true) { // user choice validation
					System.out.println("Please choose -\n\n1 for Rock\n2 for Paper\n3 for Scissors\n");
					System.out.println("Enter your Choice (1-3): ");
					userChoice = input.nextInt();
					if (userChoice < 1 ||userChoice >3 ) {
						System.out.println("Invalid choice! Please enter again\n");
					} else {
						break;
					}
				} // while 
				
				int compChoice = rand.nextInt((3 - 1) + 1) + 1;
				switch(compChoice) {
					case 1: compChoiceString = "Rock"; break;
					case 2: compChoiceString = "Paper"; break;
					case 3: compChoiceString = "Scissors"; 
				}// switch 
				
				if(userChoice == 1) { //User choose Rock
					userChoiceString = "Rock";
					switch(compChoice) {
					case 1: //Computer Rock
						ties++;
						roundResult = "Ties!";
						break;
					case 2: //Computer Paper
						compWins++;
						roundResult = "You lose!";
						break;
					case 3: //Computer Scissors
						userWins++;
						roundResult = "You win!";
					} //switch
				} 
				else if(userChoice == 2) { //User choose Paper
					userChoiceString = "Paper";
					switch(compChoice) {
					case 1: //Computer Rock
						userWins++;
						roundResult = "You win!";
						break;
					case 2: //Computer Paper
						ties++;
						roundResult = "Ties!";
						break;
					case 3: //Computer Scissors
						compWins++;
						roundResult = "You lose!";	
					} //switch	
				} 
				else { // User choose Scissors
					userChoiceString = "Scissors";
					switch(compChoice) {
					case 1: //Computer Rock
						compWins++;
						roundResult = "You lose!";
						break;
					case 2: //Computer Paper
						userWins++;
						roundResult = "You win!";
						break;
					case 3: // Computer Scissors
						ties++;
						roundResult = "Ties!";	
					}
				}
					System.out.println("Your choice: "+ userChoiceString
							+ "\nComputer choice: "+ compChoiceString + "\nResult: " + roundResult +"\n");	
			}// for loop (rounds)
			
			System.out.println("Game result!"+ "\n\nYou won: "+userWins + " rounds " + "\nComputer won: " +
			compWins + " rounds "+"\nTies: " + ties);
			if (userWins > compWins) {
				System.out.println("You won the game!");
			} else if (userWins < compWins) {
				System.out.println("You lose the game!");
			} else {
				System.out.println("Its a draw!");
			}
			
			System.out.println("Play again? Enter yes/no: ");
			input.nextLine();
			String nextGame = input.nextLine().toLowerCase();
			
			if (nextGame.equals("yes")){
				continue;
			} else {
				System.out.println("Thanks for playing!");
				break;
			}
		}// while loop (game)
	}// main
}// class
