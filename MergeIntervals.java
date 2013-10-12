/*56. merge intervals
algorithm: sort with start first, then compare ends.

wu ta shou shu er

*/

public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = intervals.size();
        if (n <=1) return intervals;
        
        Collections.sort(intervals,INTERVAL_ORDER);
        int i = 0;
        int j = 1; 
        while (j < n) {
            if (intervals.get(j).start > intervals.get(i).end) {
                i = j;
                j++;
                
            } else if (intervals.get(j).end <= intervals.get(i).end){
                intervals.remove(j);
                n--;
            } else {
                intervals.get(i).end = intervals.get(j).end;
                intervals.remove(j);
                n--;
            }
        }
        
        return intervals;
    }
    
    static final Comparator<Interval> INTERVAL_ORDER = new Comparator<Interval>(){
       public int compare (Interval i, Interval j) {
           return new Integer(i.start).compareTo(new Integer(j.start));
       }
   };
