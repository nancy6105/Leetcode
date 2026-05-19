class Solution {
    public int maxProfit(int[] prices) {
        int minimum_Price = prices[0];
        int profit = 0;

        for(int price : prices){
            profit = Math.max(profit,price-minimum_Price);
            minimum_Price = Math.min(minimum_Price,price);
        }
        return profit;
    }
}