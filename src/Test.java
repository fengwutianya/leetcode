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
//        Set<Integer> set = new HashSet<>();
//        System.out.println(set.add(1));
//        System.out.println(set.add(1));
        compare(new Student(), new Student());
        compare1(new Teacher(), new Teacher());
        List<Fruit> listOfFruit = new LinkedList<>();
        List<Apple> listOfApple = new LinkedList<>();
//        listOfFruit = listOfApple; wrong, so another mechanism is below
        List<? extends Fruit> list = new LinkedList<>();
        list = listOfApple;
//        list.add(new Apple());
//        list.add(new Fruit());
        //list 引用的对象可能是各种，因此不能添加，编译器报错
        //为了可以添加，? super Apple
        List<? super Apple> listSuper = new LinkedList<Fruit>();
        List<? super Apple> listSuper1 = new LinkedList<Object>();
        listSuper.add(new Apple());
    }
    static class Fruit{}
    static class Apple extends Fruit{}
    static class Orange extends Fruit{}
    private static class Teacher implements Comparable<Teacher> {
        @Override
        public int compareTo(Teacher o) {
            return 0;
        }
    }
    private static class Student implements Comparable {
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
    public static <T extends Comparable> int compare(T elem1, T elem2) {
        return elem1.compareTo(elem2);
    }

    public static <X extends Comparable<X>> int compare1(X elem1, X elem2) {
        return elem1.compareTo(elem2);
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
