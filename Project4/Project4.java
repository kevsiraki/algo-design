// Kevin Siraki
// Project 4 COMP 482
import java.io.*;
import java.util.*;
import static java.lang.Math.max;
class Project4 {
    private static int[] readFile() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        int[] a = new int[scan.nextInt()];
        for (int i = 0; i < a.length; i++)
            a[i] = scan.nextInt();
        scan.close();
        return a;
    }
    private static int largestSumNonConsec(int[] a) { //O(n)
        if (a.length == 1) return a[0];
        else if (a.length == 2) return max(a[0], a[1]);
        int[] dp = new int[a.length]; //dynamic programming array
        dp[0] = a[0];
        dp[1] = max(a[0], a[1]);
        for (int i = 2; i < a.length; i++) 
            dp[i] = max(max(a[i] + dp[i - 2], dp[i - 1]), a[i]);
        return dp[a.length - 1];
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print(largestSumNonConsec(readFile()));
    }
}