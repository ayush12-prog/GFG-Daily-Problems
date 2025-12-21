class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];
            
            if (!map.containsKey(x)) {
                result.add(0);
                continue;
            }
            
            List<Integer> indices = map.get(x);
            int left = findLeft(indices, l);
            int right = findRight(indices, r);
            
            result.add(Math.max(0, right - left));
        }
        
        return result;
    }
    
    private int findLeft(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private int findRight(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}