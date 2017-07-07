import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuan on 2017/7/6 0006.
 */
public class L290_Word_pattern {
//    public boolean wordPattern(String pattern, String str) {
//        char[] patterns = pattern.toCharArray();
//        String[] words = str.split(" ");
//        if (patterns.length != words.length) return false;
//        String[] match = new String[26];
//        for (int i = 0; i < words.length; i++) {
//            int pos = patterns[i] - 'a';
//            if (match[pos] == null) {
//                match[pos] = words[i];
//            } else if (match[pos].equals(words[i])) {
//                continue;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] words = str.split(" ");
        if (chars.length != words.length) return false;
        Map<Character, String> match1 = new HashMap<>();
        Map<String, Character> match2 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!match1.containsKey(chars[i]) && !match2.containsKey(words[i])) {
                match1.put(chars[i], words[i]);
                match2.put(words[i], chars[i]);
            } else if (match1.get(chars[i]) == null || !match1.get(chars[i]).equals(words[i]) || match2.get(words[i]) != chars[i])
                return false;
        }
        return true;
    }
}
