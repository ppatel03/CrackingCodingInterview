/**
 * 
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 * 
 * Solution : Simple get the mid. Assign it as root node. Call The same function recursively to assign it as
 * left or right child
 * 
 */
package treesandgraphs;

/**
 * @author prashant
 *
 */



public class BinaryTreeFromSortedArray {
	
	
	//static nested class. Done purposely because there can be only one class of same name in package
	// and I wanted to have everything into the file so that users do not need to refer to different file
	// to access tree node
	static class TreeNode{
		TreeNode left,right;
		int data;
	}
	
	
	public static TreeNode createTreeFromSortedArray(int[] a, int low, int high){
		
		if(low <= high){
			int mid = (low+high)/2;
			TreeNode node = new TreeNode();
			node.data = a[mid];
			node.left = createTreeFromSortedArray(a, low, mid - 1);
			node.right = createTreeFromSortedArray(a, mid+1, high);
			return node;
		}
		else{
			return null;
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
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int[] input2 = {0,1,2,3,4,5,6,7};

		TreeNode root1 = createTreeFromSortedArray(input1, 0, input1.length-1);
		printTree(root1);
		
		System.out.println();
		TreeNode root2 = createTreeFromSortedArray(input2, 0, input2.length-1);
		printTree(root2);
	}

}
