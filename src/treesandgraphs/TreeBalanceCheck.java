/**
 * 
 * Implement a function to check if a tree is balanced. For the purposes of this question,
 *  a balanced tree is defined to be a tree such that no two leaf nodes differ in distance 
 *  from the root by more than one.
 * 
 */
package treesandgraphs;


/**
 * @author prashant
 *
 */




public class TreeBalanceCheck {	

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


	public static int getMaxTreeHeight(TreeNode node){
		if(node == null){
			return 0;
		}
		else{
			return 1+Math.max(getMaxTreeHeight(node.left),getMaxTreeHeight(node.right));
		}
	}

	/**
	 * Recursive unoptimized technique --> O( n^2 ) complexity
	 * 
	 * @param node
	 */
	public static boolean checkTreeBalancedMethod1(TreeNode node){
		if(node == null){
			return true;
		}
		if(node.left == null && node.right == null){
			return true;
		}
		else{
			int leftHeight = getMaxTreeHeight(node.left);
			int rightHeight = getMaxTreeHeight(node.right);

			int difference = Math.abs(leftHeight - rightHeight);

			return difference <= 1 && checkTreeBalancedMethod1(node.left) &&
					checkTreeBalancedMethod1(node.right);
		}
	}

	/**
	 * Recursive optimized technique --> O( n ) complexity
	 * 
	 * @param node
	 */
	public static int checkTreeBalancedMethod2(TreeNode node){

		if(node == null){
			return 0;
		}
		else{
			int leftHeight = checkTreeBalancedMethod2(node.left);

			if(leftHeight == -1){
				return -1;
			}

			int rightHeight = checkTreeBalancedMethod2(node.right);

			if(rightHeight == -1){
				return -1;
			}


			int difference = Math.abs(leftHeight - rightHeight);

			if(difference > 1){
				return -1;
			}
			else{
				return 1 + Math.max(leftHeight,rightHeight);
			}
		}		
	}

	/**
	 * 
	 * A another optimizsed method using maxdepth mindepth logic
	 * 
	 * @param node
	 * @return true if the Tree
	 */
	public static boolean checkTreeBalancedMethod3(TreeNode node){
		return Math.abs(getMaxDepth(node) - getMinDepth(node)) <= 1;
	}

	/**
	 * 
	 * @param node
	 * @return the max depth of the tree
	 */
	public static int getMaxDepth(TreeNode node){
		if(node == null){
			return 0;
		}
		else return 1 + Math.max(getMaxDepth(node.left),getMaxDepth(node.right));
	}

	/**
	 * 
	 * @param node
	 * @return the min depth of the tree
	 */
	public static int getMinDepth(TreeNode node){
		if(node == null){
			return 0;
		}
		else return 1 + Math.min(getMinDepth(node.left),getMinDepth(node.right));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {0,1,2,3,4,5,6,-1,-1,-1,-1,-1,-1,-1,14};
		int[] input2 = {0,1,2,3,4,-1,-1,7};

		TreeNode root1 = buildTreeFromArray(input1, 0);
		printTree(root1);

		System.out.println();
		TreeNode root2 = buildTreeFromArray(input2, 0);
		printTree(root2);

		System.out.println(" Tree Balance by Method 1 for input 1: "+checkTreeBalancedMethod1(root1));
		System.out.println(" Tree Balance by Method 1 for input 2: "+checkTreeBalancedMethod1(root2));

		System.out.println();

		System.out.println(" Tree Balance by Method 2 for input 1: "+(checkTreeBalancedMethod2(root1) != -1));
		System.out.println(" Tree Balance by Method 2 for input 2: "+(checkTreeBalancedMethod2(root2) != -1));

		System.out.println();

		System.out.println(" Tree Balance by Method 3 for input 1: "+checkTreeBalancedMethod3(root1));
		System.out.println(" Tree Balance by Method 3 for input 2: "+checkTreeBalancedMethod3(root2));

	}

}
