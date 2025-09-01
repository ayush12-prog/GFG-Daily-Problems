class Solution {
    public long sumOfModes(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> bucket = new TreeMap<>();
        
        long sum = 0;
        int n = arr.length;

        // helper to add element
        Runnable addElement = () -> {};
        
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int oldFreq = freq.getOrDefault(x, 0);
            if (oldFreq > 0) {
                TreeSet<Integer> set = bucket.get(oldFreq);
                set.remove(x);
                if (set.isEmpty()) bucket.remove(oldFreq);
            }
            int newFreq = oldFreq + 1;
            freq.put(x, newFreq);
            bucket.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(x);

            // remove element leaving window
            if (i >= k) {
                int y = arr[i - k];
                int f = freq.get(y);
                bucket.get(f).remove(y);
                if (bucket.get(f).isEmpty()) bucket.remove(f);
                
                if (f == 1) {
                    freq.remove(y);
                } else {
                    freq.put(y, f - 1);
                    bucket.computeIfAbsent(f - 1, z -> new TreeSet<>()).add(y);
                }
            }

            // if window full, compute mode
            if (i >= k - 1) {
                int maxFreq = bucket.lastKey();
                int mode = bucket.get(maxFreq).first();
                sum += mode;
            }
        }

        return sum;
    }
}