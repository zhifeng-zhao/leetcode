package jzoffer.other;

import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 * @author zzf
 * @date 2022/8/17 4:38 下午
 */
public class JZ39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = array.length / 2;
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > index) {
                return i;
            }
        }
        return 0;
    }
}
