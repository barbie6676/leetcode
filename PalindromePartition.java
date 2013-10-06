/*
131. Palindrome Partitioning

algorithm:
recursion, brutal search, grab all the palindrome substrings from start point, recursively return the palindrome partions of the rest of the string, combine with the first one, return result.

data structure:
ArrayList 

comments:
if the palindrome substring from the start covers the whole string, stops recursion, otherwise will add an empty string at the end.
*/



public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if (s.length() <= 1) {
        	ArrayList<String> elem = new ArrayList<String>();
        	elem.add(s);
        	ret.add(elem);
        	return ret;
        }
        
        for (int i = 0; i< s.length() ; i++){
        	String curr = s.substring(0,i+1);
        	if (isPalindrom(curr)) {
        		if (i<s.length()-1){
		        	 ArrayList<ArrayList<String>> rest = partition(s.substring(i+1));
		        	 for (int j = 0; j < rest.size(); j++){
		        		 rest.get(j).add(0,curr);     		 
		        	 }
		        	 ret.addAll(rest);
	        	 } else {// here is the point mentioned in the comments
	        		 ArrayList<String> elem = new ArrayList<String>();
	             	 	elem.add(curr);
	        		 ret.add(elem);
	        	 }
        	}
		}
        
        return ret;
    }
	
	public boolean isPalindrom(String s) {
		if (s.length()<=1) return true;
		for (int i = 0; i < s.length()/2;i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
		}
		
		return true;
	}
