import static org.junit.Assert.*;

import org.junit.Test;

public class Tests 
{

	@Test
	public void testOneChild() 
	{
		PA2BST test = new PA2BST();
		test.addNode(9);
		test.addNode(4);
		test.addNode(3);
		test.addNode(7);
		test.addNode(5);
		test.addNode(8);
		test.addNode(11);
		test.addNode(18);
		test.addNode(16);
		test.addNode(17);
		test.addNode(6);
		
		assertEquals(4, test.numOneChildNodes());
	}
	
	@Test
	public void testTwoChild() 
	{	
		PA2BST test = new PA2BST();
		test.addNode(9);
		test.addNode(4);
		test.addNode(3);
		test.addNode(7);
		test.addNode(5);
		test.addNode(8);
		test.addNode(11);
		test.addNode(18);
		test.addNode(16);
		test.addNode(17);
		test.addNode(6);
		assertEquals(3, test.numTwoChildrenNodes());
	}
	
	@Test
	public void testnumLeaves() 
	{	
		PA2BST test = new PA2BST();
		test.addNode(9);
		test.addNode(4);
		test.addNode(3);
		test.addNode(7);
		test.addNode(5);
		test.addNode(8);
		test.addNode(11);
		test.addNode(18);
		test.addNode(16);
		test.addNode(17);
		test.addNode(6);
		assertEquals(4, test.numLeaves(test.root));
	}

	/**
	 * 
	@Test
	public void testnumLeaves() 
	{	
		BinarySearchTree test = new BinarySearchTree();
		test.addNode(9);
		test.addNode(4);
		test.addNode(3);
		test.addNode(7);
		test.addNode(5);
		test.addNode(8);
		test.addNode(11);
		test.addNode(18);
		test.addNode(16);
		test.addNode(17);
		test.addNode(6);
		assertEquals(3, test.numLeaves(test.root));
	}
	*/
}
