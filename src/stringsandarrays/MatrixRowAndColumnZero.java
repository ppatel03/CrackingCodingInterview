/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 * 
 * Only catch is if you are using the same matrix then replacing entire row or column as zero might end up replacing
 * entire matrix as zero if we encounter such elements
 * 
 * So solution is keep single dimensional row array and column array. seti it to zero accordingly. Then use
 * these two arrays to populate the elements of the matrix
 * 
 */
package stringsandarrays;

/**
 * @author prashant
 *
 */
public class MatrixRowAndColumnZero {
	
	public static void printMatrix(int[][] a){
		for(int i = 0; i <a.length ; i++){
			for(int j =0 ;j <a[i].length;j++){
				System.out.print(a[i][j]+ "\t");
			}
			System.out.println();
		}
	}
	
	public static void replaceMatrixByZeros(int[][] a){
		int[] row = new int[a.length];
		int[] column = new int[a[0].length];
		int i,j ;
		for( i = 0 ; i < a.length ; i++){
			row[i] = 1;
		}
		
		for( i = 0 ; i < a[0].length ; i++){
			column[i] = 1;
		}
		
		for( i = 0; i <a.length ; i++){
			for( j =0 ;j <a[i].length;j++){
				if(a[i][j] == 0){
					row[i] = 0;
					column[j] = 0;
				}
			}
		}
		
		for( i = 0; i <a.length ; i++){
			for( j =0 ;j <a[i].length;j++){
				if(row[i] == 0 || column[j] == 0 ){
					a[i][j] = 0;
				}
			}
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a={{1,2,0,4},{5,6,7,8},{9,10,11,12},{0,14,15,16}};
		printMatrix(a);
		replaceMatrixByZeros(a);
		System.out.println();
		printMatrix(a);
	}

}
