/**
 * Created by xuan on 2017/7/8 0008.
 */
public class L97_Interleaving_string {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return backtrack(s1, s2, s3, 0, 0, 0);
    }

    private boolean backtrack(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length()) return true;
        else if (i == s1.length() || j == s2.length()) return s3.substring(k) == s1.substring(i) + s2.substring(j);
        char c1 = s1.charAt(i), c2 = s2.charAt(j), c3 = s3.charAt(k);
        if (c3 != c1 && c3 != c2) return false;
        else if (c3 == c1 && c3 != c2)
            return backtrack(s1, s2, s3, i+1, j, k+1);
        else if (c3 != c1 && c3 == c2)
            return backtrack(s1, s2, s3, i, j+1, k+1);
        else return backtrack(s1, s2, s3, i+1, j, k+1) ||
                    backtrack(s1, s2, s3, i, j+1, k+1);

    }
}
