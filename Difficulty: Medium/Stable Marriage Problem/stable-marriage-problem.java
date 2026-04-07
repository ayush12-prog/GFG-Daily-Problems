class Solution {

    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        int[] menPartner = new int[n];
        int[] womenPartner = new int[n];
        Arrays.fill(menPartner, -1);
        Arrays.fill(womenPartner, -1);

        int[] nextProposal = new int[n];

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) freeMen.add(i);

        while (!freeMen.isEmpty()) {
            int man = freeMen.poll();
            int woman = men[man][nextProposal[man]];
            nextProposal[man]++;

            if (womenPartner[woman] == -1) {
                womenPartner[woman] = man;
                menPartner[man] = woman;
            } else {
                int currentMan = womenPartner[woman];
                if (rank[woman][man] < rank[woman][currentMan]) {
                    womenPartner[woman] = man;
                    menPartner[man] = woman;
                    menPartner[currentMan] = -1;
                    freeMen.add(currentMan);
                } else {
                    freeMen.add(man);
                }
            }
        }

        return menPartner;
    }
}