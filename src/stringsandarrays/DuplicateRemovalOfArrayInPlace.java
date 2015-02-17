/**
 * 
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * 
 */
package stringsandarrays;

/**
 * @author prashant
 *
 */
public class DuplicateRemovalOfArrayInPlace {
	
	

	/**
	 * 
	 * @param input
	 * @return the removal of duplicates from the String without extra memory
	 */
	public static String removeDuplicates(String input){
		int length = input.length();
		char[] charInput = input.toCharArray();

		int tail = 1;

		for(int i = 1; i < length; i ++){
			int j ;
			for( j = 0; j < tail ; j++){
				if(charInput[i] == charInput[j]){
					break;
				}
			}
			if( j == tail){
				charInput[tail] = charInput[i];
				tail++;
			}
		}
		
		for(int i = tail; i < length; i++){
			charInput[i] = '\0';
		}

		return new String(charInput);
	}
	
	/**
	 * 
	 * @param input
	 * @return the removal of duplicates with extra memory
	 */
	public static String removeDuplicatesWithExtraMemory(String input){
		int length = input.length();
		boolean[] isCharPresent = new boolean[256];
		int tail = 0;
		char[] charInput = input.toCharArray();
		for(int i = 0 ; i < length ; i++){
			int charAsci = input.charAt(i);
			
			if(!isCharPresent[charAsci]){
				isCharPresent[charAsci] = true;
				charInput[tail++] = charInput[i];
			}		
			
		}
		
		for(int i = tail; i < length; i++){
			charInput[i] = '\0';
		}
		
		return new String(charInput);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdadeef";
		System.out.println("The Array after removing the duplicates with Method 1 is : "+removeDuplicates(s));
		System.out.println("The Array after removing the duplicates with Method 2 is : "+removeDuplicatesWithExtraMemory(s));

	}

}
