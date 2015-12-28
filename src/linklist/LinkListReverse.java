/**
 * Reverse the singly link list both ways - iteratively and recursively
 */
package linklist;


public class LinkListReverse {


	/**
	 * 
	 * @param root
	 * @return the reversed list recursively
	 */
	public Node reverseRecursive(Node root){
		if(root == null){
			return null;
		} else if (root.next == null) {
			return root;
		} else{
			
			//taking the next element
			Node next = root.next;
			
			//unliking it from the list
			root.next = null;
			
			//reverse everything from next element
			Node reversedList = reverseRecursive(next);
			
			//now point the the next element back to the root
			next.next = root;
			
			return reversedList;
		}			
	}

	/**
	 * display the elements of the link list recursively
	 * @param root
	 */
	public void display(Node root){
		if (root != null){
			System.out.print(root.data + " ");
			display(root.next);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkListReverse linkListReverse = new LinkListReverse();
		Node root = new Node(0, new Node (1, new Node(2, new Node(3, new Node (4, null)))));		

		System.out.println("The link List before reverse ");
		linkListReverse.display(root);
		System.out.println();
		Node newRoot = linkListReverse.reverseRecursive(root);
		System.out.println("The link List after reverse ");
		linkListReverse.display(newRoot);
	}

}
