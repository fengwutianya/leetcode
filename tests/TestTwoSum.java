import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xuan on 16-10-23.
 */
public class TestTwoSum {
    L1_TwoSum twoSum = new L1_TwoSum();
    @Test
    public void testTwoSum1() {
        Assert.assertArrayEquals("wrong", new int[]{1, 2}, twoSum.twoSum1(new int[]{1, 2, 4}, 6));
    }

    @Test
    public void testTwoSum2() {
        Assert.assertArrayEquals("wrong", new int[]{1, 2}, twoSum.twoSum2(new int[]{1, 2, 4}, 6));
    }

    @Test
    public void testTwoSum3() {
        Assert.assertArrayEquals("wrong", new int[]{1, 2}, twoSum.twoSum3(new int[]{1, 2, 4}, 6));
        Assert.assertArrayEquals("wrong", new int[]{1, 2}, twoSum.twoSum3(new int[]{1, 4, 2}, 6));
    }
}
