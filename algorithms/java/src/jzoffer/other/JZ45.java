package jzoffer.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * @author zzf
 * @date 2022/8/17 5:00 下午
 */
public class JZ45 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return "";
        }
        String[] num = new String[numbers.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = numbers[i] + "";
        }
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : num) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}
