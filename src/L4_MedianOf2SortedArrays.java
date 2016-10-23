/**
 * Created by xuan on 16-10-23.
 */
public class L4_MedianOf2SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len_combine = nums1.length + nums2.length;
        int[] combine = new int[len_combine];
        int now1 = 0, now2 = 0;
        int len = 0;
        while (now1 < nums1.length && now2 < nums2.length) {
            if (nums1[now1] < nums2[now2]) combine[len++] = nums1[now1++];
            else combine[len++] = nums2[now2++];
        }
        for (int i = now1; i < nums1.length; i++) {
            combine[len++] = nums1[i];
        }
        for (int i = now2; i < nums2.length; i++) {
            combine[len++] = nums2[i];
        }
        return len_combine % 2 == 1 ? combine[(len_combine-1)/2] : (combine[(len_combine-1)/2] + combine[len_combine/2]) / 2.0;
    }
}
