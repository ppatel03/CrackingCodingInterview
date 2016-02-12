package code;

public class IsItPossible {

	

	public static String isItPossible(int a, int b, int c, int d){
		
		if(a == c && b == d){
			return "YES";
		}  
		int sum = a + b;
		System.out.println("sum is "+sum);
		if(sum <= c){
			return isItPossible(sum, b, c, d);
		}  
		if (sum<=d) {
			return isItPossible(a, sum, c, d);
		}  
		return "NO";
	} 



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isItPossible(1, 4, 1, 1));
	}

}
