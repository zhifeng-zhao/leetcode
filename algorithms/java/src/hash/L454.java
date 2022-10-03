package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 *
 * @author zzf
 * @date 2022/10/3 2:32 下午
 */
public class L454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        for (int i : nums1) {
            for (int i1 : nums2) {
                temp = i + i1;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int i1 : nums4) {
                temp = i + i1;
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }
        return res;
    }
}
