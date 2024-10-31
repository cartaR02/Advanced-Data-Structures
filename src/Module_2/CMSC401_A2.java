// 10/03/2024
// Carter Struck

import java.util.Random;
import java.util.Scanner;

public class CMSC401_A2 {

    static void quicksort(int studentNumberArr[], int begining, int end, int luckyNumberSpot){

        if (begining < end){

            int partitionIndex = partition(studentNumberArr, begining, end);

            // correct number is found and no need to continue sorting furthur
            if (luckyNumberSpot == partitionIndex){
                return;
            }

            // after finding piviot and putting it correct place call the 
            // two halves of the array
            quicksort(studentNumberArr, begining, partitionIndex - 1, luckyNumberSpot);
            quicksort(studentNumberArr, partitionIndex + 1, end, luckyNumberSpot);
        }
    }

    static int partition(int arr[], int start, int finish){
        // this will put the pivot at the end
        findRandomPivot(arr, start, finish);
        int pivot = arr[finish];

        // start 1 before the start
        int i = (start - 1);
        for (int j = start; j < finish; j++){
            // if the value is smaller than pivot than move i
            // and swap
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot for where i + 1 is to put in right spot
        int temp = arr[i + 1];
        arr[i+1] = arr[finish];
        arr[finish] = temp;

        return i+1;
    }

    // Finds random number between the start and the finish number
    // then puts the randomly found number in the last spot
    static void findRandomPivot(int arr[], int start, int finish){

        Random random = new Random();
        int pivotIndex = random.nextInt(finish-start)+start;

        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[finish];
        arr[finish] = temp;

    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();

        // gets distance from end to get biggest one
        // could have just sorted array largest to smallest and not need this
        int luckyNumberSpot = numberOfStudents - scanner.nextInt();


        int[] studentsNumbers = new int[numberOfStudents];

        // assigns students numbers to the array
        for (int i = 0; i < numberOfStudents; i++){
            int nextStudentNumber = scanner.nextInt();
            studentsNumbers[i] = nextStudentNumber;
        }
        scanner.close();
        quicksort(studentsNumbers, 0, numberOfStudents-1, luckyNumberSpot);
        
        System.out.println(studentsNumbers[luckyNumberSpot]);
    }
}
