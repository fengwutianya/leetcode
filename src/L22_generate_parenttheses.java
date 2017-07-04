import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuan on 2017/7/1 0001.
 */
public class L22_generate_parenttheses {
    public List<String> generateParenthesis(int n) {
        if (n < 0) return null;
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        char[] parentheses = new char[n*2];
        for (int i = 0; i < n; i++) {
            parentheses[i] = '(';
        }
        for (int i = n; i < n*2; i++) {
            parentheses[i] = ')';
        }

//        Arrays.sort(parentheses);

        backtrack(parentheses, 0, result);

        return result;
    }

    private void backtrack(char[] p, int current, List<String> result) {
        if (current == p.length) {
            if (isOK(p)) {
                String s = "";
                for (int i = 0; i < p.length; i++) {
                    s += p[i];
                }
                result.add(s);
            }
        } else {
            for (int i = current; i < p.length; i++) {
                if (i != current && p[i] == p[current]) continue;
                swap(p, i, current);
                char[] q = new char[p.length];
                for (int j = 0; j < p.length; j++) {
                    q[j] = p[j];
                }
                backtrack(q, current + 1, result);
                //swap(p, i, current);
            }
        }
    }

    private void swap(char[] p, int i, int k) {
        char temp = p[i];
        p[i] = p[k];
        p[k] = temp;
    }

    private boolean isOK(char[] p) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < p.length; i++) {
            if (p[i] == '(') stack.push('(');
            if (p[i] == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L22_generate_parenttheses().generateParenthesis(4).size());
    }
}
