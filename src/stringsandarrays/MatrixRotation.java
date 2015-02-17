/**
 * Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. 
 * Can you do this in place?
 * 
 * Use two loops and go on replacing each element of the layer with one another
 */
package stringsandarrays;

/**
 * @author prashant
 *
 */
public class MatrixRotation {
	
	public static void printMatrix(int[][] a){
		for(int i = 0; i <a.length ; i++){
			for(int j =0 ;j <a[i].length;j++){
				System.out.print(a[i][j]+ "\t");
			}
			System.out.println();
		}
	}
	
	static void rotateMatrixBy90(int[][] a){
		
		//rotate layer by layer. Max there can be n/2 layers
		for(int layer = 0 ; layer < a.length/2 ; layer++){
			int last = a.length -1 - layer;
			for(int i = layer; i < last ; i++){
				
				//not required for outer boundary rotation . But required for inner boundary rotation 
				//bcoz for inner boundary if i increases, last-i might shift your desired position to a low value
				// but it needs to be added by layer. 
				//So last - i (for outer boundary since layer = 0)= last - i + layer (for inner boundary)
				// last - i + layer = last - offset and offset = i - layer;
				int offset = i - layer;
				
				//storing the topmost
				int top = a[layer][i];
				
				//replace top by leftmost
				a[layer][i] = a[last-offset][layer];
				
				//replace leftmost by bottom 
				a[last-offset][layer] = a[last][last-offset];
				
				//replace bottom by rightmost
				a[last][last-offset] = a[i][last];
				
				//replace rightmost by the saved top element
				a[i][last] = top;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(a);
		rotateMatrixBy90(a);
		System.out.println();
		printMatrix(a);
	}

}
