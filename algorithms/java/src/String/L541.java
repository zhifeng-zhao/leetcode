package String;

/**
 *  541. 反转字符串 II
 *
 * @author zzf
 * @date 2022/10/4 11:49 上午
 */
public class L541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int l = i;
            int r = Math.min(chars.length - 1, l + k - 1);
            while (l < r) {
                chars[l] ^= chars[r];
                chars[r] ^= chars[l];
                chars[l] ^= chars[r];
                r--;
                l++;
            }

        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new L541().reverseStr("abcdefg", 2));
    }
}
