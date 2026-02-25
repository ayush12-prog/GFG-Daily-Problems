class Solution {
    public int countSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0;
        int count = 0;
        
        for (int num : arr) {
            sum += (num == 0) ? -1 : 1;
            
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}