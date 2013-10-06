/*118. Pascal's Triangle
  algorithm: non, add line to triangle one by one
  
  119. Pascal's Triangle II
  algorithm: O(n) constance extra space, DP. from middle to two end, update the value,
  finally add the numbers to an arrayList
  */



public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if (numRows == 0) return ret;
        
        for (int i = 0; i < numRows ; i++) {
            ArrayList<Integer> line = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(ret.get(i-1).get(j)+ret.get(i-1).get(j-1));
                }
            }
            
            ret.add(line);
        }
        
        return ret;
    }
	
	
public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        
        if (rowIndex < 0) return ret;
        if (rowIndex == 0) {
            ret.add(1);
            return ret;
        }
        
        int[] line = new int[rowIndex+1];
        
        line[0] = 1;
        
        for (int i = 1; i <= rowIndex; i++) {
        
            for (int j = i/2; j > 0; j--) {
                line[j] += line[j-1];
            }
            
            for (int j = i/2+1; j <= i; j++) {
                line[j] = line[i-j];
            }
            
        }
        
        for (int i = 0; i <= rowIndex ; i++){
            ret.add(line[i]);
        }
        
        return ret;
    }
