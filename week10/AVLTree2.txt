package avltest;
import java.util.ArrayList;

public class AVLTree {
	private Node root = null;

	private class Node {

		int value, height;
		Node left, right, parent;

		/**
		 * Constructor for leaf nodes.
		 * 
		 * @param value
		 *            Integer containing the node value
		 * @param left
		 *            Node containing the link to the left child
		 * @param right
		 *            Node containing the link to the right child
		 */
		Node(int val) {
			value = val;
			left = null;
			right = null;
			//height = 1;		// ...tom was here...
			height = 0;
			parent = null;

		}

		/**
		 * Constructor for non-leaf nodes.
		 * 
		 * @param value
		 *            Integer containing the node value
		 * @param left
		 *            Node containing the link to the left child
		 * @param right
		 *            Node containing the link to the right child
		 */
		Node(int val, Node leftChild, Node rightChild) {
			value = val;
			left = leftChild;
			right = rightChild;
		}

		private void resetHeight() {
			int leftHeight = -1;
			int rightHeight = -1;
			if (left != null) {
				leftHeight = left.height;
			}
			if (right != null) {
				rightHeight = right.height;
			}
			height = 1 + Math.max(leftHeight, rightHeight);
		}
	}

	public void Insert(int value) {
		Node node = new Node(value);

		if (root == null) {
			// this is now the root node of what was be an
			// empty tree
			root = node;
			return;
		}

		Node cur = root;
		while (cur != null) {
			if (node.value < cur.value) {
				if (cur.left == null) {
					cur.left = node;
					node.parent = cur;
					// cur = null;
					break;
				}
				cur = cur.left;
			} else {
				if (cur.right == null) {
					cur.right = node;
					node.parent = cur;
					break;
				}
				cur = cur.right;
			} // else
		} // while

		for (node = node.parent; node != null; node = node.parent)
			Rebalance(node);
	}

	private Node Rebalance(Node node) { // was::: private Node Rebalance(AVLTree
										// tree, Node node) {
		UpdateHeight(node);
		//
		if (GetBalance(node) == -2) {
			if (GetBalance(node.right) == 1) {
				// Double rotation case.
				RotateRight(node.right); // was:::: TreeRotateRight(tree,
											// node.right); //
											// -------------------------------------------------------------------------
			}
			return RotateLeft(node); // was::: TreeRotateLeft(tree, node);
		}

		else if (GetBalance(node) == 2) {
			if (GetBalance(node.left) == -1) {
				// Double rotation case.
				RotateLeft(node.left); // was:::: TreeRotateLeft(tree,
										// node.left);
			}
			return RotateRight(node); // was::: TreeRotateRight(tree, node);
		}
		return node;

	}

	/*
	 * Given a non-empty binary search tree, return the node with minimum key
	 * value found in that tree. Note that the entire tree does not need to be
	 * searched.
	 */
	Node minValueNode(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null)
			current = current.left;

