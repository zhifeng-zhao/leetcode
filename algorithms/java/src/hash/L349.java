package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * @author zzf
 * @date 2022/10/1 4:59 下午
 */
public class L349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> nums = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            nums.add(i);
        }
        for (int i : nums2) {
            if (nums.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
}
