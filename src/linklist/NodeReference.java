package linklist;

public class NodeReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(1,null);
		Node n2 = new Node(2,null);
		Node n3 = n1;n1.data=6;
		n1 = n2;
		
		System.out.println("n1 = "+n1.data);
		System.out.println("n2 = "+n2.data);
		System.out.println("n3 = "+n3.data);
	}

}
