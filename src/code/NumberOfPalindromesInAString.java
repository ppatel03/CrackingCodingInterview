package code;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPalindromesInAString {

	static int longestPalSubstr( String inp )
	{
	    int n = inp.length(); 
	    boolean[][] matrix = new boolean[n][n];
	    Map<String,String> map = new HashMap<String,String>();
	 
	    for (int i = 0; i < n; ++i){
	    	matrix[i][i] = true;
	    	map.put(inp.charAt(i)+"", null);
	    }
	 
	    //length == 2
	    for (int i = 0; i < n-1; ++i)
	    {
	        if (inp.charAt(i) == inp.charAt(i+1))
	        {
	        	matrix[i][i+1] = true;
		    	map.put(inp.substring(i,i+2), null);
	        }
	    }
	 
	    // length > 2
	    for (int k = 3; k <= n; ++k)
	    {
	        // Fix the starting index
	        for (int i = 0; i < n-k+1 ; ++i)
	        {
	           
	            int j = i + k - 1;
	 
	            if (matrix[i+1][j-1] && inp.charAt(i) == inp.charAt(j))
	            {
	            	matrix[i][j] = true;
	            	map.put(inp.substring(i,j+1), null);
	            }
	        }
	    }    
	 
	    return map.size(); 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(longestPalSubstr("aabaa"));
	}

}
