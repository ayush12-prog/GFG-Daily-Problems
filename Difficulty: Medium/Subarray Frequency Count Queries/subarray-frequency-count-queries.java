class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // Map to store the list of indices for each element
        HashMap<Integer, ArrayList<Integer>> indexMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!indexMap.containsKey(arr[i])) {
                indexMap.put(arr[i], new ArrayList<>());
            }
            indexMap.get(arr[i]).add(i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];
            
            // If the element doesn't exist in the array, its frequency is 0
            if (!indexMap.containsKey(x)) {
                result.add(0);
            } else {
                ArrayList<Integer> indices = indexMap.get(x);
                
                // Number of elements in range [l, r] is upperBound(r) - lowerBound(l)
                int leftIdx = lowerBound(indices, l);
                int rightIdx = upperBound(indices, r);
                
                result.add(rightIdx - leftIdx);
            }
        }
        
        return result;
    }
    
    // Finds the first index in the list that is >= target
    private int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    // Finds the first index in the list that is > target
    private int upperBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}