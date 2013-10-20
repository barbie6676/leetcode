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
