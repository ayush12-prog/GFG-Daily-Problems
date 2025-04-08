//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    int time;
    boolean isBridge;

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        time = 0;
        isBridge = false;
        boolean[] vis = new boolean[V];
        int[] disc = new int[V], low = new int[V];

        for (int i = 0; i < V; i++)
            if (!vis[i]) dfs(i, -1, vis, disc, low, adj, c, d);

        return isBridge;
    }

    void dfs(int u, int p, boolean[] vis, int[] disc, int[] low,
             List<List<Integer>> adj, int c, int d) {
        vis[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (v == p) continue;
            if (!vis[v]) {
                dfs(v, u, vis, disc, low, adj, c, d);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u] && ((u == c && v == d) || (u == d && v == c)))
                    isBridge = true;
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends