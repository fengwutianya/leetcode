/**
 * Created by xuan on 2017/7/8 0008.
 */
public class I77_LCS {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int lenA = A.length();
        int lenB = B.length();
        if (lenA == 0 || lenB == 0) return 0;
        int maxLCS = 0;
        int[][] dp = new int[lenA][lenB];
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    if (i == 0 || j == 0) dp[i][j] = 0;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[lenA-1][lenB-1];
    }
}
