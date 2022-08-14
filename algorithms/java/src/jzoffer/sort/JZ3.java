package jzoffer.sort;


/**
 * 数组中重复的数字
 * 位置重排
 * @author zzf
 * @date 2022/8/14 4:36 下午
 */
public class JZ3 {
    public int duplicate (int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            // 位置正确跳过
            if (numbers[i] == i) {
                continue;
            }
            // 判断是否重复
            if (numbers[i] == numbers[numbers[i]]) {
                return numbers[i];
            } else {
                // 交换位置
                swap(numbers, i, numbers[i]);
            }
        }
        return -1;
    }

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
