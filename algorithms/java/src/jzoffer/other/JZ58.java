package jzoffer.other;

/**
 * 左旋转字符串
 *
 * @author zzf
 * @date 2022/8/17 8:07 下午
 */
public class JZ58 {
    public String LeftRotateString(String str, int n) {
        if (str.isEmpty()) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            char temp = buffer.charAt(0);
            buffer.deleteCharAt(0);
            buffer.append(temp);
        }
        return buffer.toString();
    }

    public String LeftRotateString2(String str, int n) {
        //取余，因为每次长度为n的旋转数组相当于没有变化
        if (str.isEmpty()) {
            return "";
        }
        int m = str.length();
        n = n % m;
        //第一次逆转全部元素
        char[] s = str.toCharArray();
        reverse(s, 0, m - 1);
        //第二次只逆转开头m个
        reverse(s, 0, m - n - 1);
        //第三次只逆转结尾m个
        reverse(s, m - n, m - 1);
        return new String(s);
    }

    //反转函数
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            swap(s, start++, end--);
        }
    }

    //交换函数
    private void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        // 反转前n个
        reverseString(sb, 0, n - 1);
        // 反转n后的字符串
        reverseString(sb, n, sb.length() - 1);
        // 反转字符串
        reverseString(sb, 0, sb.length() - 1);
        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
