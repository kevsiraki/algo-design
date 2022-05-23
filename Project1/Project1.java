// Kevin Siraki
// Project 1
// 9/20/2021
// Read in a set of ints and perform ProposeDispose
import java.io.*;
import java.util.*;
class Project1 {
	public static int[][] readFile() throws FileNotFoundException { //read array from file helper
        Scanner scan =  new Scanner(new File("input.txt"));
        int dimensions = scan.nextInt();
        int[][] arr = new int[dimensions][dimensions];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = scan.nextInt(); //populate array 
        scan.close();
        return arr; //returns 2d array from file of correct dimensions
    }
    public static void print2d(int[][] arr) { //print array helper
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
    public static int[][] proposeDispose(int[][] arr) { //propose dispose helper
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                result[i][arr[i][j] - 1] = j + 1; //treat elements as indices
        return result;
    }
    public static void main(String args[]) throws Exception {
        print2d(proposeDispose(readFile())); //print output array
    }
}