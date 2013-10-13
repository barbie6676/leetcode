public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = gas.length;
        
        if (n ==0) return -1;
        if (n ==1) return gas[0]>=cost[0]?0:-1;
        
        int[] left = new int[n];
        for (int i = 0; i < n ; i++) {
            left[i] = gas[i]-cost[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (left[i] < 0) continue;
            int have = left[i];
            int k =1;
            for (; k < n;k++) {
                have += left[(i+k)%n];
                if (have<0) break;
            }
            if (k == n) return i;
        }
        
        return -1;
    }
