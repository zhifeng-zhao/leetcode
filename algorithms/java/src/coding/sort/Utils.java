package coding.sort;

/**
 * @author zzf
 * @date 2022/10/16 8:20 下午
 */
public class Utils {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
