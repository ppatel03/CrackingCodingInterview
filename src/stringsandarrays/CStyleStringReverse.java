/**
 * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
 * 
 * In case of Java
 * input = abcd\0   \0-->representing null character
 * output = dcba	
 * 
 * Reverse the string using start and end position till they both meet each other
 * 
 */
package stringsandarrays;

public class CStyleStringReverse {
	
	public static String reverseCStyleString(String input){
		int length = input.length();
		int endPosition = length-1;
		int i,j;
		char[] charInputArray = input.toCharArray();
		
		//determine the end of the string
		for( i = length -1 ; i >= 0; i--){
			if(charInputArray[i] != '\0'){
				endPosition = i;
				break;
			}
		}
		
		//in place reverse logic
		for(i=0,j=endPosition;i<j;i++,j--){
			if(charInputArray[i] != charInputArray[j]){
				char temp = charInputArray[i];
				charInputArray[i] = charInputArray[j];
				charInputArray[j] = temp;
			}			
		}
		
		return new String(charInputArray);
	}

	public static void main(String[] args){
		String input = "abcde\0";
		System.out.println("Ther reverse String is : "+reverseCStyleString(input));
		
	}
}
