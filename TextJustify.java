/*68. text justification
algorithm: no, just calculate the space number between words.
*/

public ArrayList<String> fullJustify(String[] words, int L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> ret = new ArrayList<String> ();
        if (words.length == 0) return ret;
        
        int spaceleft = L;
        int count = 0;
        
        for (int i = 0; i < words.length ; i++) {
            if (words[i].length() == spaceleft) {
                String line = "";
                
                for (int j = 0; j < count; j++) {
                    line += words[i-(count-j)];
                    line += ' ';
                }
                line += words[i];
                ret.add(line);
                spaceleft = L;
                count = 0;
            } else if (words[i].length() < spaceleft) {
                count ++;
                spaceleft -= words[i].length();
                spaceleft --;
            } else {
                String line = "";
                if (count == 1) {
                    line += words[i-1];
                    for (int j = 0; j <= spaceleft; j++){
                        line += ' ';
                    }
                } else {
                    int extraSpacePer = (spaceleft+1)/(count-1);
                    int extraSpaceLeft = (spaceleft+1)%(count-1);
                    for (int j = 0; j < count ; j++) {
                        line += words[i-(count-j)];
                        if (j == count-1) break;
                        for (int s = 0; s<=extraSpacePer ; s++) {
                            line += ' ';
                        }
                        if (j < extraSpaceLeft) line += ' ';
                    }
                }
                ret.add(line);
                spaceleft = L;
                count = 0;
                i--;
            }
        }
        
        if (count > 0) {
            String line = "";
            for (int j = 0; j < count; j++) {
                line += words[words.length-(count-j)];
                line += ' ';
            }
            for (int s = 0; s < spaceleft; s++){
                line += ' ';
            }
            ret.add(line);
        }
        return ret;
    }
