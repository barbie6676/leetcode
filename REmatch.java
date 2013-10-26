// a very difficult one


public boolean isMatch(String s, String p) {
   
        // Start typing your Java solution below
        // DO NOT write main() function
    int sl = s.length();
	int pl = p.length();
	if (pl == 0) return sl ==0;
	
	
	if (pl == 1) {
		if (p.charAt(0) == '.') {
			return sl == 1;
		} else if (p.charAt(0) == '*') {
			return sl==0;
		} else {
			return sl == 1&&p.charAt(0)==s.charAt(0);
		}
	}
	
    int si = 0;
	int  pi = 0;
	int lastmatch = -1;
	char curr = ' ';
	
	while (si < sl&&pi <pl) {
		curr = p.charAt(pi);
		 //current != '*' 
		if (pi<pl-1&&p.charAt(pi+1)=='*'){ // current is followed by a star
			if (p.charAt(lastmatch+1)!='*') {
				if (curr=='.'||curr==s.charAt(si))lastmatch = pi;						
			} else {
				char last = p.charAt(lastmatch);
				int ssi = si;
				if (last!='.') {
					if (curr != last&&curr!='.') {
						while (ssi<sl&&s.charAt(ssi)==last) {
							ssi++;
						}
						if (ssi<sl&&s.charAt(ssi)==curr) {
							lastmatch = pi;
							si = ssi;
						}																
					} else if (curr == '.') {
					    lastmatch = pi;								
					} 
				} 
			}
			pi+=2;
			if (pi == pl) {
				if (lastmatch == -1) return false;
				if ((pi-lastmatch)%2==0&&p.charAt(lastmatch)=='.') return true;
				while (si<sl&&(p.charAt(lastmatch)==s.charAt(si))) {
					si++;
				}
				return si == sl;
			}
		} else {//has to match a single char
			if (p.charAt(lastmatch+1)!='*') {
				if (curr!='.'&&curr!=s.charAt(si)) return false;
				lastmatch = pi;
			} else {//has non matched pattern before, non-aggressive.
				char last = p.charAt(lastmatch);
				if (last!='.') {
					if (curr != last&&curr!='.') {
						while (si<sl&&s.charAt(si)==last) {
							si++;
						}
						if (si==sl||s.charAt(si)!=curr) return false;
						lastmatch = pi;
					} else if (curr == '.') {
						while(si<sl&&s.charAt(si)==last){
							if (isMatch(s.substring(si),p.substring(pi))) return true;
							si++;
						}
						if (si == sl) return false;
						lastmatch = pi;
					} else if (curr == last){								
						while(si<sl&&s.charAt(si)==curr){
							if (isMatch(s.substring(si),p.substring(pi))) return true;
							si++;
						}
						return false;
					}
				} else { //last ==. follow by a *
					while(si<sl){
						if (isMatch(s.substring(si),p.substring(pi))) return true;
						si++;
					}
					return false;							
				}						
			}
			pi++;
			si++;
		}					
	}
	if (si==sl&&pi==pl) return true;
	if (si == sl) {			
		while (pi+1<pl){
			if (p.charAt(pi+1)!='*') return false;
			pi += 2;
		}
		if (pi == pl-1) return false;
		return true;
	}
	return false;
}


// a DP approach, very clean and nice copy from 
// http://www.mitbbs.com/article_t/JobHunting/32528059.html

public boolean isMatch(String s, String p) {

        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for(int i = 1; i <= m; i++){
            match[i][0] = false;
        }
        for(int j = 1; j <= n; j++){
            if(p.charAt(j - 1) == '*'){
                match[0][j] = match[0][j - 2];
            }else{
                match[0][j] = false;
            }
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j - 1) == '*'){
                    match[i][j] |= match[i][j - 2];
                    if(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2)== '.'){
                        match[i][j] |= match[i - 1][j];
                    }
                }else{
                    match[i][j] = ((s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && match[i - 1][j - 1]);
                }
            }
        }
        
        return match[m][n];
    }
    
    // arecursion approach

public static boolean easyREmatch(String p, String s) {
		 int pn = p.length();
		 int sn = s.length();
		 
		 int si = 0; 
		 int pi = 0;
		 while (si <  sn&&pi<pn) {
			 char c = p.charAt(pi);
			 if(pi+1<pn&&p.charAt(pi+1)=='*'){
				 if (c==s.charAt(si)){
					 if (easyREmatch(p.substring(pi+2),s.substring(si+1))) return true;
					 si++;
				 }
				 pi += 2;
				 
			 } else {
				 if (c!='.'||s.charAt(si)!=c) return false;
				 si++;
				 pi++;
			 }
		 }
		 
		 if (si == sn) {
			 if (pi+1<pn){
				if (p.charAt(pi+1)!='*') return false;
				pi += 2;
			 }
			 if (pi +1 == pn) return false;
			 return true;
		 }
		 
		 return true;
	 }

 public boolean isMatchWildDP(String s, String p) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        //DP.
	        
	int m = s.length();
	int n = p.length();
	boolean[] pstart = new boolean[n+1];
	boolean[][] match = new boolean[2][m];
	
	pstart[0] = true;
	for (int i = 0; i<m; i++)
	    match[0][i] = false;
	    
	for (int j = 1; j <=n ;j++)
	    pstart[j] = p.charAt(j-1)=='*';
	
	//Methods me = new Methods();
	int up = 1;
	for (int j = up; j <=n ; j++) {
	    for (int i = 0; i < m; i++) {
	        char c = p.charAt(j-1);
	        if (c == '*') {
	            if (i==0){
	            	if (pstart[j-1]){
	            		match[1][i] = true;
	            		int k = i;
	                    	while (++k<m) match[1][k]|= match[1][k-1];
	                    	up = j+1;
	            	} else match[1][i] |= pstart[j];
	            } else {
	            	if (match[0][i-1]){
	            		match[1][i] = true;
	            		int k = i;
	                    	while (++k<m) match[1][k]|= match[1][k-1];
	                    	up = j+1;
	            	} else match[1][i] |= match[1][i-1];
	            }	                    		                    
	        } else {
	        	boolean t = (c == s.charAt(i)||c =='?');
	            if (i == 0) match[1][i] = t&&pstart[j-1];
	            else match[1][i] = t&&match[0][i-1];
	        }
	    }
	    match[0] = match[1].clone();
	}
	//me.printBoolMatrix(match);
	return match[1][m-1];
}
