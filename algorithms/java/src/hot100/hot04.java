package hot100;

import java.util.PriorityQueue;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @author zzf
 * @date 2022/8/18 1:43 下午
 */
public class hot04 {
    // 大堆顶
    PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // 小堆顶
    PriorityQueue<Integer> right = new PriorityQueue<>();
    int num = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        add(nums1);
        add(nums2);
        if (left.isEmpty() && right.isEmpty()) {
            return 0;
        }
        if (num % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return right.peek();
        }
    }

    private void add(int[] nums) {
        for (int i : nums) {
            if (num % 2 == 0) {
                left.add(i);
                right.add(left.poll());
            } else {
                right.add(i);
                left.add(right.poll());
            }
            num++;
        }
    }

    /**
     * 二分查找
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getK(nums1, 0, n - 1, nums2, 0, m - 1, left)
                + getK(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getK(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 确保nums1数量最少
        if (len1 > len2) {
            return getK(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getK(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getK(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        new hot04().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }
}