		return current;
	}

	private Node BSTSearch(int key) {
		Node cur = root;
		while (cur != null) {

			if (key == cur.value) {
				// System.out.println("I FOUND IT !");
				return cur; // Found
			}

			else if (key < cur.value) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		return null; // Not found
	}

	public Node removeKey(int key) {
		Node node = BSTSearch(key);
		return deleteRec(node, key);
	}

	/* A recursive function to insert a new key in BST */
	private Node deleteRec(Node root, int key) {
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (key < root.value)
			root.left = deleteRec(root.left, key);
		else if (key > root.value)
			root.right = deleteRec(root.right, key);

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			root.value = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.value);
		}

		return root;
	}

	private int minValue(Node root) {
		int minv = root.value;
		while (root.left != null) {
			minv = root.left.value;
			root = root.left;
		}
		return minv;
	}

	// private boolean RemoveNode(Node node) {
	// if (node == null)
	// return false;
	//
	// // Parent needed for rebalancing
	// Node parent = node.parent;
	//
	// // Case 1: Internal node with 2 children
	// if (node.left != null && node.right != null) {
	// // Find successor
	// Node succNode = node.right;
	// while (succNode.left != null){
	// succNode = succNode.left;
	// }
	//
	//
	// // Copy the value from the node
	// node = succNode;
	//
	// // Recursively remove successor
	// RemoveNode(succNode);
	//
	// // Nothing left to do since the recursive call will have rebalanced
	// return true;
	// }
	//
	// // Case 2: Root node (with 1 or 0 children)
	// else if (node == root) {
	// if (node.left != null)
	// root = node.left;
	// else
	// root = node.right;
	//
	//// if (root)
	//// root.parent = null;
	//
	// return true;
	// }
	//
	// // Case 3: Internal with left child only
	// else if (node.left != null)
	// ReplaceChild(parent, node, node.left);
	//
	// // Case 4: Internal with right child only OR leaf
	// else
	// ReplaceChild(parent, node, node.right);
	//
	// // node is gone. Anything that was below node that has persisted is
	// already correctly
	// // balanced, but ancestors of node may need rebalancing.
	// node = parent;
	// while (node != null) {
	// Rebalance(node);
	// node = node.parent;
	// }
	// return true;
	// }

	// //GFG CHANGE IT TO JSUT 1 INTAKE
	// public Node RemoveNode(int key) {
	//
	// Node node = root;
	//
	// // STEP 1: PERFORM STANDARD BST DELETE
	// if (root == null)
	// return root;
	//
	// // If the key to be deleted is smaller than
	// // the root's key, then it lies in left subtree
	// if (key < root.value)
	// root.left = RemoveNode(key);
	//
	// // If the key to be deleted is greater than the
	// // root's key, then it lies in right subtree
	// else if (key > root.value)
	// root.right = RemoveNode(key);
	//
	// // if key is same as root's key, then this is the node
	// // to be deleted
	// else
	// {
	//
	// // node with only one child or no child
	// if ((root.left == null) || (root.right == null))
	// {
	// Node temp = null;
	// if (temp == root.left)
	// temp = root.right;
	// else
	// temp = root.left;
	//
	// // No child case
	// if (temp == null)
	// {
	// temp = root;
	// root = null;
	// }
	// else // One child case
	// root = temp; // Copy the contents of
	// // the non-empty child
	// }
	// else
	// {
	//
	// // node with two children: Get the inorder
	// // successor (smallest in the right subtree)
	// Node temp = minValueNode(root.right);
	//
	// // Copy the inorder successor's data to this node
	// root.value = temp.value;
	//
	// // Delete the inorder successor
	// root.right = RemoveNode(temp.value);
	// }
	// }
	//
	// // If the tree had only one node then return
	// if (root == null)
	// return root;
	//
	// // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
	// root.height = max(UpdateHeight(root.left), UpdateHeight(root.right)) + 1;
	//
	// // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
	// // this node became unbalanced)
	// int balance = GetBalance(root);
	//
	// // If this node becomes unbalanced, then there are 4 cases
	// // Left Left Case
	// if (balance > 1 && GetBalance(root.left) >= 0)
	// return RotateRight2(root);
	//
	// // Left Right Case
	// if (balance > 1 && GetBalance(root.left) < 0)
	// {
	// root.left = RotateLeft2(root.left);
	// return RotateRight2(root);
	// }
	//
	// // Right Right Case
	// if (balance < -1 && GetBalance(root.right) <= 0)
	// return RotateLeft2(root);
	//
	// // Right Left Case
	// if (balance < -1 && GetBalance(root.right) > 0)
	// {
	// root.right = RotateRight2(root.right);
	// return RotateLeft2(root);
	// }
	// return root;
	// }

	// GFG
	// Get Balance factor of node N
	private int __GetBalance(Node N) { // ...tom was here...
		if (N == null)
			return 0;

		return UpdateHeight(N.left) - UpdateHeight(N.right);
	}
	
	private int GetBalance(Node node) { // ...tom was here...
		int leftHeight = -1;
		if(node.left != null) 
			leftHeight = node.left.height;
		int rightHeight = -1;
		if(node.right != null)
			rightHeight = node.right.height;
		return leftHeight - rightHeight;
	}

	// Clearing the tree by setting the root to null, which removes all
	// references
	private void RemoveTree() {
		root = null;
	}

	private boolean ReplaceChild(Node parent, Node currentChild, Node newChild) {
		if (parent.left == currentChild) {
			return SetChild(parent, "left", newChild); // The zybook just says
														// left WITHOUT
														// PARENT.LEFT
		} else if (parent.right == currentChild) {
			return SetChild(parent, "right", newChild); // The zybook just says
														// right WITHOUT
														// PARENT.RIGHT
		}
		return false;
	}

	// FROM ZYBOOK
	private Node RotateRight(Node node) {
		Node leftRightChild = node.left.right;
		if (node.parent != null)
			ReplaceChild(node.parent, node, node.left);
		else { // node is root
			root = node.left;
			root.parent = null;
		}
		SetChild(node.left, "right", node);
		SetChild(node, "left", leftRightChild);
		return leftRightChild;
	}

	private Node RotateLeft(Node node) {
		Node rightLeftChild = node.right.left;
		if (node.parent != null)
			ReplaceChild(node.parent, node, node.right);
		else { // node is root
			root = node.right;
			root.parent = null;
		}
		SetChild(node.right, "left", node);
		SetChild(node, "right", rightLeftChild);
		return rightLeftChild;
	}

	// //GFG
	// // A utility function to right rotate subtree rooted with y
	// // See the diagram given above.
	// private Node RotateRight(Node y) {
	// Node x = y.left;
	// Node T2 = x.right;
	//
	// // Perform rotation
	// x.right = y;
	// y.left = T2;
	//
	// // Update heights
	// y.height = max(UpdateHeight(y.left), UpdateHeight(y.right)) + 1;
	// x.height = max(UpdateHeight(x.left), UpdateHeight(x.right)) + 1;
	//
	// // Return new root
	// return x;
	// }
	//
	//
	// //GFG
	// // A utility function to left rotate subtree rooted with x
	// // See the diagram given above.
	// private Node RotateLeft(Node x) {
	// Node y = x.right;
	// Node T2 = y.left;
	//
	// // Perform rotation
	// y.left = x;
	// x.right = T2;
	//
	// // Update heights
	// x.height = max(UpdateHeight(x.left), UpdateHeight(x.right)) + 1;
	// y.height = max(UpdateHeight(y.left), UpdateHeight(y.right)) + 1;
	//
	// // Return new root
	// return y;
	// }

	// private Node TreeRotateLeft(AVLTree tree, Node node) {
	// return null;
	// }
	//
	//
	// private Node TreeRotateRight(AVLTree tree, Node right) {
	// return null;
	// }

	private boolean SetChild(Node parent, String whichChild, Node child) {
		if (whichChild != "left" && whichChild != "right") {
			return false;
		}
		if (whichChild == "left") {
			parent.left = child;
		} else {
			parent.right = child;
		}
		if (child != null) {
			child = parent; // THEY ZYBOOK SAID DIFFERENTLY:: child->parent =
							// parent
		}
		UpdateHeight(parent);
		return true;
	}

	// GFG
	// A utility function to get the height of the tree
	private int __UpdateHeight(Node N) {    // ...tom was here...
		if (N == null)
			return 0;

		return N.height;
	}

	private int UpdateHeight(Node node) {    // ...tom was here...
		int leftHeight = -1;
		if(node.left != null ) {
			leftHeight = node.left.height;
		}
		int rightHeight = -1;
		if(node.right != null) {
			rightHeight = node.right.height;
		}
		return node.height = max(leftHeight, rightHeight) + 1;
	}
	

	// A utility function to get maximum of two integers
	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	@Override
	public String toString() {
		String str = "";
		return str;
	}

	/**
	 * A method lunches findHeight and returns the Height of the binary search
	 * tree.
	 * 
	 * @return findHeight(root) Returns an Integer height of the binary search
	 *         tree.
	 */
	public int getHeight() {
		return findHeight(root);
	}

	/**
	 * A method that takes in a node does all the analysis, and returns the
	 * height of the BST.
	 * 
	 * @param node
	 *            Takes in a node
	 * @return Returns an Integer height of the binary search tree.
	 */
	private int findHeight(Node node) {

		if (node == null) {
			return -1;
		}

		int lefth = findHeight(node.left);
		int righth = findHeight(node.right);

		if (lefth > righth) {
			return lefth + 1;
		} else {
			return righth + 1;
		}
	}

	ArrayList<Integer> arraylist = new ArrayList<Integer>(); // An arraylist to
																// store BST
																// integers at
																// the specied
																// level of the
																// tree

	/**
	 * A method that returns an array of node values of all of the nodes at the
	 * level specified by the method parameter.
	 * 
	 * @param level
	 *            Takes in an integer
	 * @return intArray Returns an array of integers
	 */
	public int[] getNodesAtLevel(int level) {

		// Method that analyzes and stores node values of all of the nodes at a
		// specified level into an arraylist
		printKDistant(root, level);

		int[] intArray = new int[arraylist.size()]; // An integer array to take
													// in all the values from
													// global arraylist

		// for loop that populates the array from the global arraylist
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = arraylist.get(i);
		}
                arraylist.clear();
		return intArray;
	}

	/**
	 * A void method that stores node values of all of the nodes at the level
	 * specified by the method parameter into an arraylist.
	 * 
	 * @param node
	 *            An integer input
	 * @param k
	 *            A node input
	 */
	private void printKDistant(Node node, int k) {
		if (node == null)
			return;
		if (k == 0) {
			arraylist.add(node.value);
			return;
		} else {
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		}
	}

