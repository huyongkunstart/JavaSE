package 数组;

/**
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author hu
 * @create 2021-12-27 14:29
 * 示例
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3
 */
public class index3 {
    public static void main(String[] args) {
        int[] prices = {7,6,5,4,3,2};
        System.out.println(maxProfit(prices));
    }
    //贪心算法思想解决
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length <2){
            return 0;
        }

        int total = 0,index = 0,length = prices.length;
        while (index<length){
            //如果股票下跌就一直找，直到找到股票开始上涨为止
            while (index < length-1 && prices[index]>= prices[index+1]){
                index++;
            }
            //股票上涨开始的值，也就是这段时间上涨的最小值
            int min = prices[index];
            //一直找到股票上涨的最大值为止
            while (index < length-1 && prices[index] <= prices[index+1]){
                index++;
            }
            //计算这段上涨时间的差值，然后累加
            total+=prices[index++]-min;
        }
        return total;

    }
}
