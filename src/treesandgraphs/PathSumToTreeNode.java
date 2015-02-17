/**
 * 
 * You are given a binary tree in which each node contains a value. 
 * Design an algorithm to print all paths which sum up to that value.
 *  Note that it can be any path in the tree - it does not have to start at the root.
 * 
 */
package treesandgraphs;

import java.util.ArrayList;
import java.util.List;

import treesandgraphs.SubtreeDetection.TreeNode;

/**
 * @author prashant
 *
 */
public class PathSumToTreeNode {
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

	/**
	 * 
	 * @param sum
	 * @param node
	 * @param pathData
	 */
	public static void printPathSum(int sum, TreeNode node, List<Integer> pathData){
		if(node != null){
			int data = node.data;

			pathData.add(data);
			int pathSum = sum;
			for(int i = pathData.size() -1 ; i >= 0  ; i--){
				pathSum -= pathData.get(i);
				
				if(pathSum == 0){
					System.out.println("\nPrinting Paths : ");

					//printing the paths
					for(int j = i ; j < pathData.size(); j++){
						System.out.print(pathData.get(j)+" ");
					}
					System.out.println();
				}				
			}

			//since list is passed by Reference, we need to send the copy
			List<Integer> newList1 = new ArrayList<Integer>();
			List<Integer> newList2 = new ArrayList<Integer>();

			for(Integer i : pathData){
				newList1.add(i);
				newList2.add(i);
			}
			
			printPathSum(sum, node.left, newList1);
			printPathSum(sum, node.right, newList2);

		}
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
		
		int sum1 = 5;
		int sum2 = 10;
		
		List<Integer> pathData1 = new ArrayList<Integer>();
		System.out.print("\n Path for Tree 1 containing sum : "+sum1+" : ");
		printPathSum(sum1, root1, pathData1);
		
		
		List<Integer> pathData2 = new ArrayList<Integer>();
		System.out.print("\n Path for Tree 1 containing sum : "+sum2+" : ");
		printPathSum(sum2, root2, pathData2);
	}

}
