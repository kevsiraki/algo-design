// Kevin Siraki
// Project 3 COMP 482
import java.io.*;
import java.util.*;
class Project3 {
    private static int[] readFile() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        int[] arr = new int[scan.nextInt()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = scan.nextInt();
        scan.close();
        return arr;
    }
    private static int maxSum(int arr[], int low, int high) { //nlog(n) method
        if (low == high) //only one element (base case)
            return arr[low];
        int mid = (low + high) / 2; //middle of subArray
        int sum = 0, leftSum = 0, rightSum = 0, i = mid + 1, maxPair;
        while (i <= high) { //right side sum of the subarray
            sum += arr[i++];
            rightSum = sum > rightSum ? sum : rightSum;
        }
        sum = 0; 
        i = mid;
         while (i >= low) { //left side sum of the subarray
            sum += arr[i--];
            leftSum = sum > leftSum ? sum : leftSum;
        } 
        maxPair = Math.max(leftSum + rightSum, Math.max(leftSum, rightSum)); //Max(wholeSubSum, Max(leftSubSum,righSubSum))
        return Math.max(Math.max(maxSum(arr, low, mid), maxSum(arr, mid + 1, high)), maxPair); //Max(Max(arr[low]->arr[mid], arr[mid+1]->arr[high] call),currentMax)
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print(maxSum(readFile(), 0, readFile().length - 1)); //method call
    }
}