//	// GADDIS
//	// ----------------------------------------------------------------------
//	public boolean Insert2(int x) {
//		root = add2(root, x);
//		return true;
//	}
//
//	/**
//	 * The add method adds a value to an AVL tree.
//	 * 
//	 * @return The root of the augmented AVL tree.
//	 */
//	private Node add2(Node node, int x) {
//		if (node == null) {
//			return new Node(x);
//		}
//		if (x < node.value) {
//			node.left = add2(node.right, x);
//		} else {
//			node.right = add2(node.right, x);
//		}
//
//		// Compute heights of the left and right subtrees and rebalance the tree
//		// if needed.
//		int leftHeight = getHeight(node.left);
//		int rightHeight = getHeight(node.right);
//		if (Math.abs(leftHeight - rightHeight) == 2) {
//			return balance(node);
//		} else {
//			node.resetHeight();
//			return node;
//		}
//	}
//
//	static int getHeight(Node node) {
//		if (node == null)
//			return -1;
//		else
//			return node.height;
//	}
//
//	/**
//	 * The balance method rebalances an AVL tree.
//	 * 
//	 * @param node
//	 *            The AVL tree needing to be balanced.
//	 * @return The balanced AVL tree.
//	 */
//	private Node balance(Node node) {
//		int rHeight = getHeight(node.right);
//		int lHeight = getHeight(node.left);
//
//		if (rHeight > lHeight) {
//			Node rightChild = node.right;
//			int rrHeight = getHeight(rightChild.right);
//			int rlHeight = getHeight(rightChild.left);
//			if (rrHeight > rlHeight) {
//				return rrBalance(node);
//			} else {
//				return rlBalance(node);
//			}
//		} else {
//			Node leftChild = node.left;
//			int llHeight = getHeight(leftChild.left);
//			int lrHeight = getHeight(leftChild.right);
//			if (llHeight > lrHeight) {
//				return llBalance(node);
//			} else {
//				return lrBalance(node);
//			}
//		}
//	}
//
//	/**
//	 * The rrBlance method corrects an RR imbalance.
//	 * 
//	 * @param node
//	 *            The AVL tree wih an RR imbalance.
//	 * @return The balanced AVL tree.
//	 */
//	private Node rrBalance(Node node) {
//		Node rightChild = node.right;
//		Node rightLeftChild = rightChild.left;
//		rightChild.left = node;
//		node.right = rightLeftChild;
//		node.resetHeight();
//		// rightChild.resetHeight(node); // ??
//		return rightChild;
//	}
//
//	/**
//	 * The llBalance method corrects an LL imbalance.
//	 * 
//	 * @param node
//	 *            The AVL tree with an LL imbalance.
//	 * @return The balanced AVL tree.
//	 */
//	private Node llBalance(Node node) {
//		Node leftChild = node.left;
//		Node lrTree = leftChild.right;
//		leftChild.right = node;
//		node.left = lrTree;
//		node.resetHeight();
//		leftChild.resetHeight();
//		return leftChild;
//	}
//
//	/**
//	 * The rlBalance method corrects an RL imbalance.
//	 * 
//	 * @parame node The AVL tree with an RL imbalance.
//	 * @return The balanced AVL tree.
//	 */
//	private Node rlBalance(Node node) { // CRASHES HERE
//										// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//		Node root = node;
//		Node rNode = root.right;
//		Node rlNode = rNode.left;
//		Node rlrTree = rlNode.right;
//		Node rllTree = rlNode.left;
//
//		// Build the restructured tree.
//		rNode.left = rlrTree;
//		root.right = rllTree;
//		rlNode.left = root;
//		rlNode.right = rNode;
//
//		// Adjust heights.
//		rNode.resetHeight();
//		root.resetHeight();
//		rlNode.resetHeight();
//
//		return rlNode;
//	}
//
//	/**
//	 * The lrBalance method corrects an LR imbalance.
//	 * 
//	 * @param node
//	 *            The AVL tree with an LR imbalance.
//	 * @return The balanced AVL tree.
//	 */
//	private Node lrBalance(Node node) { // CRASHES HERE
//										// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//		// try{
//
//		Node root = node;
//		Node lNode = root.left;
//		Node lrNode = lNode.right;
//		Node lrlTree = lrNode.left;
//		Node lrrTree = lrNode.right;
//
//		// Build the restructured tree.
//		lNode.right = lrlTree;
//		root.left = lrrTree;
//		lrNode.left = lNode;
//		lrNode.right = root;
//
//		// Adjust heights.
//		lNode.resetHeight();
//		root.resetHeight();
//		lrNode.resetHeight();
//
//		return lrNode;
//
//		// } catch(Exception e) {
//		// System.out.println("lrBalance FAILED");
//		// }
//		// return node;
//	}
//
//	// Node getLeft(){
//	// return (AVLNode) left;
//	// }
//	//
//	// Node getRight(){
//	// return (AVLNode) right;
//	// }

}