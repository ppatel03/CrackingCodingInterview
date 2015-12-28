/**
 * 
 */
package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author prashant
 *
 */
public class KeywordCount {

	/**
	 * reads the input file and stores the name and its occurrence using Java HashMap
	 * @param fileName
	 * @param keyCountMap
	 */
	public void readFromFileAndCountOccurrences(String fileName, Map<String, Integer> keyCountMap){
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(fileName));

			String line = null;

			while((line = br.readLine()) !=null ){
				//removing the leading and trailing whitespace
				line = line.trim();
				//splitting the string
				String[] keyCountArray = line.split(",");
				//check if array contains atleast name and size
				if(keyCountArray != null && keyCountArray.length == 2){
					String name = keyCountArray[0];
					Integer currentCount = Integer.parseInt(keyCountArray[1].trim());
					
					//check if name already exists in hashmap
					Integer countByName = keyCountMap.get(name);
					if(countByName != null){
						keyCountMap.put(name, countByName + currentCount);
					} else{
						keyCountMap.put(name,currentCount);
					}
				} else {
					//contain key count pair in incorrect format
					System.out.println(" Incorrect File Data");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Please verfiy the input file location.");
			e.printStackTrace();
		} catch (IOException e){
			System.out.println("Exception while dealing with I/O operations.");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Exception while conversion String to Integer.");
			e.printStackTrace();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * iterates through every entry in the Map and print the occurrences
	 * @param keyCountMap
	 */
	public void printNameWithOccurrences(Map<String,Integer> keyCountMap){
		for(Map.Entry<String,Integer> entry : keyCountMap.entrySet()){
			System.out.print("The total for "+entry.getKey()+" is "+entry.getValue()+". ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// LinkedHashMap because the output seems to be in order
		Map<String, Integer> keyCountMap = new LinkedHashMap<String,Integer>();

		//name of the file
		String fileName = "key-count.txt";
		
		KeywordCount keywordCount = new KeywordCount();

		//calling the instance method to read the file and store the data into Linked Hash Map
		keywordCount.readFromFileAndCountOccurrences(fileName, keyCountMap);
		
		//display the required output
		keywordCount.printNameWithOccurrences(keyCountMap);
	}

}
