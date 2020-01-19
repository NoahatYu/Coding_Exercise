import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Question 3:
 * ----------
 * Generate 500 random numbers and create a method to print the nth smallest number.
 */
public class NthRandomNum {
    /**
     * Find the Kth smallest element of an array
     * Using a Priority Queue as a min-heap to find the kth element without sorting the array.
     * @param arr : Given array arr
     * @param k     : value of k
     * @return : Kth smallest element
     */
    public static int findKthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();//min-heap priorityQ
        //Add all elements into Q
        for (int val : arr) {
            pQ.add(val);
        }
        int val  = 0;
        //Pull out k elements until found kth value that is answer
        for( ;k > 0;k--){
            val = pQ.poll();
        }
        return val;
    }

    public static void main(String[] args) {
        int [] arr = new int[500]; // generate a random 500 integers
        System.out.print("Array of Random Ints: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);//generate a random number
            System.out.print(arr[i] + "|");
        }
        System.out.println();
        //Scanner to get user input
        System.out.println("Enter a value for K:");
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());

        System.out.println("Result: " + findKthSmallestElement(arr,k));
    }

}
