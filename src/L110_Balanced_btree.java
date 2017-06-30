/**
 * Created by xuan on 2017/6/30 0030.
 */
public class L110_Balanced_btree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) < 2;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
