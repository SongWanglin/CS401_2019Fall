package BinarySearchTree;

class TreeNode<E>  {
    private TreeNode<Integer> left,
                        right;
    public Integer info;

    public TreeNode(Integer info) { left = right = null; this.info = info; }
    public TreeNode<Integer> get_left()  { return left; }
    public TreeNode<Integer> get_right() { return right;}
    public void set_left(TreeNode<Integer> info) { this.left = info; }
    public void set_right(TreeNode<Integer> info) { this.right = info; }
 }