class Solution {
    public void pushZerosToEnd(int[] arr) {
        int insertPos = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap the non-zero element to the insertPos
                int temp = arr[insertPos];
                arr[insertPos] = arr[i];
                arr[i] = temp;
                
                // Move the insertPos forward
                insertPos++;
            }
        }
    }
}