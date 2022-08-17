package jzoffer.simulation;

import java.util.regex.Pattern;

/**
 * 表示数值的字符串
 * @author zzf
 * @date 2022/8/17 10:01 下午
 */
public class JZ20 {
    public boolean isNumeric(String str) {
        // 正则表达式匹配
        String pattern = "(\\s)*[+-]?((\\d+(\\.(\\d+)?)?)|(\\.\\d+))([Ee][+-]?\\d+)?(\\s)*";
        // 根据匹配值返回
        return Pattern.matches(pattern, str);
    }
}
