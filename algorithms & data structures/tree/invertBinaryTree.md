2. Invert a binary tree.
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode copy = new TreeNode(root.val);
        invertHelper(root, copy);
        return copy;
    }
    
    private void invertHelper(TreeNode root, TreeNode copy){
        if(root.left != null){
            copy.right = new TreeNode(root.left.val);
            invertHelper(root.left, copy.right);
        } 
        if(root.right != null){
            copy.left = new TreeNode(root.right.val);
            invertHelper(root.right, copy.left);
        }
    }
}
```