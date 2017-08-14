/**
 * Created by xuan on 2017/7/8 0008.
 */
public class L300_Longest_increasing_subsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = 0;
        for (int i = 1; i < len; i++) {
            int max = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) max = Math.max(1+dp[j], max);
            }
            dp[i] = max;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
