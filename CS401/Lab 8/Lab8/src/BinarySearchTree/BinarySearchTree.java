package BinarySearchTree;

import java.util.*;

public class BinarySearchTree {
	private TreeNode root = null;
	public BinarySearchTree()  {
		root = null;
	}
	public boolean add(Integer info) {
		TreeNode newNode = new TreeNode(info);
		root = add(root, newNode);
		return false;
	}
	public boolean contains(Integer info) {
		TreeNode temp = root;
		while(temp!=null) {
			if(temp.info==info)
				return true;
			if(temp.info > info) {
				temp = temp.get_left();
			}else {
				temp = temp.get_right();
			}
		}
		return false;
	}
	public TreeNode add(TreeNode parent, TreeNode newNode) {
		if(parent==null)
			return newNode;
		if(parent.info >= newNode.info) {
			parent.set_left(add(parent.get_left(), newNode));
		}else {
			parent.set_right(add(parent.get_right(), newNode));
		}
		return parent;
	}
	public void levelOrderPrint(List<TreeNode> level) {
		if(level.size()==0)
			return;
		List<TreeNode> nextLevel = new LinkedList<>();
		String res = "";
		for(TreeNode temp: level) {
			res += temp.info+" ";
			if(temp.get_left()!=null) nextLevel.add(temp.get_left());
			if(temp.get_right()!=null) nextLevel.add(temp.get_right());
		}
		System.out.println(res);
		levelOrderPrint(nextLevel);
	}
	public static void dfs(TreeNode root) {
		if(root==null)
			return;
		System.out.println(root.info);
		dfs(root.get_left());
		dfs(root.get_right());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst = Arrays.asList(new Integer[]{25,15,50,10,22,35,70,4,12,18,24,31,44,66,90});
		BinarySearchTree bst = new BinarySearchTree();
		for(Integer num: lst) {
			bst.add(num);
		}
		List<TreeNode> firstLevel = new LinkedList<>();
		firstLevel.add(bst.root);
		bst.levelOrderPrint(firstLevel);
		dfs(bst.root);
	}
}
