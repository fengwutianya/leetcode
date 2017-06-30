/**
 * Created by xuan on 2017/6/28 0028.
 */
public class L239_sliding_window_max_o_kn {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = (findMax(nums, i, k));
        }
        return result;
    }

    public int findMax(int[] nums, int start, int length) {
        int max = nums[start];
        for (int i = start; i < start + length; i++) {
            max = max > nums[i] ? max : nums[i];
        }
        return max;
    }
}
