/*125. Valid Palindrome
algorithm: two ends going to middle.
data structure Character.
*/

public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = s.length();
        
        if (len <=1) return true;
        
        int l = 0;
        int r = len-1;
        while (l<r) {
             char ll = s.charAt(l);
             char rr = s.charAt(r);
            if (!Character.isLetterOrDigit(ll)) {
                l++;
                continue;
            }
            
             if (!Character.isLetterOrDigit(rr)) {
                r--;
                continue;
            }
            
           if ((Character.isDigit(ll)&&Character.isLetter(rr))||(Character.isDigit(rr)&&Character.isLetter(ll)) ) return false;
           if (Character.isDigit(ll)&&Character.isDigit(rr)&&rr!=ll) return false;
           if (Character. isLowerCase(ll)&&Character. isLowerCase(rr)&&rr!=ll) return false;
           if (Character. isUpperCase(ll)&&Character. isUpperCase(rr)&&rr!=ll) return false;
           if (Character. isUpperCase(ll)&&Character. isLowerCase(rr)&&ll-'A'!=rr-'a') return false;
           if (Character. isLowerCase(ll)&&Character. isUpperCase(rr)&&ll-'a'!=rr-'A') return false;
           
           l++;
           r--;
        }
        
        return true;
        
    }
