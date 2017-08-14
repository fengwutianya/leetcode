/**
 * Created by xuan on 2017/7/7 0007.
 */
public class L28_Implement_strstr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) j = next[j];
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            if (j == needle.length()) return i-j+1;
        }
        return -1;
    }

    private int[] getNext(String needle) {
        int len = needle.length();
        int[] next = new int[len+1];
        int j = 0;
        //next[0] = next[1] = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) j = next[j];
            if (needle.charAt(i) == needle.charAt(j)) j++;
            next[i+1] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        new L28_Implement_strstr().strStr("Mississippi", "issip");
    }
}
