package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class Bubblesort {
	void Sort(int a[])
	{
		int len = a.length;
		int temp, count=0;
		
		for(int i= len-1; i>=0; i--)
		{
			for (int j=0; j<i; j++)
			{
				if(a[j] > a[j+1])
				{
					count++;
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println(count);
		for(int i=0; i<= len-1; i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println("\n\n");
	}
	
	
	public static void main(String[] args) {
		BufferedReader br = null;
		String currentLine = null;
		String[] inputStringArray = null;
		try {
			br = new BufferedReader(new FileReader("Bubble-sort_InputForSubmission_2.txt"));
		    while ((currentLine =br.readLine())  != null) {
		    	inputStringArray = currentLine.split("\\s+");
		    }
		    br.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		int a[] = new int[inputStringArray.length];
		for(int i =0 ; i < a.length ; i++){
			a[i] = Integer.parseInt(inputStringArray[i]);
		}
		
		Bubblesort b = new Bubblesort();
		b.Sort(a);
	}
	
}