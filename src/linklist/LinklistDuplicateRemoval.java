package linklist;

public class LinklistDuplicateRemoval {
	
	
	public Node removeDuplicates(Node root){
		Node runner = root.next;
		
		while(runner != null){
			Node current = root;
			
			//if the first node is a duplicate
			if(current.data == runner.data){
				current = current.next;
				root= root.next;
			} else {
				// looping from current till next
				while(current.next != runner){					
					if(current.next.data == runner.data){
						current.next = current.next.next;
						break;
					}					
					current = current.next;
				}
			}
			
			runner = runner.next;
		}
		
		return root;		
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

		LinklistDuplicateRemoval linkListDuplicateRemoval = new LinklistDuplicateRemoval();
		Node root = new Node(0, new Node (1, new Node(2, new Node(3, new Node (4, new Node(2,new Node (3, new Node (2,null))))))));		

		System.out.println("The link List before removing duplicates ");
		linkListDuplicateRemoval.display(root);
		System.out.println();
		
		linkListDuplicateRemoval.removeDuplicates(root);
		System.out.println("The link List after removing duplicates ");
		linkListDuplicateRemoval.display(root);
		System.out.println();
	}

}
