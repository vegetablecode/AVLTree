package tree;

public class AVLTree {

	public Node root;

	// ----- UTILITY METHODS ----- //
	// - get max of two integers -
	int getMax(int a, int b) {
		return (a > b) ? a : b;
	}

	// - calculate balance of a node -
	int getBalance(Node node) {
		if (node == null)
			return 0;
		return height(node.getLeftChild()) - height(node.getRightChild());
	}

	// - get height (from the current node to the bottom) -
	int height(Node node) {
		if (node == null)
			return 0;
		return node.getHeight();
	}

	// - get the node with minimal data value -
	Node minValueNode(Node node) {
		Node current = node;
		while (current.getLeftChild() != null)
			current = current.getLeftChild();
		return current;
	}

	// ----- ROTATION METHODS ----- //
	private Node rightRotate(Node y) {
		Node x = y.getLeftChild();
		Node T2 = x.getRightChild();

		// - make rotation -
		x.setRightChild(y);
		y.setLeftChild(T2);

		// - update heights -
		y.setHeight((getMax(height(y.getLeftChild()), height(y.getRightChild())) + 1));
		x.setHeight((getMax(height(x.getLeftChild()), height(x.getRightChild())) + 1));

		return x;
	}

	private Node leftRotate(Node x) {
		Node y = x.getRightChild();
		Node T2 = y.getLeftChild();

		// - make rotation -
		y.setLeftChild(x);
		x.setRightChild(T2);

		// - update heights -
		x.setHeight((getMax(height(x.getLeftChild()), height(x.getRightChild())) + 1));
		y.setHeight((getMax(height(y.getLeftChild()), height(y.getRightChild())) + 1));

		return y;
	}

	// ----- TREE OPERATIONS METHODS ----- //
	public Node insert(Node node, int data) {
		// - do the standard BST insertion -
		if (node == null)
			return (new Node(data));

		if (data < node.getData())
			node.setLeftChild(insert(node.getLeftChild(), data));
		else if (data > node.getData())
			node.setRightChild(insert(node.getRightChild(), data));
		else // [equal node cannot be added]
			return node;

		// - update height of this father's Node -
		node.setHeight((1 + getMax(height(node.getLeftChild()), height(node.getRightChild()))));

		// - LL rotation case -
		if ((getBalance(node) > 1) && (data < node.getLeftChild().getData())) {
			return rightRotate(node);
		}

		// - RR rotation case -
		if ((getBalance(node) < -1) && (data > node.getRightChild().getData())) {
			return leftRotate(node);
		}

		// - LR rotation case -
		if ((getBalance(node) > 1) && (data > node.getLeftChild().getData())) {
			node.setLeftChild(leftRotate(node.getLeftChild()));
			return rightRotate(node);
		}

		// - RL rotation case -
		if ((getBalance(node) < -1) && (data < node.getRightChild().getData())) {
			node.setRightChild(rightRotate(node.getRightChild()));
			return leftRotate(node);
		}
		return node;
	}

	public Node remove(Node root, int data) {
		// - do the standard BST deletion -
		if (root == null)
			return root;

		// [if the value is smaller than the root's value, then it's located in left
		// subtree]
		if (data < root.getData())
			root.setLeftChild(remove(root.getLeftChild(), data));

		// [if is bigger, then it's located in the right subtree]
		else if (data > root.getData())
			root.setRightChild(remove(root.getRightChild(), data));

		// [if it's the same as root's value, then this is the node, that has to be
		// deleted]
		else {
			// [if node has only one child or doesn't have any]
			if ((root.getLeftChild() == null) || (root.getRightChild() == null)) {
				Node temp = null;
				if (temp == root.getLeftChild())
					temp = root.getRightChild();
				else
					temp = root.getLeftChild();
				// [no children]
				if (temp == null) {
					temp = root;
					root = null;
				} else // [one child]
					root = temp;
			} else {
				// [node with two children: get the smallest node in the right subtree]
				Node temp = minValueNode(root.getRightChild());
				// [copy its data to this node]
				root.setData(temp.getData());
				// [remove this smallest node]
				root.setRightChild(remove(root.getRightChild(), temp.getData()));
			}
		}
		// [if the tree has only one node then return]
		if (root == null)
			return root;
		// - update height if the current node -
		root.setHeight((getMax(height(root.getLeftChild()), height(root.getRightChild())) + 1));

		// - LL case -
		if (getBalance(root) > 1 && getBalance(root.getLeftChild()) >= 0)
			return rightRotate(root);

		// - LR case -
		if (getBalance(root) > 1 && getBalance(root.getLeftChild()) < 0) {
			root.setLeftChild(leftRotate(root.getLeftChild()));
			return rightRotate(root);
		}

		// - RR case -
		if (getBalance(root) < -1 && getBalance(root.getRightChild()) <= 0)
			return leftRotate(root);

		// - RL case -
		if (getBalance(root) < -1 && getBalance(root.getRightChild()) > 0) {
			root.setRightChild(rightRotate(root.getRightChild()));
			return leftRotate(root);
		}
		return root;
	}

}
