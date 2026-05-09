class Solution {
    public int countSpanTree(int n, int[][] edges) {
        if (n <= 1) return 1;

        double[][] L = new double[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            L[u][u]++;
            L[v][v]++;
            L[u][v]--;
            L[v][u]--;
        }

        int reducedSize = n - 1;
        double[][] L_prime = new double[reducedSize][reducedSize];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                L_prime[i - 1][j - 1] = L[i][j];
            }
        }

        double det = 1.0;
        for (int i = 0; i < reducedSize; i++) {
            int pivot = i;
            for (int j = i + 1; j < reducedSize; j++) {
                if (Math.abs(L_prime[j][i]) > Math.abs(L_prime[pivot][i])) {
                    pivot = j;
                }
            }

            if (pivot != i) {
                double[] temp = L_prime[i];
                L_prime[i] = L_prime[pivot];
                L_prime[pivot] = temp;
                det *= -1.0;
            }

            if (Math.abs(L_prime[i][i]) < 1e-9) {
                return 0;
            }

            det *= L_prime[i][i];

            for (int j = i + 1; j < reducedSize; j++) {
                double factor = L_prime[j][i] / L_prime[i][i];
                for (int k = i; k < reducedSize; k++) {
                    L_prime[j][k] -= factor * L_prime[i][k];
                }
            }
        }

        return (int) Math.round(det);
    }
}