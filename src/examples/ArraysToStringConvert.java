/**
 * 
 */
package examples;

import java.util.Arrays;

/**
 * @author prashant
 *
 */
public class ArraysToStringConvert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"he,llo", "world", "how"};
		String arrayString = Arrays.toString(array);
		arrayString = arrayString.replaceAll(", ", " ");
		System.out.println(arrayString);
	}

}
