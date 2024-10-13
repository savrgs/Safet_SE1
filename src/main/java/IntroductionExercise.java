import java.util.Scanner;

public class IntroductionExercise {

        // Method to convert binary array to decimal
        public static int binary2decimal(int[] binaryArray) {
            int decimalValue = 0;
            int length = binaryArray.length;

            // Iterate over the binary array and calculate the decimal value
            for (int i = 0; i < length; i++) {
                decimalValue += binaryArray[i] * Math.pow(2, length - 1 - i);
            }

            return decimalValue;
        }

        // Main method to accept user input and convert binary array to decimal with error handling
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            try {
                // Ask user for the size of the binary array
                System.out.print("Enter the size of the binary array: ");
                String inputSize = scanner.nextLine();

                // Validate if input is a number
                if (!isNumeric(inputSize)) {
                    System.out.println("Invalid input! Please enter a valid integer for array size.");
                    return;
                }

                int size = Integer.parseInt(inputSize);

                // Check for non-positive size
                if (size <= 0) {
                    System.out.println("The size of the binary array must be greater than 0.");
                    return;
                }

                // Initialize the binary array
                int[] binaryArray = new int[size];

                // Prompt user to enter each binary digit with validation
                System.out.println("Enter the binary digits (0 or 1): ");
                for (int i = 0; i < size; i++) {
                    String inputDigit = scanner.nextLine();

                    // Validate if input is a number
                    if (!isNumeric(inputDigit)) {
                        System.out.println("Invalid input! Only 0 or 1 are allowed.");
                        return;
                    }

                    int digit = Integer.parseInt(inputDigit);

                    // Check if the digit is 0 or 1
                    if (digit != 0 && digit != 1) {
                        System.out.println("Invalid input! Only 0 or 1 are allowed.");
                        return;
                    }

                    binaryArray[i] = digit;
                }

                // Call the conversion method and print the result
                int decimal = binary2decimal(binaryArray);
                System.out.println("The decimal value is: " + decimal);

            } catch (Exception e) {
                // Catch any unforeseen exceptions
                System.out.println("An error occurred: " + e.getMessage());
            } finally {
                // Close the scanner
                scanner.close();
            }
        }

        // Helper method to check if a string is numeric
        public static boolean isNumeric(String str) {
            if (str == null || str.isEmpty()) {
                return false;
            }
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
