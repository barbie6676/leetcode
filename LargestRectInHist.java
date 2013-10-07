 /*84. Largest Rectangle in Histogram
 algorithm:  if the col is higher than the last one, push in,
             if lowers, pick out the high ones and calculate the area to the current positions.
			 
 data structure: two stacks.*/
 
 
 public int largestRectangleArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		int n = height.length;
		
		if (n==0) return 0;
		if (n==1) return height[0];
        Stack<Integer> col = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		
		col.push(height[0]);
		index.push(0);
		int area = height[0];
		for (int i =1; i < n;i++){
			if (height[i]>col.peek()) {
				col.push(height[i]);
				index.push(i);
			} else {
				int h = 0;
				int idx = 0;
				while(!col.isEmpty()&&height[i]<=col.peek()){
					h = col.pop();
					idx = index.pop();
					area = Math.max(area,h*(i-idx));
				}
				col.push(height[i]);
				index.push(idx);
			}
		}
		while(!col.isEmpty()){
			int h = col.pop();
			int idx = index.pop();
			area = Math.max(area,h*(n-idx));
		}
		
		return area;
		
    }