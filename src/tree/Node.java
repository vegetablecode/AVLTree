package tree;

public class Node {

	private int data;
	private int height;
	private Node leftChild;
	private Node rightChild;
	
	public Node(int data) {
		this.data = data;
		this.height = 1;
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
		
	// -------- printer (adapted from: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram) -------- //
	public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
	    if(rightChild!=null) {
	        rightChild.toString(new StringBuilder().append(prefix).append(isTail ? "│       " : "        "), false, sb);
	    }
	    sb.append(prefix).append(isTail ? "└── " : "┌── ").append(data).append(":").append(getBalance(this)).append("\n");
	    if(leftChild!=null) {
	        leftChild.toString(new StringBuilder().append(prefix).append(isTail ? "        " : "│       "), true, sb);
	    }
	    return sb;
	}

	@Override
	public String toString() {
	    return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
	}
	
	// very temp
		public int getHeight(Node N) {
			if(N == null) {
				return 0;
			}
			return N.getHeight();
		}
		
		public int getBalance(Node N) {
			if (N == null)
				return 0;
			return getHeight(N.getLeftChild())-getHeight(N.getRightChild());
		}

	// ----------------------------------------------------------------------------------------------------------------------- //
}
