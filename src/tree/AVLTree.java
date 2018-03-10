package tree;

public class AVLTree {

	public Node root;

	public int getMax(int a, int b) {
		return (a>b)? a: b;
	}

	public int getBalance(Node N) {
		if (N == null)
			return 0;
		return getHeight(N.getLeftChild())-getHeight(N.getRightChild());
	}
	
	public int getHeight(Node N) {
		if(N == null) {
			return 0;
		}
		return N.getHeight();
	}

	private Node rightRotate(Node y) {
		Node x = y.getLeftChild();
		Node T2 = x.getRightChild();

		// rotation
		x.setRightChild(y);
		y.setLeftChild(T2);

		// update heights
		int yHeight = getMax(getHeight(y.getLeftChild()), getHeight(y.getRightChild())) + 1;
		int xHeight = getMax(getHeight(x.getLeftChild()), getHeight(x.getRightChild())) + 1;
		y.setHeight(yHeight);
		x.setHeight(xHeight);

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
		int xHeight = getMax(getHeight(x.getLeftChild()), getHeight(x.getRightChild())) + 1;
		int yHeight = getMax(getHeight(y.getLeftChild()), getHeight(y.getRightChild())) + 1;
		System.out.println("yL: " + getHeight(y.getLeftChild()) + " yR: " + getHeight(y.getRightChild()));
		System.out.println("xH: " + xHeight + " yH: " + yHeight);
		x.setHeight(xHeight);
		y.setHeight(yHeight);

		// return new root
		return y;
	}

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

		// update height of this ancestor Node
		int newHeight = 1 + getMax(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		System.out.println("NEW HEIGHT: " + newHeight);
		node.setHeight(newHeight);

		int balance = getBalance(node);
		
		System.out.println("DATA: " + data);
		System.out.println("BALANCE: " + balance);
		
		// LL rotation
		if ((balance > 1) && (data < node.getLeftChild().getData())) {
			System.out.println("LL");
			return rightRotate(node);
		}

		// RR rotation
		if ((balance < -1) && (data > node.getRightChild().getData())) {
			System.out.println("RR");
			return leftRotate(node);
		}

		// LR rotation
		if ((balance > 1) && (data > node.getLeftChild().getData())) {
			System.out.println("LR");
			node.setLeftChild(leftRotate(node.getLeftChild()));
			return rightRotate(node);
		}

		// RL rotation
		if ((balance < -1) && (data < node.getRightChild().getData())) {
			System.out.println("RL");
			node.setRightChild(rightRotate(node.getRightChild()));
			return leftRotate(node);
		}
		System.out.println(" ");
		return node;
	}
	
}
