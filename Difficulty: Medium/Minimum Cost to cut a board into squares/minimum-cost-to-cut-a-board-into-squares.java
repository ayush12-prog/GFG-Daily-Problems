class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // Convert primitive arrays to wrapper arrays for reverse sorting
        Integer[] xInteger = Arrays.stream(x).boxed().toArray(Integer[]::new);
        Integer[] yInteger = Arrays.stream(y).boxed().toArray(Integer[]::new);

        Arrays.sort(xInteger, Collections.reverseOrder());
        Arrays.sort(yInteger, Collections.reverseOrder());

        int horizontalCuts = 0;
        int verticalCuts = 0;
        int horizontalSegments = 1;
        int verticalSegments = 1;
        int totalCost = 0;

        while (horizontalCuts < y.length && verticalCuts < x.length) {
            if (yInteger[horizontalCuts] > xInteger[verticalCuts]) {
                totalCost += yInteger[horizontalCuts] * verticalSegments;
                horizontalSegments++;
                horizontalCuts++;
            } else {
                totalCost += xInteger[verticalCuts] * horizontalSegments;
                verticalSegments++;
                verticalCuts++;
            }
        }

        while (horizontalCuts < y.length) {
            totalCost += yInteger[horizontalCuts] * verticalSegments;
            horizontalSegments++;
            horizontalCuts++;
        }

        while (verticalCuts < x.length) {
            totalCost += xInteger[verticalCuts] * horizontalSegments;
            verticalSegments++;
            verticalCuts++;
        }

        return totalCost;
    }
}
