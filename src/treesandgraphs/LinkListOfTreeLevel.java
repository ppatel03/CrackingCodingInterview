/**
 * 
 * Given a binary search tree, design an algorithm which 
 * creates a linked list of all the nodes at each depth (i.e., if you have a tree with depth D, you’ll have D linked lists).
 * 
 */
package treesandgraphs;

import java.util.ArrayList;
import java.util.List;


/**
 * @author prashant
 *
 */
public class LinkListOfTreeLevel {

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
	 * Process like the BFS traversal technique but store it in a linklist
	 * 
	 * @param node
	 * @param treeNodeList
	 */
	public static void createLinkListOfNodesAtEachDepth(TreeNode node, List<List<TreeNode>> treeNodeList){
		if(node != null){
			List<TreeNode> list = new ArrayList<TreeNode>();
			list.add(node);

			treeNodeList.add(list);
			int level = 0;

			while(true){
				List<TreeNode> treeLevelList = treeNodeList.get(level);

				List<TreeNode> treeNextLevelList = new ArrayList<TreeNode>();


				for(int j = 0 ; j < treeLevelList.size() ; j++){					

					TreeNode nodeAtLevel = treeLevelList.get(j);

					if(node != null){
						if(nodeAtLevel.left != null){
							treeNextLevelList.add(nodeAtLevel.left);
						}

						if(nodeAtLevel.right != null){
							treeNextLevelList.add(nodeAtLevel.right);
						}
					}
				}

				if(treeNextLevelList.isEmpty()){
					break;
				}
				else{
					treeNodeList.add(treeNextLevelList);
					level ++;
				}
			}
		}

	}
	
	/**
	 * prints the Tree Level by Level
	 * @param treeNodeList
	 */
	public static void printListLevelByLevel(List<List<TreeNode>> treeNodeList){
		System.out.println("Printing List Level by Level");
		for(List<TreeNode> treeNodes: treeNodeList){
			for(TreeNode treeNode : treeNodes){
				System.out.print(treeNode.data+"\t");
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int[] input1 = {0,1,2,3,4,5,6,-1,-1,-1,-1,-1,-1,-1,14};
		int[] input2 = {0,1,2,3,4,-1,-1,7};

		TreeNode root1 = buildTreeFromArray(input1, 0);
		printTree(root1);

		System.out.println();
		TreeNode root2 = buildTreeFromArray(input2, 0);
		printTree(root2);

		List<List<TreeNode>> treeNodeList1 = new ArrayList<List<TreeNode>>();
		List<List<TreeNode>> treeNodeList2 = new ArrayList<List<TreeNode>>();
		
		createLinkListOfNodesAtEachDepth(root1,treeNodeList1);
		createLinkListOfNodesAtEachDepth(root2,treeNodeList2);

		
		printListLevelByLevel(treeNodeList1);
		printListLevelByLevel(treeNodeList2);



	}

}
