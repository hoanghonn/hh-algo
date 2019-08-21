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
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flattenHelper(root);
        
    }
    
    public TreeNode flattenHelper(TreeNode root) {
        if(root == null) return null;
        
        TreeNode right = root.right;
        root.right = flattenHelper(root.left);
        root.left = null;
        if(root.right == null) root.right= flattenHelper(right);
        else{
            TreeNode lastNode = getLastRightNode(root.right);
            lastNode.right = flattenHelper(right);
        }
        return root;
        
    }
    
    public TreeNode getLastRightNode(TreeNode root){
        if(root == null) return null;
        
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}
```