class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(arr1.length == 0 || arr2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for(int i = 0; i < Math.min(k, arr1.length); i++) {
            pq.offer(new int[]{arr1[i], arr2[0], 0});
        }

        while(k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            result.add(pair);

            if(cur[2] + 1 < arr2.length) {
                pq.offer(new int[]{cur[0], arr2[cur[2] + 1], cur[2] + 1});
            }
        }

        return result;
    }
}
