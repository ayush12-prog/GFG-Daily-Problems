//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int maxPartitions(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int partitions = 0;
        int maxLastIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            maxLastIndex = Math.max(maxLastIndex, lastIndex[s.charAt(i) - 'a']);
            if (i == maxLastIndex) {
                partitions++;
            }
        }

        return partitions;
    }
}