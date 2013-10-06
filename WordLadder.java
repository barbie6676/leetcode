/*126. world ladder 
 algorithm: DFS
 data structure: Queue (inplemented with an LinkedList), record this level and last level.
*/

  public int ladderLength(String start, String end, HashSet<String> dict) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 
	        if (start.length() != end.length() || start.equals(end)) return 0;
	        
	        int path = 0;
	        Queue<String> q = new LinkedList<String>();
	        HashSet<String> used = new HashSet<String>();
	        
	        q.add(start);
	        used.add(start);
	        
	        int lev1 = 1;
	        int lev2 = 0;
	        boolean found = false;
	        
	        while(!q.isEmpty()) {
	            String s = q.remove();
	            lev1--;
	            
	            if (s.equals(end)) {
	                path++;
	                found = true;
	                break;
	            } else {
	              
	                for (int i = 0; i < s.length(); i++) {
	                	 StringBuilder sb = new StringBuilder(s);
	                    for (int j = 0 ; j < 26 ; j++) {
	                        sb.setCharAt(i,(char)('a'+j));
	                        String t = sb.toString();
	                        if (dict.contains(t)&&!used.contains(t)) {
	                        	//System.out.println(t);
	                            used.add(t);
	                            q.add(t);
	                            lev2++;
	                        }
	                    }
	                }
	            }
	            
	            if (lev1 == 0) {
	                path++;
	                lev1 = lev2;
	                lev2 = 0;
	            }
	        }
	        
	        return found?path:0;
		 
}
