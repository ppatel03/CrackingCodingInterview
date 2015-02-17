/**
 * 
 * Question : 
 * Given a time, calculate the angle between the hour and minute hands.
 * 
 * This code is simple. It based on a General Formula :
 * 
 *  Minute Hand covers 6 degree in 1 minute.
 *  So total degrees covered By minute hand = 6 degree * (no of minutes)
 *  But When Minute Hand moves, Hour hand also moves slightly 
 *  So Hour Hand moves 0.5 degree per minute when  minute hand moves ( the fact that 3 hours cover 180 minutes and 90 degrees)
 *  Additionally Hour Hand movies 30 degree per hour 
 *  So total degree covered by hour hand = (30 degree * no of hours) + (0.5 degree * no of minutes)
 *  
 *  So difference between hour hand and minute hand 
 *  		=  Absolute Value of (total degrees covered By minute hand - total degree covered by hour hand)
 *  		=  Absolute Value of ((6 degree * no of minutes) - ((30 degree * no of hours) + (0.5 degree * no of minutes)))
 *   	  	=  Absolute Value of ((6 degree * no of minutes) -  (0.5 degree * no of minutes) - (30 degree * no of hours) )
 * 			=  Absolute Value of ((5.5 degree * no of minutes) -   (30 degree * no of hours) )
 */

package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author prashant
 *
 */
public class AngleDifferenceBetweenHourHandMiniuteHand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfHours = -1, noOfMinutes = -1;
		

		try {
			System.out.println("Enter The Number of Hours");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			noOfHours = Integer.parseInt(br.readLine());

			System.out.println("Enter The Number of Minutes");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			noOfMinutes = Integer.parseInt(br1.readLine());
			
			Double angleDifference = Math.abs((5.5 * noOfMinutes) - (30 * noOfHours));
			
			System.out.println("The Angle Difference is "+angleDifference);

		} 
		catch (Exception e) {
			e.printStackTrace();
		}


	}

}
