1. Binary Tree Traversal: Preorder, Inorder, Postorder, Level Order, Level Order II, Vertical Order

```java
class Solution{
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x; }
	}

	public void preorder(TreeNode root){
		if(root == null) return;

		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}

	public void inorder(TreeNode root){
		if(root == null) return;

		inorder(left);
		System.out.println(root.val);
		inorder(right);
	}

	public void postorder(TreeNode root){
		if(root == null) return;

		postorder(root.left);
		postorder(root.right);
		System.out.println(root.val);
	}

	public void  levelOrder(TreeNode root){
		if(root == null) return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root); 
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode curNode = queue.pop();
				System.out.println(curNode.val);
				if(curNode.left != null) queue.add(curNode.left);
				if(curNode.right != null) queue.add(curNode.right);
			}

		}
	}

	public void verticalOrder(TreeNode root){
		if(root == null) return;
		TreeMap<Integer, List<TreeNode>> map = new TreeMap<>(); 
		VOhelper(map, root, 0);
		for(int k: map.keySet()){
			List<TreeNode> lst = map.getOrDefault(k, new ArrayList<>());
			for(TreeNode n : lst){
				System.out.println(n.val);
			}
		}
	}

	private void VOhelper(HashMap<Integer, List<TreeNode>> map, TreeNode root, int degree){
		List<TreeNode> tList = map.getOrDefault(degree, new ArrayList<>());
		tList.add(root);
		map.put(degree, tList);
		if(root.left != null) VOhelper(map, root.left, degree-1);
		if(root.right != null) VOhelper(map, root.right, degree+1);
	}


}

```