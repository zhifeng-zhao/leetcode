package hash;

/**
 * 242. 有效的字母异位词
 *
 * @author zzf
 * @date 2022/10/1 4:43 下午
 */
public class L242 {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a']--;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new L242().isAnagram("rat", "cat");
    }
}
