package jzoffer.dp;

/**
 * 买卖股票的最好时机(一)
 * 贪心思想
 *
 * @author zzf
 * @date 2022/8/16 3:06 上午
 */
public class JZ63 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length == 0) {
            return res;
        }
        // 最低价格
        int min = prices[0];
        for (int i = 1; i <= prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
