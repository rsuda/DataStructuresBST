import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**p
 * Binary Search Tree that has multiple choices.
 * Resources: Book insert method code and print in
 * order method.
 * @author robin
 *
 */
public class PA2BST 
{
	/**
	 * The root is left static so it can be used
	 * for testing. Starts out null until first
	 * BinaryNode is added.
	 */
	public BinaryNode root;
	
	/**
	 * Sets the root null for an empty tree.
	 */
	public PA2BST()
	{
		this.root = null;
	}
	
	/**
	 * Adds new node to the tree. If it is empty it
	 * becomes the root.
	 * @param key the value being compared.
	 */
	public void addNode(int key)
	{
		BinaryNode newNode = new BinaryNode(key);
		
		//Sets first BinaryNode to the root.
		if (root==null)
		{
			root = newNode;
			return;
		}
		BinaryNode current = root;
		BinaryNode parent = null;
		
		//Determines if new BinaryNode becomes left or right child.
		while(true)
		{
			parent = current;
			if (key<current.key)
			{
				current = current.left;
				if(current==null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				current = current.right;
				if (current == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	/**
	 * Prints out the level order of the tree.
	 * For example if the nodes for this order:
	 * 
	 * 		4
	 * 	2		6
	 * 1 3	   5 7
	 * 
	 * The output would be: 4 2 6 1 3 5 7
	 */
	public void levelOrderTraversal()
	{
		//Queue is used to go in order according to levelOrder rules.
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty())
		{
			BinaryNode tempNode = queue.poll();
			System.out.printf("%d ", tempNode.key);
			if (tempNode.left != null)
			{
				queue.add(tempNode.left);
			}
			if (tempNode.right != null)
			{
				queue.add(tempNode.right);
			}
		}
		System.out.print("\n");
	}
	
	/**
	 * Prints out the in order of the tree.
	 * For example if the nodes for this order:
	 * 
	 * 		4
	 * 	2		6
	 * 1 3	   5 7
	 * 
	 * The output would be: 1 2 3 4 5 6 7
	 */
	public void inOrder()
	{
		Stack<BinaryNode> nodes = new Stack<BinaryNode>();
		BinaryNode current = root;
		
		while (!nodes.isEmpty() || current != null)
		{
			if (current != null)
			{
				nodes.push(current);
				current = current.left;
			}
			else
			{
				BinaryNode node = (BinaryNode) nodes.pop();
				System.out.printf("%d ", node.key);
				current = node.right;
			}
		}
		System.out.print("\n");
		
	}
	
	/**
	 * Determines the number of leaves using recursion.
	 * Starts with the root node and works throughout the
	 * tree.
	 * @param node the BinaryNode to check
	 * @return The amount of leaves.
	 */
	public int numLeaves(BinaryNode node)
	{
		if (node == null)
		{
			return 0;
		}
		else if (node.left == null && node.right == null)
		{
			return 1;
		}
		else
		{
			return numLeaves(node.left) + numLeaves(node.right);
		}
	}
	
	/**
	 * Finds the amount of half nodes.
	 * Checks to see if a node has either a
	 * left or right child but not both. Also 
	 * both children cannot be null, one has to be filled.
	 * @return the amount of half nodes.
	 */
	public int numOneChildNodes()
	{
		if (root == null)
		{
			return 0;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		
		int count = 0;
		while (!queue.isEmpty())
		{
			BinaryNode temp = queue.poll();
			if (temp.left != null && temp.right == null || temp.left == null && temp.right != null)
			{
				count++;
			}
			if (temp.left != null)
			{
				queue.add(temp.left);
			}
			if (temp.right != null)
			{
				queue.add(temp.right);
			}
		}
		return count;
	}
	
	/**
	 * Finds the amount of full nodes.
	 * Very similar to numOneChildNodes()
	 * with the key difference of checking to see if both
	 * left and right children are not null.
	 * @return the amount of full nodes.
	 */
	public int numTwoChildrenNodes()
	{
		if (root == null)
		{
			return 0;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		
		int count = 0;
		while (!queue.isEmpty())
		{
			BinaryNode temp = queue.poll();
			if (temp.left != null && temp.right != null)
			{
				count++;
			}
			if (temp.left != null)
			{
				queue.add(temp.left);
			}
			if (temp.right != null)
			{
				queue.add(temp.right);
			}
		}
		return count;
	}
	
	/**
	 * The main program that takes the users input
	 * to create a tree. It can also find the amount 
	 * of leaves, half nodes, and full nodes in a tree.
	 * 
	 * @param arg
	 */
	public static void main(String arg[])
	{
		Scanner in = new Scanner(System.in);
		int input = 7;
		PA2BST tree = new PA2BST();
		//Repeats until 7 is chosen.
		do
		{
			//Repeats until valid input is chosen.
			do
			{
				int choice = 0;
				System.out.print(">> Enter choice [1-7] from menu below:");
				System.out.println("");
				System.out.println("\t1) Insert node");
				System.out.println("\t2) Print tree");
				System.out.println("\t3) Print number of leaves in tree");
				System.out.println("\t4) Print the number of nodes in T that contain only one child");
				System.out.println("\t5) Print the number of nodes in T that contain only two children");
				System.out.println("\t6) Print the level order traversal of the tree");
				System.out.println("\t7) Exit program");
				System.out.println("Enter choice: ");
				//Makes sure user chooses a valid number.
				try
				{
					choice = in.nextInt();
				}
				catch (InputMismatchException e)
				{
					choice = 10;
					in.nextLine();
				}
				input = choice;
			}while (input > 7 || input < 1);
			if (input == 1)
			{
				int value = 0;
				boolean flag = true;
				//Makes sure user chooses a number for the node.
				do
				{
					flag = true;
					try
					{
						System.out.println("Enter a node value: ");
						value = in.nextInt();
					}
					catch (InputMismatchException e)
					{
						flag = false;
						in.nextLine();
					}
				}while (flag == false);
				tree.addNode(value);
			}
			
			//Prints out the tree in order.
			else if (input == 2)
			{
				tree.inOrder();
			}
			
			//Prints the amount of leaves in the tree.
			else if (input == 3)
			{
				System.out.println(tree.numLeaves(tree.root));
			}
			
			//Prints the amount of half nodes.
			else if (input == 4)
			{
				System.out.println(tree.numOneChildNodes());
			}
			
			//Prints the amount of full nodes.
			else if (input == 5)
			{
				System.out.println(tree.numTwoChildrenNodes());
			}
			
			//Prints the tree in level order.
			else if (input == 6)
			{
				tree.levelOrderTraversal();
			}
			
		}while (input != 7);
		//closes the scanner for input.
		in.close();
	}

}

