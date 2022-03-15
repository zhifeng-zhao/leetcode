package array;

/**
 * 1094. 拼车
 * 假设你是一位顺风车司机，车上最初有capacity个空座位可以用来载客。由于道路的限制，车只能向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
 *
 * 这儿有一份乘客行程计划表trips[][]，其中trips[i] = [num_passengers, start_location, end_location]包含了第 i 组乘客的行程信息：
 *
 * 必须接送的乘客数量；
 * 乘客的上车地点；
 * 以及乘客的下车地点。
 *
 * 这些给出的地点位置是从你的初始出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
 *
 * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回true，否则请返回 false）
 *
 * 思路：把乘客上下车理解为数组区间加减，数组里的数不大于容量时返回true
 * @author zzf
 * @date 2022/3/15 10:51 下午
 */
public class Carpool {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        for (int[] trip : trips) {
            nums[trip[1]] += trip[0];
            nums[trip[2]] -= trip[0];
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (nums[i - 1] > capacity) {
                return false;
            }
        }
        return true;
    }
}
