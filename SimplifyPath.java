/*71,simplify path.
algorithm: keep the track of all the position of "/", each time meet "..", just one slash back.

*/

public String simplifyPath(String path) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
         int len = path.length();
	        String simple = "";
	        if (len == 0) return simple;
	        if (path.charAt(0) != '/') return simple;
	        
	        Stack<Integer> slash = new Stack<Integer>();
	        int idx = 0;
	        slash.push(idx);
	        simple += '/';
	        for (int i = 1; i < len ; i++) {
	            char c = path.charAt(i);
	            if (c == '/') {
	                
	                int j = i+1;
	                while(j<len&&path.charAt(j)=='/'){
	                    j++;
	                }
	                if (j < len) {
	                    i = j-1;
	                    if (simple.isEmpty()||simple.charAt(idx) != '/'){
	                        simple +='/';
	                        idx++;
	                        slash.push(idx);
	                        }
	                }
	            } else if (c == '.') {
	                if (i == len -1) {
	                    if (slash.isEmpty()) return "/";
	                    simple = simple.substring(0,slash.peek());
	                    idx = slash.peek()-1;
	                } else if (path.charAt(i+1) == '/'){
	                    i++;
	                } else if (path.charAt(i+1) == '.') {
	                    i ++;
	                    slash.pop();
	                    if (slash.isEmpty()) {
	                    	simple = "/";
	                    	idx = 0;
	                    	slash.push(idx);
	                    } else {
		                    simple = simple.substring(0,slash.peek());
		                    idx = slash.pop()-1;
	                    }
	                } else {
	                    simple += c;
	                    idx++;
	                }
	            } else {
	                simple += c;
	                idx ++;
	            }
	        }
	        
	        
	      
	        if (simple.isEmpty()) {
	            simple+='/';
	        }else if (idx>0&&simple.charAt(idx)=='/') {
	            simple = simple.substring(0,idx);
	        }
	     
	        return simple;
    }
