package LastCommonNode;
import java.util.*;

public class Solution {
	public TreeNode CommonParent(TreeNode root, TreeNode p1, TreeNode p2){
		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		getPath(root, p1, path1);
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
		getPath(root, p2, path2);		
		return getLastCommonNode(path1, path2);
	}
	boolean getPath(TreeNode root, TreeNode x, ArrayList<TreeNode> path){
		if(root != null){
			path.add(root);
			if(root.value == x.value)
				return true;
			else{
				if(getPath(root.left, x, path))
					return true;
				else{					
					if(getPath(root.right, x, path))
						return true;					
				}
				path.remove(path.size()-1);
			}
		}		
		return false;
	}
	TreeNode getLastCommonNode(ArrayList<TreeNode> list1, ArrayList<TreeNode> list2){
		if(list1 != null && list2 != null){
			int len = list1.size() > list2.size() ? list2.size() : list1.size();
			for(int i = 0; i < len; i++){
				if(i > 0 && list1.get(i) != list2.get(i))
					return list1.get(i-1);
			}
		}
		return null;
	}
	public static void main(String[] args){		
		Integer[] a = {1,2,5,3,4,null,6};
		//Integer[] a = {};
		//Integer[] a = {1,null,2,3};
		TreeNode root = TreeNode.buildTreeFromArray(a);//error
		TreeNode p1 = new TreeNode(4);
		TreeNode p2 = new TreeNode(3);
		Solution sol = new Solution();
		TreeNode x = sol.CommonParent(root, p1, p2);
		System.out.println(x.value);
	}
}
