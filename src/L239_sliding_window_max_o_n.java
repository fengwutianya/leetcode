import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by xuan on 2017/6/28 0028.
 */
public class L239_sliding_window_max_o_n {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
//        Deque<Integer> deque = new LinkedList<>();
//        Deque<Integer> deque = new ArrayBlockingQueue<Integer>();
        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];    //0,...nums.length - k
        int result_i = 0;

        for (int i = 0; i < nums.length; i++) {
            //出了当前窗口[i-k+1, i]，并且deque里面存储的序号因为后插的关系，是递减的
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            //后插前进时，去掉叫小数字的关系，deque里面序号对应的数组元素是递增的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                // 0...k-1 凑到k个，开始有一个最大值
                result[result_i++] = nums[deque.peek()];
            }
        }
        return result;
    }
}
