import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2017/6/30 0030.
 */
public class L131_palindrome_substring {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(s, new ArrayList<String>(), result, 0);

        return result;
    }

    private void backtrack(String s, List<String> temp, List<List<String>> result, int current) {
        if (current == s.length()) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = current; i < s.length(); i++) {
                if (isPalindrome(s, current, i)) {
                    temp.add(s.substring(current, i+1));
                    backtrack(s, temp, result, i+1);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int hi) {
        while (hi > low) {
            if (s.charAt(low++) != s.charAt(hi--)) return false;
        }
        return true;
    }


}
