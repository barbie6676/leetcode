/*17. letter combination of phone number 
don't consider the 0 or 1 digits*/

 public ArrayList<String> letterCombinations(String digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> key = new ArrayList<String>();
         ArrayList<String> ret = new ArrayList<String>();
        if (digits.isEmpty()){
            ret.add("");
            return ret;
        }
        for (int i = 0; i <=9 ; i++){
            if (i<2) {
                key.add("");
            }else if (i == 2){
                key.add("abc");
            } else if (i ==3){
                key.add("def");
            } else if (i == 4){
                key.add("ghi");
            } else if (i == 5){
                key.add("jkl");
            }else if (i == 6){
                key.add("mno");
            }else if (i == 7){
                key.add("pqrs");
            }else if (i == 8){
                key.add("tuv");
            }else if (i == 9){
                key.add("wxyz");
            }
            
        }
        
        return letters(key,digits);
    }
    
    ArrayList<String> letters(ArrayList<String> key, String digits) {
        ArrayList<String> ret = new ArrayList<String>();
        if (digits.length() == 1){
            int d = digits.charAt(0)-'0';
            
            for (int i = 0 ; i < key.get(d).length(); i++){
                String s = "";
                s+=key.get(d).charAt(i);
                ret.add(s);
            }
            if (d<=1) ret.add("");
            return ret;
        } 
        
        int d = digits.charAt(0)-'0';
        ArrayList<String> rest = letters(key,digits.substring(1));
        for (int i = 0 ; i < key.get(d).length();i++){
            for (int j = 0; j < rest.size(); j++) {
                String s = rest.get(j);
                s = key.get(d).charAt(i) + s;
                ret.add(s);
            }
        }
        
        return ret;
    }
