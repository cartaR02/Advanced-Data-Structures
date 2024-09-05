import java.util.Scanner;

public class CMSC401_A1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = scanner.nextInt();
        
        int[] candidatesArrayCounter = new int[3];
        int[] candidatesArray = new int[3];

        for (int i = 0; i < lineNumber; i++){
            int nextCandidate = scanner.nextInt();
            
            // checking if equal to any to increase counting
            if (nextCandidate == candidatesArray[0]){
                candidatesArrayCounter[0]++;
            } else if(nextCandidate == candidatesArray[1]){
                candidatesArrayCounter[1]++;
            } else if(nextCandidate == candidatesArray[2]){
                candidatesArrayCounter[2]++;
            } else {
                // does not equal any of the numbers
                // now check if it can be assigned
                if (candidatesArray[0] == 0){
                    candidatesArray[0] = nextCandidate;
                    candidatesArrayCounter[0] = 1;
                } else if (candidatesArray[1] == 0){
                    candidatesArray[1] = nextCandidate;
                    candidatesArrayCounter[1] = 1;
                } else if (candidatesArray[2] == 0){
                    candidatesArray[2] = nextCandidate;
                    candidatesArrayCounter[2] = 1;
                } else {
                    // does not equal any and all the slots are filled then decrease all counter
                    candidatesArrayCounter[0]--;
                    candidatesArrayCounter[1]--;
                    candidatesArrayCounter[2]--;
                }
            }
        }
        
        //sorting array
        if (candidatesArray[0] > candidatesArray[1]){
            int tempNumber = candidatesArray[0];
            int tempCounter = candidatesArrayCounter[0];
            // swap candidates numbers and the counter
            // no need to compare counters
            candidatesArray[0] = candidatesArray[1];
            candidatesArray[1] = tempNumber;
            candidatesArrayCounter[0] = candidatesArrayCounter[1];
            candidatesArrayCounter[1] = tempCounter;
        }
        if (candidatesArray[1] > candidatesArray[2]){
            int tempNumber = candidatesArray[1];
            int tempCounter = candidatesArrayCounter[1];
            // swap candidates numbers and the counter
            // no need to compare counters
            candidatesArray[1] = candidatesArray[2];
            candidatesArray[2] = tempNumber;
            candidatesArrayCounter[1] = candidatesArrayCounter[2];
            candidatesArrayCounter[2] = tempCounter;
        }
        
        if (candidatesArray[0] > candidatesArray[1]){
            int tempNumber = candidatesArray[0];
            int tempCounter = candidatesArrayCounter[0];
            // swap candidates numbers and the counter
            // no need to compare counters
            candidatesArray[0] = candidatesArray[1];
            candidatesArray[1] = tempNumber;
            candidatesArrayCounter[0] = candidatesArrayCounter[1];
            candidatesArrayCounter[1] = tempCounter;
        }
        int remainderCount = lineNumber/4;
        int printingCount = 0;
        if (candidatesArrayCounter[0] > remainderCount){
            System.out.print(candidatesArray[0]);
            printingCount++;
        }
        if (candidatesArrayCounter[1] > remainderCount){
            System.out.print(" " + candidatesArray[1]);
            printingCount++;
        } 
        if (candidatesArrayCounter[2] > remainderCount){
            System.out.println(" " + candidatesArray[2]);
            printingCount++;
        }

        if (printingCount == 0){
            System.out.println("-1");
        }
        scanner.close();
    }
}

