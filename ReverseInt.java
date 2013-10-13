public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (x==0) return x;
        int sign = x>0?1:(-1);
        
        x = Math.abs(x);
        int highest = 1;
        int y = x;
        while (y/10!=0){
            highest ++;
            y /= 10;
        }
        int reverse = 0;
        
        y = x;
        int i = 0;
        while(highest >1) {
            int l = y/(int)Math.pow(10,highest-1);
            int r = y%10;
            reverse += r*(int)Math.pow(10,highest-1+i);
            reverse += l*(int)Math.pow(10,i);
             y %= (int)Math.pow(10,highest-1);
             y /= 10;
            highest -= 2;
            i++;
          
        }
        
        if (highest == 1)reverse += y*(int)Math.pow(10,i);
        
        return reverse*sign;
        
    }
