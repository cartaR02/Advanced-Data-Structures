// CMSC 401 08/20/2024
// Carter Struck
import java.util.Scanner;

public class CMSC401_A0 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int lineNumbers = scanner.nextInt();
        // First number needed to calculate how many lines to iterate over 
        for (int i = 0; i < lineNumbers; i++){
            int numberOfIntegers = scanner.nextInt();
            // Subtracts 2 to get correct size with index numbers at the end
            int sizeOfIntegerArray = numberOfIntegers - 2;
            int[] integerArray = new int[sizeOfIntegerArray];
            // not <= so that it can stop one below the size at the correct index
            for (int h = 0; h < sizeOfIntegerArray; h++){
                integerArray[h] = scanner.nextInt();
            }
            int firstIndex = scanner.nextInt();
            int secondIndex = scanner.nextInt();
            // indecies given in human position but not array position
            // needs - 1 adjustment
            int product = integerArray[firstIndex - 1] * integerArray[secondIndex - 1];
            System.out.println(product);
        }
    }
}
