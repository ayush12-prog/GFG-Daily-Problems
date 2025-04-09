//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    static int time;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        int[] disc = new int[V], low = new int[V], par = new int[V];
        boolean[] vis = new boolean[V], ap = new boolean[V];
        Arrays.fill(disc, -1);
        Arrays.fill(par, -1);
        time = 0;

        for (int i = 0; i < V; i++)
            if (!vis[i]) dfs(i, g, vis, disc, low, par, ap);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) if (ap[i]) res.add(i);
        if (res.isEmpty()) res.add(-1);
        return res;
    }

    static void dfs(int u, ArrayList<ArrayList<Integer>> g, boolean[] vis,
                    int[] d, int[] l, int[] p, boolean[] ap) {
        vis[u] = true;
        d[u] = l[u] = ++time;
        int ch = 0;

        for (int v : g.get(u)) {
            if (!vis[v]) {
                ch++; p[v] = u;
                dfs(v, g, vis, d, l, p, ap);
                l[u] = Math.min(l[u], l[v]);
                if ((p[u] == -1 && ch > 1) || (p[u] != -1 && l[v] >= d[u]))
                    ap[u] = true;
            } else if (v != p[u]) {
                l[u] = Math.min(l[u], d[v]);
            }
        }
    }
}
