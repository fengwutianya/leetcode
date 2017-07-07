import java.util.*;

/**
 * Created by xuan on 2017/6/28 0028.
 */
public class Test {
    public static void main(String[] args) {
//        BitSet bitSet = new BitSet(26);
//        System.out.println(bitSet.get(5));
//        int i = 1000;
//        Integer x = i;
//        Integer y = i;
//        System.out.println(x == y);
//        System.out.println(x.equals(y));
//        char c = 1000;
//        Character p = c;
//        Character q = c;
//        System.out.println(p == q);
//        System.out.println(p.equals(q));
//        String s1 = "xyz";
//        String s2 = "xyz";
//        System.out.println(s1 == s2);
//        String s3 = new String("xyz");
//        String s4 = new String("xyz");
//        System.out.println(s2 == s3);
//        System.out.println(s3 == s4);
//        s3 = s3.intern();
//        System.out.println(s2 == s3);
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("hello", 0);
//        int i = map.put("hello", 1);
//        System.out.println(i);
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = (findMax(nums, i, k));
        }
        return result;
    }

    public int findMax(int[] nums, int start, int length) {
        int max = nums[start];
        for (int i = start; i < start + length; i++) {
            max = max > nums[i] ? max : nums[i];
        }
        return max;
    }
}
