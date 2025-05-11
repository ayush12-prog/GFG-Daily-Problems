//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        // Min-heap to store the top k largest sums
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate over all possible subarrays
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];

                // Add sum to min-heap
                minHeap.offer(sum);

                // Keep only the top k largest sums
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        // The root of the heap is the K-th largest sum
        return minHeap.peek();
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.kthLargest(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends