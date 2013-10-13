/*20 */

public boolean isValid(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = s.length();
        if (n%2 == 1) return false;
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0 ; i < n; i ++) {
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char l = stack.pop();
                if (l!='('&&c==')') return false;
                if (l!='{'&&c=='}') return false;
                if (l!='['&&c==']') return false;
            }
        }
        
        return stack.isEmpty();
    }
