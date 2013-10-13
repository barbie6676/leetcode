public int atoi(String str) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int ret = 0;
        boolean space = true;
        
        //boolean overflow =false;
        boolean neg = false;
        int nextMax = 214748364;
        int validbit = 0;
        int i = 0;
        while(i < str.length()){
            char c = str.charAt(i);
            
            if (space) {
                if (c==' '){
                    ;
                } else {
                    space = false;
                    if (c>='0'&&c<='9'){
                        int d = c-'0';
                        ret = ret*10+d;
                        validbit ++;
                    } else if (c!='+'&&c!='-'){
                        return 0; //invaid numeric string
                    } else {
                        if (c == '-') neg = true;
                        if (i == str.length()-1||str.charAt(i+1)<'0'||str.charAt(i+1)>'9')
                            return 0;
                    }
                } 
            } else { // not space before
                if (c>='0'&&c<='9'){
                    int d = c-'0';
                    
                    if (validbit < 9) {
                        ret = ret*10 + d;
                        validbit++;
                    } else {
                        if (validbit > 9||(validbit==9&&ret > nextMax)){
                             return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
                        } else if (ret == nextMax&&(neg&&d>8||!neg&&d>7)){
                            return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
                        } else {
                            ret = ret*10 + d;
                            validbit++;
                        } 
                    } 
                } else {
                    break;
                }
            }
            
            i++;
        }
        
        return ret*(neg?(-1):1);
    }
