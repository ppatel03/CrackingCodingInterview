/**
 * 
 * Write an algorithm to find the ‘next’ node 
 * (i.e., in-order successor) of a given node in a binary search tree where each node has a link to its parent.
 * 
 * Solution:
 * 
 * Case 1 : if its a root node or whose right child is not null, get its successor by 
		going to the extreme left child of the node's right child or get its immediate
		right child if it has no left child
		
   Case 2 :  if its right child is null and its left child of its parent, then parent
		 is the successor
		 
   Case 3 : if its  right child is null and its a right child of its parent, then
		 return then loop through its parent till the parent becomes the left child
 * 
 */
package treesandgraphs;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * @author prashant
 *
 */
public class InorderSuccessor {

	//static nested class. Done purposely because there can be only one class of same name in package
	// and I wanted to have everything into the file so that users do not need to refer to different file
	// to access tree node
	static class TreeNode{
		TreeNode left,right,parent;
		int data;
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
	 * @param r
	 * @return the inorder successor of the given node
	 */
	public static TreeNode getInorderSuccessor(TreeNode r){

		TreeNode parent = r.parent;
		//if its a root node or whose right child is not null, get its successor by 
		//going to the extreme left child of the node's right child or get its immediate
		//right child if it has no left child
		if(parent == null || r.right != null){
			TreeNode node = r.right;
			while(node.left != null){
				node = node.left;
			}
			return node;
		}
		// if its right child is null and its left child of its parent, then parent
		// is the successor
		else if(r.right == null && parent.left != null && parent.left.data == r.data){
			return parent;
		}

		// if its both right child is null and its a right child of its parent, then
		// return then loop through its parent till the parent becomes the left child
		else if(r.right == null &&  parent.right != null && parent.right.data == r.data){
			TreeNode oldParent = r;
			while( parent.right.data == oldParent.data){
				oldParent = parent;
				parent = parent.parent;
				if(parent == null || parent.right == null){
					break;
				}
			}
			return parent;
		}
		else{
			return null;
		}
	}
	
	public static void displayInorderSucessorForEachAndEveryNode(TreeNode r){
		
		System.out.println("\nDisplaying Inorder Successor of every Node BFS wise");
		
		Queue<TreeNode> q = new ArrayBlockingQueue<TreeNode>(10) ;
		q.add(r);
		
		while(!q.isEmpty()){
			TreeNode node = (TreeNode)q.remove();
			
			TreeNode inorderSuccessor = getInorderSuccessor(node);
			
			System.out.print("\nProcessing Node : "+node.data);
			
			if(inorderSuccessor != null){
				System.out.print(" and its inorder successor is "+inorderSuccessor.data);
			}					
			
			if(node.right != null){
				q.add(node.right);
			}
			
			if(node.left != null){
				q.add(node.left);
			}
		}
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
		
		displayInorderSucessorForEachAndEveryNode(root1);
		displayInorderSucessorForEachAndEveryNode(root2);
		
	}

}
