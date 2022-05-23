// Kevin Siraki
// Project 2 COMP 482, Read in a set of ints and generate a score array.
// 10/21/2021
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
class Project2 {
    private static int[] readFile() throws FileNotFoundException { //read array from file helper
        Scanner scan = new Scanner(new File("input.txt"));
        int dimensions = scan.nextInt();
        int[] arr = new int[dimensions];
        for (int i = 0; i < arr.length; i++)
            arr[i] = scan.nextInt(); //populate array 
        scan.close();
        return arr; //returns array from file of correct dimensions
    }
    private static int[] getScore(int[] arr) { //ranking helper 
		if(arr.length ==1) //tiny array :)
			return new int[]{1};
		int values[] = new int[arr.length];
        for (int j = 0; j < arr.length; j++) //O(n^2)
            for (int i = 0; i < arr.length; i++)
				if (arr[i] < 1) //Greedy. Start with most obvious/beneficial step. All values must be >=1.
					values[i] = 1;
				else if (i != arr.length - 1 && i != 0 && arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) //Next most beneficial case. Both neighbors smaller.
					values[i] = Math.max(values[i+1],values[i-1]) + 1; //Increment the bigger neighbor.
				else if (i != 0 && arr[i] > arr[i - 1]) //Left neighbor smaller.
					values[i] = values[i - 1] + 1;
				else if (i != arr.length - 1 && arr[i] > arr[i + 1]) //Right neighbor smaller.
					values[i] = values[i + 1] + 1;
				else //Both neighbors bigger.
					values[i] = 1;
        return values;
    }
    public static void main(String args[]) throws Exception {
        //Arrays.stream(getScore(readFile())).forEach(i -> System.out.print(i + " ")); //Print array 1-liner.
        System.out.println("\n" + IntStream.of((getScore(readFile()))).sum()); //Array sum 1-liner.
    }
}