/*121. Best Time to Buy and Sell Stock I
  algorithm: Iteration, update min and max difference.
  
  122. Best Time to Buy and Sell Stock II
  algorithm: Iteration, each time update start, if the current price is higher than start price, sell it, add to profit.
  
  123. Best Time to Buy and Sell Stock III
  algorithm: DP, first allocate a new array of n, store the max profit end with this index.  then walk from back, find the max start with this index, combine with the profit already exists. 
  update the global max.
  
  */

 public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = prices.length;
        
        if (n<=1) return 0;
        
        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (min > prices[i]) min = prices[i];
            if (prices[i]-min > profit) profit = prices[i]- min;
        }
        
        return profit;
    }
	
	public int maxProfitII(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int n = prices.length;
        if (n<=1) return 0;
        int start = 0;
        int profit = 0;
        for (int i = 0; i<n ; i++) {
            if (prices[i]>prices[start]) {
                profit += (prices[i]-prices[start]);
               
            }
             start = i;
        }
        
        return profit;
        
    }
	
	public int maxProfitIII(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = prices.length;
        
        if (n<=1) return 0;
        
        int[] MaxEndWith = new int[n];
        MaxEndWith[0] = 0;
        int lowest = prices[0];
        int max = 0;
        for (int i = 1; i < n ; i++) {
            int diff = prices[i] - lowest;
            if (diff > max) max = diff;
            
            MaxEndWith[i] = max;
            if (prices[i] < lowest) lowest = prices[i];
        }
        
        int ret = 0;
      
        int highest = prices[n-1];
        max = 0;
        for (int i = n-2; i >= 0 ; i--) {
            int diff = highest - prices[i] ;
            if (diff > max) max = diff;
            
            if (max + MaxEndWith[i] > ret) ret = max+MaxEndWith[i];
            if (prices[i] > highest) highest = prices[i];
        }
        
        return ret;
    }
