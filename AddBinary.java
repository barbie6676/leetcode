/*67. add binary
algorithm: record overflow, and i remember some question is very similar to this one.
*/

public String addBinary(String a, String b) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int na = a.length();
        int nb = b.length();
        
        if (na == 0) return b;
        if (nb == 0) return a;
        
        String sum = "";
         
        int i = na-1;
        int j = nb-1;
        int overflow = 0;
        while (i>=0&&j>=0) {
            int n = a.charAt(i--)-'0' + (b.charAt(j--)-'0') +overflow;
            if (n > 1) {
                overflow = 1;
                sum =(char)('0'+n-2)+sum;
            } else {
                overflow = 0;
                sum = (char)('0'+n)+sum;
            }
        }
        
        int k = i>=0?i:j;
        String c = i>=0?a:b;
        while (k>=0){
            int n = c.charAt(k--)-'0'  +overflow;
            if (n > 1) {
                overflow = 1;
                sum =(char)('0'+n-2)+sum;
            } else {
                overflow = 0;
                sum = (char)('0'+n)+sum;
            }
        }
        
        if (overflow == 1) {
            sum='1'+sum;
        }
        
        return sum;
    }
