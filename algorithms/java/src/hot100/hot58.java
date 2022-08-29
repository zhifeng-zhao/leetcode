package hot100;

/**
 * 58. 最后一个单词的长度
 *
 * @author zzf
 * @date 2022/8/29 6:24 下午
 */
public class hot58 {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        String s2 = s1[s1.length - 1];
        return s2.length();
    }
}
