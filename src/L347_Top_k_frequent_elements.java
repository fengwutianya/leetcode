import java.util.*;

/**
 * Created by xuan on 2017/7/12 0012.
 */
public class L347_Top_k_frequent_elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }
        return result;
    }
}
