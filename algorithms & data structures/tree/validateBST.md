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
    //Recursive solution
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
    
    public boolean validateBST(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        
        boolean left = validateBST(root.left, min, root.val);
        boolean right = validateBST(root.right, root.val, max);
        
        return left && right; 
    }


    //Iterative solution
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        double max = - Double.MAX_VALUE;
        while(!s.isEmpty() || root != null){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(root.val <= max) return false;
            max = root.val;
            root = root.right;
        }
        return true;
    }
}
```