/**
 * 
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 * 
 */
package treesandgraphs;



/**
 * @author prashant
 *
 */
public class CommonAncestor {

	//static nested class. Done purposely because there can be only one class of same name in package
	// and I wanted to have everything into the file so that users do not need to refer to different file
	// to access tree node
	static class TreeNode{
		TreeNode left,right,parent;
		int data;
		
		public String toString(){
			return ""+data;
		}
	}

	/**
	 * 
	 * @param input
	 * @param index
	 * @return the Tree Representation from Array Input
	 */
	public static TreeNode buildTreeFromArray(int[] input, int index, TreeNode parent){
		TreeNode r = null;
		if(input.length <= index || (index <= input.length && input[index] == -1)){
			return r;
		}
		else{
			r = new TreeNode();

			r.parent = parent;

			r.data = input[index];

			r.left = buildTreeFromArray(input, 2*index +1, r);

			r.right = buildTreeFromArray(input, 2*index+2,r);

			return r;
		}
	}

	/**
	 * prints the tree
	 * 
	 * @param root
	 */
	public static void printTree(TreeNode root){
		if(root !=null){
			System.out.print(root.data);
			if(root.parent != null){
				System.out.print("= parent --> "+root.parent.data);
			}

			if(root.left != null){
				System.out.print(" & left child--> "+root.left.data);

			}
			if(root.right != null){
				System.out.print(" & right child--> "+root.right.data);

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
	 * 
	 * @param node1
	 * @param node2
	 * @return the common ancestor using parent reference and flag variable as data setting it to -1
	 */
	public static TreeNode getCommonAncestorUsingParentDataStructure(TreeNode node1, TreeNode node2){

		if(node1 != null && node2 != null){
			while(node1.parent != null){
				TreeNode parent = node1.parent;
				parent.data = -1; // indicating visited
			}
			
			while(node2.parent != null){
				TreeNode parent = node2.parent;
				if(parent.data == -1){
					return parent;
				}
				
			}
			return null;
		}
		else{
			return null;
		}
	}
	
	/**
	 * 
	 * @param currentNode
	 * @param node1
	 * @return
	 */
	public static boolean isThisAncestorOfGivenNode(TreeNode currentNode, TreeNode node1){
		if(currentNode == null){
			return false;
		}
		else if(currentNode.data == node1.data){
			return true;
		}		
		else{
			return isThisAncestorOfGivenNode(currentNode.left, node1) ||
					isThisAncestorOfGivenNode(currentNode.right, node1);
		}
	}
	
	/**
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return the first common Ancestor
	 */
	public static TreeNode getFirstCommonAncestorOfTwoNodesWithoutUsingParent(TreeNode root,TreeNode node1, TreeNode node2){
		
		if(isThisAncestorOfGivenNode(root.left, node1) && isThisAncestorOfGivenNode(root.left, node2)){
			
			return getFirstCommonAncestorOfTwoNodesWithoutUsingParent(root.left, node1, node2);
		}
		if(isThisAncestorOfGivenNode(root.right, node1) && isThisAncestorOfGivenNode(root.right, node2)){
			
			return getFirstCommonAncestorOfTwoNodesWithoutUsingParent(root.right, node1, node2);
		}
		
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {0,1,2,3,4,5,6,-1,-1,-1,-1,-1,-1,-1,14};
		int[] input2 = {0,1,2,3,4,-1,-1,7};

		TreeNode root1 = buildTreeFromArray(input1, 0,null);
		printTree(root1);

		System.out.println();
		TreeNode root2 = buildTreeFromArray(input2, 0,null);
		printTree(root2);
		
		System.out.println();
		
		TreeNode node1 = new TreeNode();
		node1.data = 5;
		
		TreeNode node2 = new TreeNode();
		node2.data = 14;
		
		//System.out.println("First Common Ancestor between node:"+node1.data+" and node:"+node2.data+" "
		//		+ " by using Additional DS is : "+getCommonAncestorUsingParentDataStructure(node1, node2));
		
		System.out.println("First Common Ancestor between node:"+node1.data+" and node:"+node2.data+" "
				+ " without using Additional DS is : "+getFirstCommonAncestorOfTwoNodesWithoutUsingParent(root1, node1, node2));
		
		TreeNode node3 = new TreeNode();
		node3.data = 7;
		
		TreeNode node4 = new TreeNode();
		node4.data = 4;
		
		//System.out.println("First Common Ancestor between node:"+node3.data+" and node:"+node4.data+" "
		//		+ " by using Additional DS is : "+getCommonAncestorUsingParentDataStructure(node3, node4));
		
		System.out.println("First Common Ancestor between node:"+node3.data+" and node:"+node4.data+" "
				+ " without using Additional DS is : "+getFirstCommonAncestorOfTwoNodesWithoutUsingParent(root2, node3, node4));

	}

}
