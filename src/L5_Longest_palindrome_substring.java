/**
 * Created by xuan on 2017/7/5 0005.
 */
public class L5_Longest_palindrome_substring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int hi = 0, low = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[i-1][j+1]);
//                System.out.print(dp[i][j] + " ");
                if (dp[i][j] && i - j > hi - low) {
                    hi = i;
                    low = j;
                }
            }
//            System.out.println();
        }
        return s.substring(low, hi+1);
    }

    public static void main(String[] args) {
        String s = new L5_Longest_palindrome_substring().longestPalindrome("aaaabaaaae");
        System.out.println(s);
    }
}
