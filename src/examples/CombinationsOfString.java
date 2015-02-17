/**
 *  Print all the combinations of the given String
 *  
 *  input = ABC
 *  output = C  B  BC   A   AC   AB   ABC
 *  
 *  Technique is Similar to binary printing : 000  001  010  011  100  101  110  111            
 *  
 *  Recursive Approach : Just take starting position character. Give its value as either 0 and call recursively for other characters.
 *  Then give its value as 1 and call it recursively for other characters.  
 * 
 */
package examples;

public class CombinationsOfString {
	
	public static void printString(String input, int[] binInput ){
		for(int i = 0 ; i < input.length() ; i++){
			if( binInput[i] == 1){
				System.out.print(input.charAt(i));
			}
		}
		System.out.println();
	}
	
	public static void printCombinations(String input,int[] binInput, int k,int n){
		if(k==n){	
			binInput[k] = 0;
			printString(input, binInput);
			binInput[k] = 1;
			printString(input, binInput);
		}
		else{
			binInput[k] = 0;
			printCombinations(input, binInput, k+1, n);
			binInput[k] = 1;
			printCombinations(input, binInput, k+1, n);
		}
	}

	public static void main(String[] args){
		String s = "abc";
		int[] binInput = new int[s.length()];
		printCombinations(s,binInput,0,s.length()-1);
	}
}
