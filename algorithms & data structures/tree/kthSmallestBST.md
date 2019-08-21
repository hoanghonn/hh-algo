3. Kth smallest in BST
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> lst = new ArrayList<>();
        inorder(root, lst);
        return lst.get(k-1).val;
    }
    
    private void inorder(TreeNode root, List<TreeNode> lst){
        if(root == null) return;
        
        inorder(root.left, lst);
        lst.add(root);
        inorder(root.right, lst);
    }
}
```