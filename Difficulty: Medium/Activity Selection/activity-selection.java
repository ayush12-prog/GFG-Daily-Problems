//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        if (n == 0) return 0;
        
        // Create an array of Activity objects
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], finish[i]);
        }
        
        // Sort activities by finish time (ascending), then by start time (ascending)
        Arrays.sort(activities, (a, b) -> {
            if (a.finish != b.finish) {
                return a.finish - b.finish;
            } else {
                return a.start - b.start;
            }
        });
        
        int count = 1; // At least one activity can be done
        int lastFinish = activities[0].finish;
        
        for (int i = 1; i < n; i++) {
            if (activities[i].start > lastFinish) { // Note: '>=' changed to '>'
                count++;
                lastFinish = activities[i].finish;
            }
        }
        
        return count;
    }
    
    // Helper class to store start and finish times
    class Activity {
        int start;
        int finish;
        
        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}