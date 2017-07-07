import java.util.BitSet;

/**
 * Created by xuan on 2017/7/5 0005.
 */
public class L3_Longest_substring_without_repeating_character {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0;

        BitSet bitSet = new BitSet(260);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (bitSet.get(c)) {
                bitSet.set(s.charAt(left++), false);
            }
            bitSet.set(c, true);
            length = Math.max(length, i - left + 1);
        }

        return length;
    }

    public static void main(String[] args) {
        int length = new L3_Longest_substring_without_repeating_character().lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }
}
