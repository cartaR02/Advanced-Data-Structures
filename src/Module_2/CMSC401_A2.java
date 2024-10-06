// 10/03/2024
// Carter Struck

import java.util.Random;
import java.util.Scanner;

public class CMSC401_A2 {

    static void quicksort(int studentNumberArr[], int begining, int end){

        if (begining < end){

            int partitionIndex = partition(studentNumberArr, begining, end);
        }
    }

    static int partition(int arr[], int start, int finish){
        // this will put the pivot at the end
        arr = findRandomPivot(arr, start, finish);

        // start 1 before the start
        int i = (start - 1);
        for (int j = start; j < finish; j++){
            // if the value is smaller than pivot than move i
            // and swap
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // swap pivot for where i + 1 is to put in right spot


    }

    // Finds random number between the start and the finish number
    // then puts the randomly found number in the last spot
    static int[] findRandomPivot(int arr[], int start, int finish){

        Random random = new Random();
        int pivotIndex = random.nextInt(finish-start)+start;

        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[finish];
        arr[finish] = temp;

        return arr;
    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();

        int luckyNumberSpot = scanner.nextInt();

        int[] studentsNumbers = new int[numberOfStudents];

        // assigns students numbers to the array
        for (int i = 0; i < numberOfStudents; i++){
            int nextStudentNumber = scanner.nextInt();
            studentsNumbers[i] = nextStudentNumber;
        }

        quicksort(studentsNumbers, 0, numberOfStudents);

        System.out.println();
    }
}
