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
	//Path sum 1
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return hasPSHelper(root, sum, 0);
    }
    
    public boolean hasPSHelper(TreeNode root, int sum, int curSum){
        if(root.left == null && root.right == null && curSum+root.val == sum) return true;
        if(root.left == null && root.right == null && curSum+root.val != sum) return false;
        
        boolean left = false;
        boolean right = false;
        if(root.left != null) left = hasPSHelper(root.left, sum, curSum+root.val);
        if(root.right != null) right = hasPSHelper(root.right, sum, curSum+root.val);
        
        return left || right;
    }

    //Path sum 2
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> ret = new ArrayList<>();
    	List<Integer> lst = new ArrayList<>();
    	if(root == null) return ret;
    	hasPSHelper(root, sum, 0, lst, ret);
    	return ret;
    }
    
    public void hasPSHelper(TreeNode root, int sum, int curSum, List<Integer> lst, List<List<Integer>> ret){
    	if(root.left == null && root.right == null && curSum+root.val == sum){
    		List<Integer> li = new ArrayList<>(lst);
    		li.add(root.val);
    		ret.add(li);
    	}
    	if(root.left == null && root.right == null && curSum+root.val != sum) return;

    	lst.add(root.val);
    	if(root.left != null) hasPSHelper(root.left, sum, curSum+root.val, lst, ret);
    	if(root.right != null) hasPSHelper(root.right, sum, curSum+root.val, lst, ret);
    	lst.remove(lst.size()-1);
    }
}
```