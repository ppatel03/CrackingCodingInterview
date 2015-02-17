/**
 * Implement an algorithm to determine if a string has all unique characters.
 *  
 * What if you can not use additional data structures?
 * 
 * Solution 1 : With Additional data structure
 * simply create a char array of size 256 and store each character of the string in respective ASCII value in character array. If the array 
 * position already contains the value , then its a duplicate
 * 
 * Solution 2: Without Additional data structure
 * Convert each character to ASCI and right shift it to its ASCI value. Then do bitwise & operation to check if its unique.
 * Also merge the previous results by bitwise |
 * 
 */
package stringsandarrays;

/**
 * 
 * @author prashant
 *
 */
public class UniqueCharactersInString {
	
	/**
	 * 
	 * simply create a char array of size 256 and store each character of the string in respective ASCII value in character array. 
	 * If the array position already contains the value , then its a duplicate	 * 
	 * 
	 * @param input
	 * @return
	 */
	public static boolean checkUniqueCharactersWithExtraMemory(String input){
		int length = input.length();
		char[] c = new char[256];
		for(int i = 0 ;i < length; i++){
			char sChar = input.charAt(i);
			int asciValue = sChar;
			if(c[asciValue] > 0){
				return false;
			}
			else{
				c[asciValue]++;
			}			
		}
		return true;
	}
	
	/**
	 * 
	 * Convert each character to ASCI and right shift it to its ASCI value. Then do bitwise & operation to check if its unique.
	 * Also merge the previous results by bitwise |
	 * 
	 * @param input
	 * @return
	 */
	public static boolean checkUniqueCharactersWithoutExtraMemory(String input){
		int binaryValue = 0;
		for(int i = 0 ; i < input.length() ; i++){
			int asciValue = input.charAt(i);
			int rightShiftValue = 1<<asciValue;
			if((rightShiftValue & binaryValue) > 0){
				return false;
			}
			else{
				binaryValue = rightShiftValue | binaryValue;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "helo wrd";
		System.out.println(" Is Input Array Unique with Method 1 "+checkUniqueCharactersWithExtraMemory(input));
		System.out.println(" Is Input Array Unique with Method 2 "+checkUniqueCharactersWithoutExtraMemory(input));

	}

}
