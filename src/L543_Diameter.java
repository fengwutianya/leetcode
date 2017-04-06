/**
 * 最长距离 每一个节点都有一个左子树右子树最长距离
 * 即为左子树右子树高度和，从所有节点的最长距离挑出最大的，
 * 为了递归函数里面不多家变量，设置了全局变量来保持这个最大值
 * 注意的是根节点的最大距离不一定是整棵树的最大距离，反例很好构造
 * Created by xuan on 2017/4/6 0006.
 */
public class L543_Diameter {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int maxleft = getDepth(root.left);
        int maxright = getDepth(root.right);
        max = Math.max(max, maxleft + maxright);
        return Math.max(maxleft, maxright) + 1;
    }
}
