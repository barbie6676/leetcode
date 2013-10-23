//o(n) solution
//since all stations are on a circle, append two sets of stations together
// when the current gas fall below zero, start over from next one
// once finsish all the stations, return the index at the begining.

public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = gas.length;
        if (n == 0) return -1;
        int[] diff = new int[2*n-1];
        for (int i =0 ; i < n;i++){
            diff[i] = gas[i]-cost[i];
            if (i<n-1)diff[i+n] = gas[i]-cost[i];
        }
        
        int rd = 0;
        int left = 0;
        for (int i = 0; i < 2*n-1;i++){
            left += diff[i];
            if (left < 0) {
                left = 0;
                rd = 0;
            } else {
                rd++;
                if (rd == n) return i-n+1;
            }
        }
        return -1;
    }

//O(n^2) solustion
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
