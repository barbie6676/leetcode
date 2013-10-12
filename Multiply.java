/*43. muliply string*/

public String multiply(String num1, String num2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (num1.isEmpty() || num2.isEmpty()) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;
        
        int m = num1.length()<num2.length()?num1.length():num2.length();
        String s = num1.length()==m?num1:num2;
        String l = s.equals(num1)?num2:num1;
        
        String[] level = new String[m];
        
        for (int i = m-1; i>=0; i--) {
            int d1 = s.charAt(i)-'0';
            String ret = "";
            int overflow = 0;
            for (int j = l.length()-1;j>=0;j--) {
                int d2 = l.charAt(j)-'0';
                int n = d1*d2+overflow;
                overflow = n/10;
                ret = (char)(n%10+'0') +ret;
            }
            if (overflow > 0) ret = (char)(overflow+'0')+ret;
            for (int j = 0; j < (m-1-i);j++){
                ret += '0';
            }
            level[i] = ret;
        }
        
        int longest = level[0].length();
        for (int i = 1;i<m;i++) {
            int curr = level[i].length();
            for (int j = 0; j < longest-curr;j++) {
                level[i] = '0'+level[i];
            }
        }
        
        int overflow = 0;
        String muli = "";
        for (int j = longest -1; j >=0;j--) {
            int sum = overflow;
            for (int i = 0; i < m; i++){
                sum+= level[i].charAt(j)-'0';
            }
            overflow = sum/10;
            muli = (char)(sum%10+'0') + muli;
        }
        
        if (overflow>0) muli = (char)(overflow+'0') + muli;
        
        return muli;
    }
