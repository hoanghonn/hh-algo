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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode buildHelper(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if(il > ir || pl > pr) return null;
        int N = inorder.length;
        if(!isValid(il, N) || !isValid(ir, N) || !isValid(pl, N) || !isValid(pr, N)) return null;
        int leftrange = 0;
        int val = preorder[pl];
        int i = il;
        for(i = il; i <= ir; i++){
            if(inorder[i] == val) break;
            leftrange++;
        }
        TreeNode root = new TreeNode(val);
        root.left = buildHelper(preorder, inorder, pl+1, pl+leftrange, il, i-1);
        root.right = buildHelper(preorder, inorder, pl+leftrange+1, pr, i+1, ir);
        return root;
    }
    
    public boolean isValid(int index, int length){
        if(index < 0 || index >= length) return false;
        return true;
    }
}
```