package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zzf
 * @date 2022/9/9 3:26 上午
 */
public class hot47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] use;

    public List<List<Integer>> permuteUnique(int[] nums) {
        use = new boolean[nums.length];
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            use[i] = true;
            backtrack(nums);
            track.removeLast();
            use[i] = false;
        }
    }
}
