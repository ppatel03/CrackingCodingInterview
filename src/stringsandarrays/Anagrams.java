/**
 * 
 * Write a method to decide if two strings are anagrams or not.
 * use extra int array for keeping count of the character. Also use uniqueWordCount logic for efficiency
 * 
 */
package stringsandarrays;

/**
 * @author prashant
 *
 */
public class Anagrams {


	public static boolean checkAnagrams(String s1, String s2){
		int s1Length = s1.length();
		int s2Length = s2.length();
		if(s1Length != s2Length){
			return false;
		}
		else{
			int[] countCheckArray = new int[256];

			int noOfUniquewordsInS1 = 0;
			int noOfCounterWordsInS2 = 0;
			int i, asciValue ;
			for( i = 0 ; i < s1Length ; i++){
				asciValue = s1.charAt(i);
				if(countCheckArray[asciValue] == 0){
					noOfUniquewordsInS1++;
				}
				countCheckArray[asciValue]++;				
			}

			for( i = 0; i < s2Length; i++){
				asciValue = s2.charAt(i);
				if(countCheckArray[asciValue] == 0){
					return false;
				}
				else{
					countCheckArray[asciValue]--;
					if(countCheckArray[asciValue] == 0){
						noOfCounterWordsInS2++;

						if(noOfCounterWordsInS2 == noOfUniquewordsInS1){
							return i == s2Length-1;
						}

					}
				}


			}

			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdef";
		String s2 = "ebcddf";

		System.out.println(" Two Strings are Anagrams Result : "+checkAnagrams(s1,s2));
	}

}
