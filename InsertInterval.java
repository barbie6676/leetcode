/*57. Insert intervals.
algorithm: Four steps:

1. insert everything end less than new's start into new list;
2. insert the new interval, it may overlap with the curr one, be careful to update the end.
3. skip all the following intervals which can be total covered by the new interval.
4. until the first the following one can not be fully covered, update the end. then add everything after that.

*/

public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Interval> ret = new ArrayList<Interval>();
        
        if (intervals.isEmpty()) {
            ret.add(newInterval);
            return ret;
        }
        
        int i = 0;
        for ( ; i < intervals.size(); i++) {
            if (intervals.get(i).start >= newInterval.start) break;
            ret.add(intervals.get(i));
        }
        
        if (i == 0 || newInterval.start > intervals.get(i-1).end) {
            ret.add(newInterval);
        } else {
            ret.get(i-1).end = Math.max(newInterval.end,ret.get(i-1).end);
        }
        
        int j = i;
        for (; j < intervals.size(); j++) {
            if (intervals.get(j).start > ret.get(ret.size()-1).end) {
                ret.add(intervals.get(j));
            } else if (intervals.get(j).end <= ret.get(ret.size()-1).end) {
                continue;
            } else {
                 ret.get(ret.size()-1).end = intervals.get(j).end;
            }
        }
        
        return ret;
    }
