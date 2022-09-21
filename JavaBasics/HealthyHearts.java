import java.util.Scanner;

public class HealthyHearts {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your age? ");
		int age = input.nextInt();
		int maxHr = 220-age;
		int minHrZone =(int)Math.ceil(maxHr * 0.5);
		int maxHrZone =(int)Math.ceil(maxHr * 0.85);
		System.out.println("Your maximum heart rate should be " + maxHr + " beats per minute");
		System.out.println("Your target HR Zone is " + minHrZone + " - " + maxHrZone + " beats per minute");
	}

}
