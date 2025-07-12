class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int ans = 0;
        for(int i =0; i<prices.length; i++){
            int profit = prices[i] - buy;
            ans = Math.max(ans, profit);
            buy = Math.min(buy,prices[i]);
        }
        return ans;
    }
}