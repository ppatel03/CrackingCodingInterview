package treesandgraphs;


class Node {
	   Node left;
	   Node right;
	   int data;
	}

public class TreeFlipRecursive {

	

	/**
	 * 
	 * @param input
	 * @param index
	 * @return the Tree Representation from Array Input
	 */
	public  Node buildTreeFromArray(int[] input, int index){
		Node r = null;
		if(input.length <= index || (index <= input.length && input[index] == -1)){
			return r;
		}
		else{
			r = new Node();
			r.data = input[index];

			r.left = buildTreeFromArray(input, 2*index +1);
			r.right = buildTreeFromArray(input, 2*index+2);

			return r;
		}
	}

	/**
	 * prints the tree
	 * 
	 * @param root
	 */
	public  void printTree(Node root){
		if(root !=null){
			System.out.print(root.data);
			if(root.left != null){
				System.out.print("= left--> "+root.left.data);

			}
			if(root.right != null){
				System.out.print("= right--> "+root.right.data);

			}
			System.out.println();
			if(root.left != null){
				printTree(root.left);
			}

			if(root.right != null){
				printTree(root.right);
			}

		}

	}
	
	
	/**
	 * Recursive function to Flip  the Nodes in the tree
	 * @param args
	 */
	public Node flipNode(Node root){
		
		if(root == null){
			return null;
		}
		else{
			root.left = flipNode(root.left);
			root.right = flipNode(root.right);
			
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			
			return root;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] input1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int[] input2 = {1,2,3};

		TreeFlipRecursive treeFlip = new TreeFlipRecursive();
		
		Node root1 = treeFlip.buildTreeFromArray(input1, 0);
		treeFlip.printTree(root1);

		System.out.println();
		Node root2 = treeFlip.buildTreeFromArray(input2, 0);
		treeFlip.printTree(root2);
		
		System.out.println("--- Flipping the Tree 1 --- ");
		System.out.println();
		
		Node flippedRoot1 = treeFlip.flipNode(root1);
		treeFlip.printTree(flippedRoot1);
		
		System.out.println("--- Flipping the Tree 2 --- ");
		System.out.println();
		
		Node flippedRoot2 = treeFlip.flipNode(root2);
		treeFlip.printTree(flippedRoot2);

		
	}

}
