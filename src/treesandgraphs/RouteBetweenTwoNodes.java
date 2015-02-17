/**
 * 
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * 
 * Solution : Use Famous DFS Algo & implement  the explore function in DFS
 * 
 * We assume the graph in adjacency list format
 * 
 */
package treesandgraphs;

/**
 * @author prashant
 *
 */
public class RouteBetweenTwoNodes {

	
	public static void explore(int[][] graph, int sourceIndex,  boolean[] visited){
		
		visited[sourceIndex] = true;
		
		System.out.println("Visited node : " +(char)(65 + sourceIndex));
		
		for(int j = 0 ; j < graph[sourceIndex].length ; j++){
			
			if(!visited[j] && graph[sourceIndex][j] == 1){
				explore(graph, j, visited);				
			}
			
		}	
		
	}
	
	
	public static boolean checkForNodesConnection(int[][] graph, int sourceIndex, int destinatonIndex){
		
		boolean[] visited = new boolean[graph.length];
		
		explore(graph, sourceIndex, visited);
		
		if(visited[sourceIndex] && visited[destinatonIndex]){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {
				{0,1,1,0,0,0},
				{1,0,0,0,1,0},
				{1,0,0,1,1,1},
				{0,0,1,0,0,0},
				{0,1,1,0,0,1},
				{0,0,1,0,1,0}				
		};
		
		int sourceIndex = 0;
		int destinationIndex = 5;
		
		System.out.println(" Is there a path between Nodes "+(char)(65+sourceIndex)+" and "+(char)(65+destinationIndex)+" : ");
		System.out.println(checkForNodesConnection(graph, sourceIndex, destinationIndex));
	}

}
