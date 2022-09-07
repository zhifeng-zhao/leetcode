package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * @author zzf
 * @date 2022/9/8 2:04 上午
 */
public class hot39 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            ans.add(new LinkedList<>(track));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            target -= candidates[i];
            backtrack(candidates, target, i);
            target += candidates[i];
            track.removeLast();
        }
    }
}
