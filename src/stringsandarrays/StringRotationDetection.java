/**
 * 
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only 
 * one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 * 
 * Simple logic : first check the length. Then append any string with itself and check other string is the substring
 * of the appended string
 * 
 */
package stringsandarrays;

public class StringRotationDetection {
	
	public static boolean checkRotationOfTwoStrings(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		else{
			String concatString = s1+s1;
			
			return concatString.contains(s2);
		}
		
	}
	
	public static void main(String[] args){
		String s1 = "waterbottle";
		String s2 = "erbottlewatw";
		
		System.out.println(" Are Two Strings Rotation of each other : "+checkRotationOfTwoStrings(s1,s2));
	}

}
