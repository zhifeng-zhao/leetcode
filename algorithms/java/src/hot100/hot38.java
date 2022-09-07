package hot100;

/**
 * 38. 外观数列
 *
 * @author zzf
 * @date 2022/9/8 12:59 上午
 */
public class hot38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int count = 0;
            while (count < str.length()) {
                while (count < str.length() && str.charAt(start) == str.charAt(count)) {
                    count++;
                }
                sb.append(count - start).append(str.charAt(start));
                start = count;
            }
            str = sb.toString();
        }
        return str;
    }
}
