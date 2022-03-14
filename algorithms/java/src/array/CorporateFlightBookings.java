package array;

/**
 * 1109. 航班预订统计
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]
 * 意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 * 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
 * 思路：差分数组
 * @author zzf
 * @date 2022/3/14 8:14 下午
 */
public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            answer[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                answer[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i-1];
        }
        return answer;
    }
}
