package jzoffer.simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌顺子
 * @author zzf
 * @date 2022/8/16 5:13 下午
 */
public class JZ61 {
    public boolean IsContinuous(int [] numbers) {
        Set<Integer> set = new HashSet<>();
        //设置顺子上下界
        int max = 0, min = 13;
        for (int number : numbers) {
            if (number == 0) {
                continue;
            }
            if (set.contains(number)) {
                return false;
            }
            set.add(number);
            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        return max - min < 5;
    }
}
