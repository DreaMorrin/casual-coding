/*
 * given a list of positive integer representing the price of stock, max the profit by buy at lowest and sell at highest.
 */
public class OneBuyOneSellStockProblem {
	
	static int dp(int[] stocks) {
		int n = stocks.length;
		if (n == 0) { return 0; } 
		
		int[] profits = new int[n];
		int maxProfit = 0;
		
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				profits[i] = 0;
			}
			else {
				int profit = stocks[i] - stocks[i - 1];
				profits[i] = Math.max(profits[i - 1] + profit, profit);
				maxProfit = Math.max(maxProfit, profits[i]);
			}
		}
		
		return maxProfit;
	}
	
	static int twoPointers(int[] stocks) {
		int n = stocks.length;
		if (n == 0) { return 0; }
		
		int buyPrice = 0;
		int sellPrice = 0;
		int maxProfit = 0;
		
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				buyPrice = stocks[i];
				sellPrice = stocks[i];
			}
			else {
				if (stocks[i] < buyPrice) {
					buyPrice = stocks[i];
				}
				sellPrice = stocks[i];
				
				maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] case_1 = {7, 1, 5, 3, 6, 4};
		System.out.println(dp(case_1));
		System.out.println(twoPointers(case_1));
		
		int[] case_2 = {7, 6, 4, 3, 1};
		System.out.println(dp(case_2));
		System.out.println(twoPointers(case_2));
	}

}
