class Solution {
    public int maxProfit(int[] prices) {
        int currentProfit = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int difference = prices[i] - prices[i - 1];

            currentProfit += difference;

            // If profit becomes negative, reset it
            if (currentProfit < 0) {
                currentProfit = 0;
            }

            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}