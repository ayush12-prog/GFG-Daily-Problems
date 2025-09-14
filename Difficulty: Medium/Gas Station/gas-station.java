class Solution {
    public int startStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int startStation = 0;
        int currentTank = 0;

        for (int i = 0; i < gas.length; i++) {
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }
        
        return startStation;
    }
}

