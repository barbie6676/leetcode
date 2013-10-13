/*
133. clone a graph

algorithm:
Breadth-First-Search, use a queue to record all the node(node then its neighbours)

data structure:
HashMap, put each <node-neighbor>, <neighbor-node> pairs in the cloned graph into
a map. 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class UndirectedGraphNode {
     int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { 
    	  label = x; 
    	  neighbors = new ArrayList<UndirectedGraphNode>(); 
     }
}
public class Solution{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if (node == null) return null;
		 
	    HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
	    Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
	    q.add(node);
	 
	    UndirectedGraphNode graphCopy = new UndirectedGraphNode(node.label);
	    map.put(node,graphCopy);
	 
	    while (!q.isEmpty()) {
	    	UndirectedGraphNode curr = q.remove();
	        
	        int n = curr.neighbors.size();
	        for (int i = 0; i < n; i++) {
	        	UndirectedGraphNode neighbor = curr.neighbors.get(i);
	            // no copy exists
	            if (!map.containsKey(neighbor)) {
	            	UndirectedGraphNode p = new UndirectedGraphNode(neighbor.label);
	                map.get(curr).neighbors.add(p);
	                map.put(neighbor,p);
	                q.add(neighbor);
	            } else {     // a copy already exists
	            	 UndirectedGraphNode copy = map.get(neighbor);
	                
	            	map.get(curr).neighbors.add(copy);
	            }
	        }
	    }
	 
	    return graphCopy;
    }
}
