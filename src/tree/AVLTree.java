package tree;

public class AVLTree {

	private Node root;

	// util
	private int getMax(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	private int getBalance(Node node) {
		if (node == null)
			return 0;
		return node.getLeftChild().getHeight() - node.getRightChild().getHeight();
	}

	private Node rightRotate(Node y) {
		Node x = y.getLeftChild();
		Node T2 = x.getRightChild();

		// rotation
		x.setRightChild(y);
		y.setLeftChild(T2);

		// update heights
		y.setHeight(getMax(y.getLeftChild().getHeight(), y.getRightChild().getHeight()) + 1);
		x.setHeight(getMax(x.getLeftChild().getHeight(), x.getRightChild().getHeight()) + 1);

		// return new root
		return x;
	}

	private Node leftRotate(Node x) {
		Node y = x.getRightChild();
		Node T2 = y.getLeftChild();

		// rotation
		y.setLeftChild(x);
		x.setRightChild(T2);

		// update heights
		x.setHeight(getMax(x.getLeftChild().getHeight(), x.getRightChild().getHeight()) + 1);
		y.setHeight(getMax(y.getLeftChild().getHeight(), y.getRightChild().getHeight()) + 1);

		// return new root
		return y;
	}

	public Node insert(Node node, int data) {
		// do the normal BST insertion
		if (node == null)
			return new Node(data);
		if (data < node.getData())
			node.setLeftChild(insert(node.getLeftChild(), data));
		else if (data > node.getData())
			node.setRightChild(insert(node.getRightChild(), data));
		else
			return node;

		// update height of this ancestor Node
		node.setHeight(1 + getMax(node.getLeftChild().getHeight(), node.getRightChild().getHeight()));

		// LL rotation
		if ((getBalance(node) > 1) && (data < node.getLeftChild().getData()))
			return rightRotate(node);

		// RR rotation
		if ((getBalance(node) < -1) && (data > node.getRightChild().getData()))
			return leftRotate(node);

		// LR rotation
		if ((getBalance(node) > 1) && (data > node.getLeftChild().getData())) {
			node.setLeftChild(leftRotate(node.getLeftChild()));
			return rightRotate(node);
		}

		// RL rotation
		if ((getBalance(node) < -1) && (data < node.getRightChild().getData())) {
			node.setRightChild(rightRotate(node.getRightChild()));
			return leftRotate(node);
		}

		return node;
	}

	public void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.getData() + " ");
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	
}
