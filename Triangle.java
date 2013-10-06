/*120. Triangle 
 algorithm: DP, walking from bottom to up, use an array to store the curr min sum at this level, one level up, pick up the smaller foot.
 data structure: 
 */
 
 public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int level = triangle.size();
        if (level == 0) return 0;
        if (level == 1) return triangle.get(0).get(0);
        
        int[] sum = new int[level];
        
        for (int i = level -1; i >= 0; i--) {
            
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == level -1) {
                    sum[j] = triangle.get(i).get(j);
                } else {
                    sum[j] = triangle.get(i).get(j) + (sum[j]<sum[j+1]?sum[j]:sum[j+1]);
                }
               
            }
         
            
        }
        
        return sum[0];
    }
