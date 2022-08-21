package hot100;

/**
 * 14. 最长公共前缀
 * 二分查找
 *
 * @author zzf
 * @date 2022/8/21 11:04 下午
 */
public class hot14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int left = 0, right = minLength;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            // 比较左边是否相等，相等比较右边
            if (match(strs, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return strs[0].substring(0, left);
    }

    private boolean match(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < str0.length(); j++) {
                if (str0.charAt(j) != strs[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
