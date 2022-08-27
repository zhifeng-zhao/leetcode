package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @author zzf
 * @date 2022/8/27 5:14 下午
 */
public class hot40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidate, int start, int target) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidate.length; i++) {
            if (i > start && candidate[i] == candidate[i - 1]) {
                continue;
            }
            sum += candidate[i];
            track.add(candidate[i]);
            backtrack(candidate, i + 1, target);
            sum -= candidate[i];
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        new hot40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
