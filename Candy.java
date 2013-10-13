public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = ratings.length;
        if (n <=1) return n;
        int[] candy = new int[n];
        
        for (int i = 1; i < n ; i++){
            if (ratings[i]>ratings[i-1]) candy[i] = candy[i-1]+1;
        }
        
         for (int i = n-2; i >=0 ; i--){
            if (ratings[i]>ratings[i+1]) {
                if (candy[i]<=candy[i+1]) candy[i] = candy[i+1]+1;
            }
        }
        
        int total = n;
        for (int i = 0; i < n ; i++){
            total += candy[i];
        }
        
        return total;
    }
