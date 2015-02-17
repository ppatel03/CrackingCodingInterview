/**
 * 
 * You have two very large binary trees: T1, with millions of nodes,
 *  and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * 
 */
package treesandgraphs;

import treesandgraphs.LinkListOfTreeLevel.TreeNode;



/**
 * @author prashant
 *
 */
public class SubtreeDetection {

	//static nested class. Done purposely because there can be only one class of same name in package
	// and I wanted to have everything into the file so that users do not need to refer to different file
	// to access tree node
	static class TreeNode{
		TreeNode left,right;
		int data;
	}

	/**
	 * 
	 * @param input
	 * @param index
	 * @return the Tree Representation from Array Input
	 */
	public static TreeNode buildTreeFromArray(int[] input, int index){
		TreeNode r = null;
		if(input.length <= index || (index <= input.length && input[index] == -1)){
			return r;
		}
		else{
			r = new TreeNode();
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
	public static void printTree(TreeNode root){
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


	public static boolean isTwoTreesMatching(TreeNode node1, TreeNode node2){
		if(node1 == null && node2 == null){
			return true;
		}
		else if(node1 != null && node2 != null){			

			if(node1.data == node2.data){
				return isTwoTreesMatching(node1.left, node2.left) &&
						isTwoTreesMatching(node1.right, node2.right);
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}	

	}

	public static boolean isOneTreeSubTreeOfAnother(TreeNode root1, TreeNode root2){
		if(root1 == null ){
			return false;
		}

		if(root1.data == root2.data){
			return isTwoTreesMatching(root1, root2);
		}
		else{
			return isOneTreeSubTreeOfAnother(root1.left, root2) ||
					isOneTreeSubTreeOfAnother(root1.right, root2);
		}


	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {0,1,2,3,4,5,6,-1,-1,-1,-1,-1,-1,-1,14};
		int[] input2 = {1,3,4};

		TreeNode root1 = buildTreeFromArray(input1, 0);
		printTree(root1);

		System.out.println();
		TreeNode root2 = buildTreeFromArray(input2, 0);
		printTree(root2);

		System.out.println(" Is Subtree : "+isOneTreeSubTreeOfAnother(root1, root2));
	}

}
