package view;

import tree.AVLTree;
import tree.Node;

public class Printer {
	
	private AVLTree tree;
	
	private StringBuilder inOrder;
	private StringBuilder preOrder;
	private StringBuilder postOrder;
	private String graphTree;
	
	public Printer(AVLTree tree) {
		this.tree = tree;
		
		inOrder = new StringBuilder("");
		preOrder = new StringBuilder("");
		postOrder = new StringBuilder("");
		
		updateView();
	}
	
	public void setInOrder(Node node) {
		if(node != null) {
			setInOrder(node.getLeftChild());
			inOrder.append(node.getData() + " ");
			setInOrder(node.getRightChild());
		}
	}
	
	private void setPreOrder(Node node) {
		if(node != null) {
			preOrder.append(node.getData() + " ");
			setPreOrder(node.getLeftChild());
			setPreOrder(node.getRightChild());
		}
	}
	
	public void setPostOrder(Node node) {
		if(node != null) {
			setPostOrder(node.getLeftChild());
			setPostOrder(node.getRightChild());
			postOrder.append(node.getData() + " ");
		}
	}
	
	public void setGraphTree(Node node) {
		graphTree = node.toString();
	}
	
	public void updateView() {
		inOrder = new StringBuilder("");
		preOrder = new StringBuilder("");
		postOrder = new StringBuilder("");
		
		setInOrder(tree.root);
		setPreOrder(tree.root);
		setPostOrder(tree.root);
		setGraphTree(tree.root);
	}
	
	public StringBuilder getInOrder() {
		return inOrder;
	}
	
	public StringBuilder getPreOrder() {
		return preOrder;
	}
	
	public StringBuilder getPostOrder() {
		return postOrder;
	}
	
	public String getGraphTree() {
		return graphTree;
	}
	
}
