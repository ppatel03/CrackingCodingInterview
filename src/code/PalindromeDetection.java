package code;

public class PalindromeDetection {
	
	/**
	 * checks whether the input String is a Palindrome or not
	 * @param inputString
	 * @return
	 */
	public boolean isStringAPalindrome(String inputString){
		for(int i = 0, j = inputString.length()-1 ; i < j ; i++,j--){
			//fetching the left and right character from the String
			char leftChar = inputString.charAt(i);
			char rightChar = inputString.charAt(j);
			
			//ignore non-alphanumeric Characters
			while(!(Character.isDigit(leftChar) || Character.isLetter(leftChar))){
				i++;
				leftChar = inputString.charAt(i);
			}
			
			//ignore non-alphanumeric Characters
			while(!(Character.isDigit(rightChar) || Character.isLetter(rightChar))){
				j--;
				rightChar = inputString.charAt(j);
			}
			
			//if the character from the left and the one from the right does not match, return false
			if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeDetection palindromeDetection = new PalindromeDetection();
		System.out.println(palindromeDetection.isStringAPalindrome("ana"));
		System.out.println(palindromeDetection.isStringAPalindrome("pop"));
		System.out.println(palindromeDetection.isStringAPalindrome("anana"));
		System.out.println(palindromeDetection.isStringAPalindrome("Ah, Satan sees Natasha"));

	}

}
