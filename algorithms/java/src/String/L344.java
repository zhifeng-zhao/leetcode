package String;

/**
 * 344. 反转字符串
 * @author zzf
 * @date 2022/10/4 11:47 上午
 */
public class L344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
