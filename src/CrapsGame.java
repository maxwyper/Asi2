import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continuePlaying = true;

        // Loop to keep playing the game until the user chooses to quit
        while (continuePlaying) {
            // Initial roll
            int die1 = rollDie(random);
            int die2 = rollDie(random);
            int sum = die1 + die2;

            System.out.println("You rolled a " + die1 + " and a " + die2 + " for a sum of " + sum);

            // Check for 'craps' or 'natural'
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost.");
                continuePlaying = playAgain(scanner);  // Check if user wants to play again
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won with a natural.");
                continuePlaying = playAgain(scanner);  // Check if user wants to play again
            } else {
                // Set the point
                System.out.println("The point is now " + sum + ". Trying for the point...");

                // Keep rolling until the user wins or loses
                while (continuePlaying) {
                    die1 = rollDie(random);
                    die2 = rollDie(random);
                    sum = die1 + die2;

                    System.out.println("You rolled a " + die1 + " and a " + die2 + " for a sum of " + sum);

                    if (sum == 7) {
                        System.out.println("You rolled a 7 and lost.");
                        continuePlaying = playAgain(scanner);  // Check if user wants to play again
                        break;
                    } else if (sum == sum) {
                        System.out.println("You made the point and won!");
                        continuePlaying = playAgain(scanner);  // Check if user wants to play again
                        break;
                    } else {
                        System.out.println("Trying for the point...");
                    }
                }
            }
        }
    }

    // Method to simulate rolling a die
    public static int rollDie(Random random) {
        return random.nextInt(6) + 1;
    }

    // Method to ask the user if they want to play again
    public static boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (y/n): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }
}
