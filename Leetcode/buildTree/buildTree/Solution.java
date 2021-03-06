package buildTree;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, 0, inorder.length);
    }
    TreeNode buildTree(int[] preorder, int[] inorder, int begin1, int begin2, int len){
    	if(len <= 0) return null;
        TreeNode root = new TreeNode(preorder[begin1]);
        //int rootIndex = binarySearch(inorder, root.val, begin2, begin2+len-1);
        int rootIndex = begin2;
        while(inorder[rootIndex] != root.val){
        	rootIndex++;
        }
        root.left = buildTree(preorder, inorder, begin1+1, begin2, rootIndex-begin2);
        root.right = buildTree(preorder, inorder, begin1+rootIndex+1-begin2, rootIndex+1, len+begin2-rootIndex-1);
        return root;
    }
    int binarySearch(int[] a, int x, int lo, int hi){
    	int mid = lo + (hi - lo) / 2;
    	while(lo <= hi){
    		if(a[mid] == x)
    			return mid;
    		if(a[mid] > x)
    			hi = mid - 1;
    		else
    			lo = mid + 1;
    		mid = lo + (hi - lo) / 2;
    	}
    	return -1;
    }
    public static void main(String[] args){
    	int[] preorder = {5,3,2,4,6,9};
    	int[] inorder = {2,3,4,5,6,9};
    	//int[] preorder = {};
    	//int[] inorder = {};
    	Solution sol = new Solution();
    	TreeNode root = sol.buildTree(preorder, inorder);
    }
}
