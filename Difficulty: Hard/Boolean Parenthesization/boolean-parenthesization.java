//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int countWays(String s) {
        int n = s.length();
        int[][] trueCount = new int[n][n];
        int[][] falseCount = new int[n][n];

        // Base cases
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) == 'T') {
                trueCount[i][i] = 1;
                falseCount[i][i] = 0;
            } else if (s.charAt(i) == 'F') {
                trueCount[i][i] = 0;
                falseCount[i][i] = 1;
            }
        }

        // Fill the DP tables
        for (int len = 3; len <= n; len += 2) { // len is the length of the substring
            for (int i = 0; i <= n - len; i += 2) { // i is the starting index
                int j = i + len - 1; // j is the ending index
                for (int k = i + 1; k < j; k += 2) { // k is the operator index
                    char operator = s.charAt(k);

                    // Calculate total true and false counts based on the operator
                    int leftTrue = trueCount[i][k - 1];
                    int leftFalse = falseCount[i][k - 1];
                    int rightTrue = trueCount[k + 1][j];
                    int rightFalse = falseCount[k + 1][j];

                    if (operator == '&') {
                        trueCount[i][j] += leftTrue * rightTrue;
                        falseCount[i][j] += leftFalse * rightFalse + leftFalse * rightTrue + leftTrue * rightFalse;
                    } else if (operator == '|') {
                        trueCount[i][j] += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                        falseCount[i][j] += leftFalse * rightFalse;
                    } else if (operator == '^') {
                        trueCount[i][j] += leftTrue * rightFalse + leftFalse * rightTrue;
                        falseCount[i][j] += leftTrue * rightTrue + leftFalse * rightFalse;
                    }
                }
            }
        }

        // Return the number of ways to parenthesize the expression to evaluate to true
        return trueCount[0][n - 1];
    }
}