import org.junit.Test;

/**
 * Created by xuan on 2017/4/6 0006.
 */
public class DepthOf2BTree {
    public int getDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        System.out.println(getDepth(null));
        System.out.println(getDepth(root));
    }
}
