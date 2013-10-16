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
			}else {
			    
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
					if (lastmatch == pi-1 || (p.charAt(lastmatch+1)!='*')) {
						if (curr=='.'||curr==s.charAt(si))lastmatch = pi;						
						pi+=2;
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
								pi+= 2;
								
							} else if (curr == '.') {
							    lastmatch = pi;
								pi+= 2;
							} else if (curr == last){
								
								pi+=2;
							}
						} else { //last ==. follow by a *
						
							
							pi+=2;
						
						}	
					}
				} else {//has to match a single char
					if (lastmatch == pi-1 || (p.charAt(lastmatch+1)!='*')) {
						if (curr!='.'&&curr!=s.charAt(si)) return false;
						lastmatch = pi;
						pi++;
						si++;
					} else {//has non matched pattern before, non-aggressive.
						char last = p.charAt(lastmatch);
						if (last!='.') {
							if (curr != last&&curr!='.') {
								while (si<sl&&s.charAt(si)==last) {
									si++;
								}
								if (si==sl||s.charAt(si)!=curr) return false;
								lastmatch = pi;
								pi++;
								si++;
							} else if (curr == '.') {
								//?don't know how to gao
								while(si<sl&&s.charAt(si)==last){
									if (isMatch(s.substring(si),p.substring(pi))) return true;
									si++;
								}
								if (si == sl) return false;
								lastmatch = pi;
								pi++;
								si++;
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
				}					
		}
		
		if (si==sl&&pi==pl) return true;
		//if p hits the end
		if (pi == pl) {
		    //s is not empty but nothing match
		    if (lastmatch == -1 ) return false;
		    if (p.charAt(lastmatch)=='.'){
				if (lastmatch == pl-1) return false;
				if (p.charAt(lastmatch+1)=='*') return true;
			}
			if (lastmatch+1 < pl&&p.charAt(lastmatch)==s.charAt(si)&&p.charAt(lastmatch+1)=='*') {
				while (si<sl&&s.charAt(si)==p.charAt(lastmatch)) si++;
			}
			return si==sl;
        }
        
        //if s hits the end
    	while (pi+1<pl){
    		if (p.charAt(pi+1)!='*') return false;
    		pi += 2;
		}
		if (pi == pl-1) return false;
		return true;
	}
