/*13. roman to int*/

public int romanToInt(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //I 1 V5 X10 L50 C 100 D500 M1000
        
        // IV 4   MMXIII 2013  MMMCMXCIX 3999
        
        int ret = 0;

        
        int n = s.length();
        int i = 0;
   
        while(i<n){
            char c = s.charAt(i);
            int currUnit = letterToInt(c);
            int j = i+1;
            while(j<n&&s.charAt(j)==c){
                j++;
            }
            if (j==n||letterToInt(s.charAt(j))<currUnit){
                ret += (j-i)*currUnit;
            } else if (letterToInt(s.charAt(j))>currUnit){
                ret -= currUnit;
            }
            i = j;
        }
        
        
        return ret;
        
    }
    
    public int letterToInt(char c) {
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L' :return 50;
            case 'C':return 100;
            case 'D':return 500;
             default:return 1000;
        }
        //return -1;
    }
