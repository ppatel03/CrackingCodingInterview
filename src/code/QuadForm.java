package code;

public class QuadForm {

	public static boolean checkPoss (int[]a, int combo, int index1, int index2){
		System.out.println(combo);
		
		for(int i = 0 ; i < a.length && i != (index1) && i != (index2); i++){
			System.out.print(" --- "+i);
			if(combo > a[i]){
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a = {22, 39, 3, 21};
		
		int combo1 = a[0]+a[1];
		int combo2 = a[0]+a[2];
		int combo3 = a[0]+a[3];
		int combo4 = a[1]+a[2];
		int combo5 = a[1]+a[3];
		int combo6 = a[2]+a[3];

		int count = 0;
		
		if(checkPoss(a,combo1,0,1)){
			count++;
		}
		if(checkPoss(a,combo2,0,2)){
			count++;
		}
		if(checkPoss(a,combo3,0,3)){
			count++;
		}
		if(checkPoss(a,combo4,1,2)){
			count++;
		}
		if(checkPoss(a,combo5,1,3)){
			count++;
		}
		if(checkPoss(a,combo6,2,3)){
			count++;
		}
		
		System.out.println(count == 2);
	}

}
