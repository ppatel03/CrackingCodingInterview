package code;

public class LoveLetterMystery {

	public static int[] isLoveAPalindrome(String[] letter){
		int length = Integer.parseInt(letter[0]);
		int[] ans = new int[length];


		for(int i = 1 ; i <= length ; i++){
			String str = letter[i];
			int start = 0 ;
			int operations = 0;
			int end = str.length()-1;
			int diff = 0;
			while(start <= end){
				char a = str.charAt(start);
				char b = str.charAt(end);
				if(a != b){
					diff = Math.abs(a - b);
					operations = operations + diff;
				}
				start++; end--;
			}
			ans[i-1] = operations;
		}
		return ans;
	}

	public static void display(int []a){
		for(int no : a){
			System.out.print(no+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] letter = {"4", "abc","abcba","abcd","cba"};
		display(isLoveAPalindrome(letter));
	}

}
