package tree;

public class Node {

	private int data;
	private int height;
	private Node leftChild;
	private Node rightChild;
	
	public Node() {
		this.data = 0;
		this.height = 1;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public Node(int data) {
		this.data = data;
		this.height = 1;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getData() {
		return data;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getBalance(Node node) {
		if(node == null)
			return 0;
		return node.getLeftChild().getHeight() - node.getRightChild().getHeight();
	}
	
}
