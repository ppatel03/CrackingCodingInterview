package code;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MatrixRepresentation {
	public static final String inputFileName = "PracticeInput.txt";

	public int getCharCount(String input, char c){
		int charCount = 0;
        for(int i =0 ; i<input.length(); i++){
            if(input.charAt(i) == c){
                charCount++;
            }
        }
        return charCount;
	}
	
	public void readFromInputFile(){
		int noOfMatrices = 0;
		String currentLine2 = null;

		BufferedReader br2 = null;
		try{
			br2 = new BufferedReader(new FileReader(inputFileName));
			while ((currentLine2 =br2.readLine())  != null) {
				noOfMatrices = getCharCount(currentLine2, '|')/2;
				
			}
		} catch (Exception e){
			
		}
		
		
		
		String currentLine = null;
		BufferedReader br = null;
		String[] inputStringArray = null;
		int limit1 = 0;
		List<Integer> m1 = new ArrayList<Integer>();
		List<Integer> m2 = new ArrayList<Integer>();

		try{
			
			br = new BufferedReader(new FileReader(inputFileName));
			while ((currentLine =br.readLine())  != null) {
				currentLine = currentLine.trim();
		    	 for (int i = 0 ; i < currentLine.length() ; i++){
		    		 char c = currentLine.charAt(i);

		    		 if( c == '|' && i != 0 && limit1 == 0){
		    			 limit1 = i;
		    		 } else if ( c== ' '){
		    			 
		    		 } else {
		    			 
		    		 }
		    		 
		    		 
		    	 }
		    }
		} catch (Exception e){
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
