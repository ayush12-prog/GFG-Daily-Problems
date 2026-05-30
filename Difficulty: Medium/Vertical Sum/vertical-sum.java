/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        dfs(root, 0, map);
        
        for (int sum : map.values()) {
            result.add(sum);
        }
        
        return result;
    }
    
    private void dfs(Node node, int hd, TreeMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        
        // Add current node's value to the sum for this horizontal distance
        map.put(hd, map.getOrDefault(hd, 0) + node.data);
        
        // Traverse left child with hd - 1
        dfs(node.left, hd - 1, map);
        
        // Traverse right child with hd + 1
        dfs(node.right, hd + 1, map);
    }
}