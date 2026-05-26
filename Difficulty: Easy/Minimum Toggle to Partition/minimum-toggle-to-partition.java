class Solution {
    public int minToggle(int[] arr) {
        int totalZeros = 0;
        for (int num : arr) {
            if (num == 0) {
                totalZeros++;
            }
        }
        
        int minToggles = totalZeros;
        int onesLeft = 0;
        int zerosRight = totalZeros;
        
        for (int num : arr) {
            if (num == 1) {
                onesLeft++;
            } else {
                zerosRight--;
            }
            
            int currentToggles = onesLeft + zerosRight;
            if (currentToggles < minToggles) {
                minToggles = currentToggles;
            }
        }
        
        return minToggles;
    }
}