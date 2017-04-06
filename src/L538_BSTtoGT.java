/**
 * 真不容易啊，想通了就五行代码
 * Created by xuan on 2017/4/6 0006.
 */
public class L538_BSTtoGT {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        change(root);
        return root;
    }

    public void change(TreeNode root) {
        if (root == null) return;
        change(root.right);
        root.val += sum;
        sum = root.val;
        change(root.left);
    }
}
