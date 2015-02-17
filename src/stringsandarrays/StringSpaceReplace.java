/**
 * 
 * Write a method to replace all spaces in a string with ‘%20’.
 * 
 * Considering string as character array, first count the number of spaces and 
 * then create a character array with size = string size + 2*spaceCount
 * 
 */
package stringsandarrays;

/**
 * @author prashant
 *
 */
public class StringSpaceReplace {
	
	public static String getReplacedString(String input){
		int i,spaceCount = 0;
		
		char[] inputCharArray = input.toCharArray();
		for(i=0; i < inputCharArray.length ; i++ ){
			if(inputCharArray[i] == ' '){
				spaceCount++;
			}
		}
		
		int replaceStringLength = inputCharArray.length + spaceCount*2;
		
		char[] replaceCharArray = new char[replaceStringLength];
		
		replaceStringLength -=1;
		for(i = inputCharArray.length-1; i >= 0; i--){
			if(inputCharArray[i] == ' '){
				replaceCharArray[replaceStringLength--] = '0';
				replaceCharArray[replaceStringLength--] = '2';
				replaceCharArray[replaceStringLength--] = '%';
			}
			else{
				replaceCharArray[replaceStringLength--] = inputCharArray[i];
			}
		}
		
		return new String(replaceCharArray);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "hello world!! I am not happy ";
		System.out.println("The replaced String is "+getReplacedString(input));
	}

}
