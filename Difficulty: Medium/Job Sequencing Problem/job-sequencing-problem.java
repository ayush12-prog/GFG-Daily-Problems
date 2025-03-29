//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Job {
    int deadline, profit;
    
    public Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        
        // Step 1: Create job objects
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }
        
        // Step 2: Sort jobs by descending profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        // Step 3: Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        // Step 4: Create a time slot array
        int[] slots = new int[maxDeadline + 1]; // 0th index is unused
        Arrays.fill(slots, -1); // -1 means empty slot
        
        int jobCount = 0, totalProfit = 0;
        
        // Step 5: Assign jobs to available slots
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) { // Check slots from deadline backward
                if (slots[j] == -1) {
                    slots[j] = job.profit; // Mark slot as filled
                    jobCount++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount);
        result.add(totalProfit);
        return result;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends