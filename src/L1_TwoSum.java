import org.junit.Test;

import java.util.HashMap;

/**
 * Created by xuan on 16-10-23.
 */
public class L1_TwoSum {
    public int[] twoSum1(int[] nums, int target) {
        /* loop twice O(n^2)*/
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solutions");
    }

    public int[] twoSum2(int[] nums, int target) {
        /**
        * use hash map, but easy to understand
        * not as good as 3
        * */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int elem = target - nums[i];
            if (map.containsKey(elem) && map.get(elem) != i) {
                return new int[] {i, map.get(elem)};
            }
        }
        throw new IllegalArgumentException("no two sum solutions");
    }

    public int[] twoSum3(int[] nums, int target) {
        /**
         * I think it's the best
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int elem = target - nums[i];
            if (map.containsKey(elem)) {
                return new int[] {map.get(elem), i};    //这种情况下，返回值顺序很重要
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solutions");
    }

}
