/**
3... * A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2. 
 * 	1. How would you find the minimum element?
 * 	2. Find a particular element in an array ?
 * 
 * For solution 1 : 
 * If the array is not rotated by checking  a[length - 1] > a[0], then return a[0].
 * Else You do a linear search and stop when a[i]>a[i+1] --> return a[i+1]
 * 
 * For solution 2 : 
 * Do a Binary search but with extra conditions 
 * 1. if no < l && no < mid , 
 * 2. if no > m && no > u
 * 
 */
package examples;

/**
 * @author prashant
 *
 */
public class RotatedArraySearch {

	/**
	 *  If the array is not rotated by checking  a[length - 1] > a[0], then return a[0].
	 * Else You do a linear search and stop when a[i]>a[i+1] --> return a[i+1]	 
	 * 
	 * @param a
	 * @return the the minimum element in rotated array
	 */
	public static int findMinimum(int[] a){
		int length = a.length;
		if(a[length - 1] > a[0]){
			return a[0];
		}
		else{
			int min = a[0];
			for(int i = 0 ; i < length - 1; i++){
				if(a[i] > a[i+1]){
					return a[i+1];
				}
			}

			return min;
		}
	}

	public static int search(int[] a, int lowerIndex, int upperIndex, int numberToFind){

		if(lowerIndex <= upperIndex){
			int mid = (lowerIndex + upperIndex) / 2;
			
			System.out.println("lowerIndex = "+lowerIndex+" and upperIndex = "+upperIndex+" and mid = "+mid);


			if(a[mid] == numberToFind){
				return mid;
			}
			if(a[lowerIndex] < a[upperIndex]){
				// traditional binary search boundary condition for left half
				if(numberToFind < a[mid] ){
					upperIndex = mid - 1;
				}
				// search for right half
				else{
					lowerIndex = mid + 1;
				}
			}
			else{
				//check the number range in left half
				if(numberToFind > a[lowerIndex] && numberToFind < a[mid]){
					upperIndex = mid -1;
					
				}
				//search for right boundary
				else{
					lowerIndex = mid +1;
				}
			}			

			return search(a, lowerIndex, upperIndex, numberToFind);

		}

		return -1;

	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int []a = {3,4,5,6,7,1,2};
		
		int[]a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		
		System.out.println("The Minimum number is at location : "+findMinimum(a));
		
		int numberToFind = 5;
		
		System.out.println("The number "+numberToFind+" is located at position : "+(search(a, 0, a.length-1, numberToFind)+1));

	}

}
