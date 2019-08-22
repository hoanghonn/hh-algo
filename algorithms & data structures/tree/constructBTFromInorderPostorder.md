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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode buildHelper(int[] inorder, int[] postorder, int il, int ir, int pl, int pr){
        if(il > ir || pl > pr) return null;
        int N = inorder.length;
        if(!isValid(il, N) || !isValid(ir, N) || !isValid(pl, N) || !isValid(pr, N)) return null;
        int leftrange = 0;
        int rightrange = 0;
        int val = postorder[pr];
        int i = il;
        for(i = il; i <= ir; i++){
            if(inorder[i] == val) break;
        }
        TreeNode root = new TreeNode(val);
        root.left = buildHelper(inorder, postorder, il, i-1, pl, pl+i-1-il);
        root.right = buildHelper(inorder, postorder, i+1, ir, pl+i-il, pr-1);
        return root;
    }
    
    public boolean isValid(int index, int length){
        if(index < 0 || index >= length) return false;
        return true;
    }
}
```