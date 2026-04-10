class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        List<Integer> result = new ArrayList<>();
        
        if (arr == null || arr.length < 3) {
            return result;
        }
        
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int firstForSecond = Integer.MAX_VALUE;
        
        for (int num : arr) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
                firstForSecond = first; 
            } else {
                result.add(firstForSecond);
                result.add(second);
                result.add(num);
                return result;
            }
        }
        
        return result;
    }
}