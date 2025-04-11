import java.util.Random;
import java.util.Scanner;


/**
 * This program is a number guessing game where the user must guess
 * a randomly generated number between 1 and 6.
 *
 * @author Santiago Hewett
 * @version 1.0
 * @since 2025/02/26
 */

final class DiceGame {
    /**.
     * Minimum possible guess value
     **/
    private static final int MIN_VALUE = 1;
    /**.
     * Maximum possible guess value
     **/
    private static final int MAX_VALUE = 6;
    /**
     * Private constructor to prevent instantiation.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * The main method runs the guessing game.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // Random number generator
        Random random = new Random();
        final int targetNumber = random.nextInt(MAX_VALUE) + MIN_VALUE;
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Variables for user input and attempt count
        int guess = 0;
        int attempts = 0;
        // Welcome message
        System.out.println("Welcome to the dice guessing game!");
        System.out.println("I have chosen a integer between " + MIN_VALUE
                + " and " + MAX_VALUE + ". Try to guess it!");
        // Loop until the correct number is guessed
        do {
            System.out.print("Enter your guess: ");
            String userInput = scanner.nextLine();
            try {
                // Convert user input to integer
                guess = Integer.parseInt(userInput);
                attempts++;
                // Check if guess is within range
                if (guess < MIN_VALUE || guess > MAX_VALUE) {
                    System.out.println("Invalid guess: " + guess
                            + ". Please enter a integer between "
                            + MIN_VALUE + " and " + MAX_VALUE + ".");
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                }
            } catch (NumberFormatException error) {
                // Catch invalid input
                System.out.println("Invalid input: " + userInput
                        + ". Please enter a valid integer between "
                        + MIN_VALUE + " and " + MAX_VALUE + ".");
            }
        } while (guess != targetNumber);
        // Winning message with attempt count
        System.out.println("Congratulations! You guessed the number in "
                + attempts + " attempts.");
        // Close scanner
        scanner.close();
    }
}
