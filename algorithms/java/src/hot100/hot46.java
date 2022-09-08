package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author zzf
 * @date 2022/9/9 3:11 上午
 */
public class hot46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] use;

    public List<List<Integer>> permute(int[] nums) {
        use = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i]) {
                continue;
            }
            track.add(nums[i]);
            use[i] = true;
            backtrack(nums);
            track.removeLast();
            use[i] = false;
        }
    }

    public static void main(String[] args) {
        new hot46().permute(new int[]{1, 2, 3});
    }
}
