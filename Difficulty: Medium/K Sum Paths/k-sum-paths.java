/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int count = 0;
    
    public int countAllPaths(Node root, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // To handle cases where the path starts directly from the root
        
        dfs(root, 0, k, prefixMap);
        
        return count;
    }
    
    private void dfs(Node node, int currentSum, int k, HashMap<Integer, Integer> prefixMap) {
        if (node == null) {
            return;
        }
        
        currentSum += node.data;
        
        // Check if there is a prefix sum that we can subtract to get k
        if (prefixMap.containsKey(currentSum - k)) {
            count += prefixMap.get(currentSum - k);
        }
        
        // Add the current sum to the map
        prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        
        // Recurse for left and right children
        dfs(node.left, currentSum, k, prefixMap);
        dfs(node.right, currentSum, k, prefixMap);
        
        // Backtrack: remove the current sum from the map before returning to the parent
        prefixMap.put(currentSum, prefixMap.get(currentSum) - 1);
    }
}