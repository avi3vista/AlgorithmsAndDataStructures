public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public void insertNode(int val) {
        if(val < this.val) {
            if(this.left!=null) {
                this.left.insertNode(val);
            }
            else {
                this.left= new TreeNode(val);
            }
        }
        else {
            if(this.right!=null) {
                this.right.insertNode(val);
            }
            else {
                this.right= new TreeNode(val);
            }
        }
    }

    public void printTree() {
        if(this.left!=null) {
            this.left.printTree();
        }
        System.out.println(this.val);
        if(this.right!=null) {
            this.right.printTree();
        }
    }
}
