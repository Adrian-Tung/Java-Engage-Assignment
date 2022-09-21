import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {

	public static void main(String[] args) {
		int totalGenes = 100;
		int[] genesArray = {0,0,0,0,0};
		String[] breedArray = {"St. Bernard","Chihuahua","Dramatic RedNosed Asian Pug",
				"Common Cur","King Doberman"};
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("What is your dog's name? ");
		String dogName = input.nextLine();
		System.out.println("Well then, I have this highly reliable report on "+
		dogName + "'s prestigious background right here.");
		System.out.println("Sir " +dogName+" is:\n");
		
		for(int i = 0; i<genesArray.length;i++) {
			if (i==(genesArray.length-1)) {
				genesArray[i] = totalGenes; // Last remaining genes percentage
				System.out.println(genesArray[i]+"% " + breedArray[i]);
				break;
			}
			int randomGenes = random.nextInt(totalGenes - 0) + 0;
			genesArray[i] = randomGenes;
			totalGenes = totalGenes-randomGenes;
			System.out.println(genesArray[i]+"% " + breedArray[i]);
		}
		System.out.println("\nWow, that's QUITE the dog!");
		
		
		
		
		
		
	}// main

}// class
