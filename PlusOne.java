/*66. plus one.
*/

 public int[] plusOne(int[] digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = digits.length;
        if ( n == 0) {
            int[] ret = new int[1];
            ret[0] = 1;
            return ret;
        }
        
        int overflow = digits[n-1]==9?1:0;
        digits[n-1] = digits[n-1]==9?0:(digits[n-1]+1);
        for (int i = digits.length -2 ; i >=0 ; i--) {
            digits[i] += overflow;
            if (digits[i] == 10) {
                overflow = 1;
                digits[i] = 0;
            } else {
                overflow = 0;
            }
        }
        if (overflow == 1) {
            int[] ret = new int[n+1];
            ret[0] = 1;
            for (int i = 0; i < n ; i++){
                ret[i+1] = digits[i];
            }
            return ret;
        }
        
        return digits;
    }
