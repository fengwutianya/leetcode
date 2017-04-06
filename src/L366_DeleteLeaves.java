import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by xuan on 2017/4/6 0006.
 */
public class L366_DeleteLeaves {
    public void deleteLeaves(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        if (isLeave(root)) {
            list.add(root.val);
            return;
        }
        if (root.left != null) {
            if (isLeave(root.left)) {
                list.add(root.left.val);
                root.left = null;
            } else deleteLeaves(root.left, list);
        }
        if (root.right != null) {
            if (isLeave(root.right)) {
                list.add(root.right.val);
                root.right = null;
            } else deleteLeaves(root.right, list);
        }
    }

    public boolean isLeave(TreeNode root) {
        return root.left == null && root.right == null;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        while (!isLeave(root)) {
            ArrayList<Integer> list = new ArrayList<>();
            deleteLeaves(root, list);

            lists.add(list);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        lists.add(list);
        root = null;
        System.out.println(lists);
    }
}
