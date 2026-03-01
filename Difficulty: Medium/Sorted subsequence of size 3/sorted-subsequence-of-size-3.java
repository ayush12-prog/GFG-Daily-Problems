class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int seqFirst = Integer.MAX_VALUE;
        
        for (int num : arr) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
                seqFirst = first;
            } else {
                result.add(seqFirst);
                result.add(second);
                result.add(num);
                return result;
            }
        }
        
        return result;
    }
}