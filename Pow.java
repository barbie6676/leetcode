/*50. pow(x)*/

public double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n == 0) return 1.0;
        
        if (x == 0) {
            return n>0?0:-1;
        }
        
        if (n==1) return x;
        if (n==-1) return 1/x;
        
        double ret1 = pow(x,n/2);
        return ret1*ret1*pow(x,n%2);
    }
    
  
    
