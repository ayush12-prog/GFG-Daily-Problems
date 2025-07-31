
class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int active = 0;
        int maxPowerful = -1;
        Integer prev = null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int curr = entry.getKey();
            if (prev != null && active >= k) {
                maxPowerful = Math.max(maxPowerful, curr - 1);
            }
            active += entry.getValue();
            prev = curr;
        }

        return maxPowerful;
    }
}