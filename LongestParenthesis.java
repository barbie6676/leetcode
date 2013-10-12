/*32. longest valid parenthesis

algorithm: always keeps track of the length of valid parenths right left to the current left parenthesis

data structure: two stacks, one keep index of the current left p,
                            ont keeps left length
                            
*/

public int longestValidParentheses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int longest = 0;
        
        if (s.length() <= 1) return 0;
        
        Stack<Integer> idx = new Stack<Integer>();
        Stack<Integer> left = new Stack<Integer>();
        
        //boolean pop = false;
        int curr = 0;
        for (int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            
            if (c=='(') {
                idx.push(i);
                left.push(curr);
                //pop = false;
                curr = 0;
            } else {
                if (idx.isEmpty()) {
                   // pop = false;
                    curr = 0;
                } else {
                    curr+=2;
                    curr+=left.pop();
                    idx.pop();
                    //pop = true;
                    longest = Math.max(longest,curr);
                }
            }
        }
        
        return longest;
    }
                    
                    
