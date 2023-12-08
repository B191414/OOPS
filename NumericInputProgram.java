import java.util.InputMismatchException;
import java.util.Scanner;

public class NumericInputProgram 
{
    public static void main(String[] args)
     {
        try 
        {
            int numericInput = readNumericInput();
            System.out.println("You entered: " + numericInput);
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }

    private static int readNumericInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a numeric value: ");

        // Read an integer from the user
        int input = scanner.nextInt();

        // Close the scanner to prevent resource leak
        scanner.close();

        return input;
    }
}

