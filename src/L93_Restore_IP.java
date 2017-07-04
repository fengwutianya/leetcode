import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2017/7/1 0001.
 */
public class L93_Restore_IP {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<String>(), result);

        return result;
    }

    void backtrack(String s, int start, List<String> temp, List<String> result) {
        if (temp.size() == 4 && start == s.length()) {
            result.add(temp.get(0) + "." + temp.get(1) + "." + temp.get(2) + "." + temp.get(3));
        } else if (temp.size() == 4 || start == s.length()){
            return;
        } else {
            for (int i = start; i < start + 3 && i < s.length(); i++) { //这里忘了检查i出界问题，从结果可以看出来
                if (isPartOfIP(s, start, i+1)) {
                    temp.add(s.substring(start, i+1));
                    backtrack(s, i+1, temp, result);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

    private boolean isPartOfIP(String s, int start, int end) {
        return (s.charAt(start) != '0' || (s.charAt(start) == '0' && end - start == 1)) &&
                (Integer.parseInt(s.substring(start, end)) < 256);
    }
}
