import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2017/6/30 0030.
 */
public class L78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, nums, 0, new ArrayList<Integer>());

        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int depth, ArrayList<Integer> temp) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = depth; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(result, nums, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
