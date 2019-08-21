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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        else max = 1;
        lcHelper(root);
        return max;
    }
    
    public int lcHelper(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = lcHelper(root.left);
        int right = lcHelper(root.right);
        
        if(left != 0 && root.left.val - root.val == 1) left++; 
        else if(right != 0 && root.right.val - root.val == 1) right++;
        else return 1;    
        if(left > max) max = left;
        if(right > max) max = right;
        return (left < right) ? right : left;
    }

}
```