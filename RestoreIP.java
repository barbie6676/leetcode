/*93. Restore IP Addresses 
algorithm; recursion*/

 public ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> ret = new ArrayList<String>();
        restoreIPAddressAux("",s,4,ret);
        
        return ret;
    }
    
    public void restoreIPAddressAux(String exist,String rest, int n ,ArrayList<String> ret){
        
        if (n>4||n<1) return;
        
        if (rest.length()>3*n||rest.length()<n) return;
        
        if (n == 1) {
            if (validNum(rest)){
                ret.add(exist+rest);
            } 
            return;
        }
        
       for (int i = 1;i <= (3<rest.length()?3:rest.length()); i++){
           String curr = rest.substring(0,i);
           if (validNum(curr)) {
               restoreIPAddressAux(exist+curr+".",rest.substring(i),n-1,ret);
           }
       }
    }
    
    public boolean validNum(String s){
        if (s.length()>1&&s.charAt(0)=='0')return false;
        
        int n = 0;
        for (int i = 0; i < s.length() ; i++){
            n = n*10 + (s.charAt(i)-'0');
        }
        return n>=0&&n<=255;
    }
