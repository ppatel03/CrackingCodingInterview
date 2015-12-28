/**
 * Code to print all permutations of a String
 * Recursive Approach : 
 * Consider String : ab
 * Permutation : ab ba
 * 
 * String : abc
 * Permuation : a->bc=abc   a->cb=acb   b->ac=bac   b->ca=bca   c->ab=cab  c->ba=cab
 * 
 * So the logic is simple : swap every element of the combo at the first position and swap all other elements i.e. 2nd position to n-1
 * 
 */
package examples;


/**
 * @author prashant
 *
 */


public class PermutationOfString {

	public static String swap(String a, int i , int j){
		//System.out.println("Before Swapping at position "+i+" and "+j+" is: "+a);
		char[] c = a.toCharArray();
		char temp =  c[i];
		c[i]=c[j];
		c[j] = temp;	
		String m = new String(c);
		//System.out.println("After Swapping : "+m);
		return m;
	}


	public static void permute(String input, int n, int k){
     
		if(k == n-1){
			System.out.println(input);
		}

		for(int i = k; i <n ; i++){
			input = swap(input, k, i);
			permute(input, n, k+1);
			input = swap(input,i,k);			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input= "abcd";
		permute(input, input.length(), 0);
	}

}
