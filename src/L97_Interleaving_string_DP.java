/**
 * Created by xuan on 2017/7/11 0011.
 */
public class L97_Interleaving_string_DP {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        char c1, c2, c3;
        if (len1 + len2 != len3) return false;
        if (len1 == 0 || len2 == 0) return s3.equals(s1 + s2);
        boolean[][] result = new boolean[len1+1][len2+1];
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 && j == 0) result[i][j] = true;
                else if (i == 0) result[i][j] = s2.substring(0, j).equals(s3.substring(0, j));
                else if (j == 0) result[i][j] = s1.substring(0, i).equals(s3.substring(0, i));
                else {
                    c1 = s1.charAt(i-1); c2 = s2.charAt(j-1); c3 = s3.charAt(i+j-1);
                    if (c3 != c1 && c3 != c2) result[i][j] = false;
                    else if (c3 == c1 && c3 == c2) result[i][j] = result[i-1][j] || result[i][j-1];
                    else if (c3 == c1) result[i][j] = result[i-1][j];
                    else result[i][j] = result[i][j-1];
                    //if (!result[i][j]) return false;
                }
            }
        }
        return result[len1][len2];
    }
}
