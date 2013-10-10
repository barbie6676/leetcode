/*69 Sqrt(x).
algorithm: Newton's method (http://en.wikipedia.org/wiki/Newton%27s_method)

to get the solution of f(x) = x^2 -a = 0;

we generate of a seriese of x_{n+1} = x_n - f(x_n)/f'(x_n)
                                = x_n - (x_n/2 - a/x_n/2) = (x_n+a/x_n)/2
                                
until the difference between x_{n+1} and x_n is very small.

*/

public class Solution {
    public int sqrt(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (x<=0) return 0;
        
        double x0 = x/2.0;
        double x1 = (x0+x/x0)/2.0;
        
        while (Math.abs(x0-x1)>0.00001) {
            x0 = x1;
            x1 = (x0+x/x0)/2.0;
        }
        
        return (int)x1;
    }
}
