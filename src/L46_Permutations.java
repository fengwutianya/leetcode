import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2017/6/30 0030.
 */
public class L46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<Integer>(), nums);

        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) continue;   //减枝，不是可行解
                temp.add(nums[i]);                      //处理当前结点
                backtrack(result, temp, nums);          //深度优先搜索
                temp.remove(temp.size()-1);             //回溯
            }
        }
    }
}
