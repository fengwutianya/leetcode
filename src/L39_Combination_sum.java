import java.util.ArrayList;
import java.util.List;

/**
 * 本质是组合问题，注意造成接的重复性
 * Created by xuan on 2017/6/30 0030.
 */
public class L39_Combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<Integer>(), target, candidates, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int target, int[] candidates, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(result, temp, target-candidates[i], candidates, i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
