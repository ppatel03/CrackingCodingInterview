package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class HappyNumber
{
	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	void HappyNumberCode(int a[])
	{
		for(int i=0 ; i< a.length; i++)
		{
			int number = a[i];
			int count = 0;
			if(number == 1 || number > 50000)
			{
				count --;
			}
			
		
			while (number >= 1 && number <=500000 && !hash.containsKey(number))
			{
				hash.put(number, number);
				int sum = 0;
				while(number <=500000 && number >0)
				{
					int n = number%10;
					number = number/10;
					sum = sum + (n*n);
				}
				count++;
				number = sum;
			}
			if (number == 1)
			{
				System.out.println("happy " + count);
			}
			else
			{
				System.out.println("unhappy " + count);
			}
		}
	}
    public static void main(String[] args)
    {
		BufferedReader br = null;
		String currentLine = null;
		String[] inputStringArray = null;
		List<Integer> sample = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader("PracticeInput.txt"));
		    while ((currentLine =br.readLine())  != null) {
		    	sample.add(Integer.parseInt(currentLine));
		    }
		    br.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		int a[] = new int[inputStringArray.length];
		for(int i =0 ; i < a.length ; i++){
			a[i] = Integer.parseInt(inputStringArray[i]);
		}
		System.out.println(a.length);
//        System.out.print("Please enter a number: ");
//        int number = new Scanner(System.in).nextInt(), value;
//    	int[] a = new int[1];
//		a[0]=65;
	
        HappyNumber happy = new HappyNumber();
        happy.HappyNumberCode(a);
    }
}