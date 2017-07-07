import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuan on 2017/7/4 0004.
 */
public class L159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        char c;
        int left = 0;
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            while (map.size() > 2) {
                c = s.charAt(left);
                int times = map.get(c);
                if (times == 1) map.remove(c);
                else map.put(c, times-1);
                left++;
            }
            maxSize = Math.max(maxSize, i - left + 1);
        }
        return maxSize;
    }
}
