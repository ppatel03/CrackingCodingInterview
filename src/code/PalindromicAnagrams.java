package code;

import java.util.HashMap;
import java.util.Map;

public class PalindromicAnagrams {
	
	Map<String,String> checkMap = new HashMap<String,String>();
	
	 public static boolean checkPalindrome(String input)
	    {
	        int [] count = new int[26];
	        for( int i = 0; i < input.length(); i++ )
	        {
	            char ch = input.charAt(i);
	            count[ch-'a']++;
	        }
	        int oddOccur = 0;
	        for( int cnt:count )
	        {
	            if( oddOccur > 1)
	                return false;
	            if( cnt%2 == 1 )
	                oddOccur++;
	        }
	        return true;
	    }
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "abababa";
		
	}

}
