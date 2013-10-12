/*22. generate parenthesis

algorithm: as long as available right one >= left ones, can continue
recursion.

*/

public ArrayList<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> ret = new ArrayList<String>();
        
        generate(ret, "", n,n);
        
        return ret;
    }
    
    public void generate(ArrayList<String> ret, String s, int left, int right) {
        if (left <0 || right < 0) return;
        
        if (left == 0 && right == 0) {
            ret.add(s);
            return;
        }
        
        if (right>left) {
            generate(ret,s+'(',left-1,right);
            generate(ret,s+')',left,  right-1);
        } else if (right == left) {
            generate(ret,s+'(',left-1,right);
        }
    }
