package tree;

public class AVLTree {

	public Node root;

	// ----- UTILITY METHODS ----- //
	int getMax(int a, int b) {
		return (a>b)? a: b;
	}

	int getBalance(Node node) {
		if (node == null)
			return 0;
		return height(node.getLeftChild()) - height(node.getRightChild());
	}

	int height(Node node) {
		if (node == null)
			return 0;
		return node.getHeight();
	}

	// ----- ROTATE METHODS ----- //
	private Node rightRotate(Node y) {
		Node x = y.getLeftChild();
		Node T2 = x.getRightChild();

		// make rotation
		x.setRightChild(y);
		y.setLeftChild(T2);

		// update heights
		y.setHeight((getMax(height(y.getLeftChild()), height(y.getRightChild())) + 1));
		x.setHeight((getMax(height(x.getLeftChild()), height(x.getRightChild())) + 1));

		return x;
	}

	private Node leftRotate(Node x) {
		Node y = x.getRightChild();
		Node T2 = y.getLeftChild();

		// make rotation
		y.setLeftChild(x);
		x.setRightChild(T2);

		// update heights
		x.setHeight((getMax(height(x.getLeftChild()), height(x.getRightChild())) + 1));
		y.setHeight((getMax(height(y.getLeftChild()), height(y.getRightChild())) + 1));

		return y;
	}

	// ----- TREE OPERATIONS METHODS ----- //
	public Node insert(Node node, int data) {
		// do the normal BST insertion
		if (node == null)
			return (new Node(data));

		if (data < node.getData())
			node.setLeftChild(insert(node.getLeftChild(), data));
		else if (data > node.getData())
			node.setRightChild(insert(node.getRightChild(), data));
		else
			return node;

		// update height of this father's Node
		node.setHeight((1 + getMax(height(node.getLeftChild()), height(node.getRightChild()))));


		// LL rotation case
		if ((getBalance(node) > 1) && (data < node.getLeftChild().getData())) {
			return rightRotate(node);
		}

		// RR rotation case
		if ((getBalance(node) < -1) && (data > node.getRightChild().getData())) {
			return leftRotate(node);
		}

		// LR rotation case
		if ((getBalance(node) > 1) && (data > node.getLeftChild().getData())) {
			node.setLeftChild(leftRotate(node.getLeftChild()));
			return rightRotate(node);
		}

		// RL rotation case
		if ((getBalance(node) < -1) && (data < node.getRightChild().getData())) {
			node.setRightChild(rightRotate(node.getRightChild()));
			return leftRotate(node);
		}
		return node;
	}

}
