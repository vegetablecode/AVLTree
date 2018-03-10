package app;

import tree.AVLTree;
import tree.Node;
import view.TreePrinter;

public class Main {

	private static Node test1() {
		AVLTree tree = new AVLTree();
		
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);

        return tree.root;
    }

    public static void main(String[] args) {

    		AVLTree tree = new AVLTree();
    		tree.root = tree.insert(tree.root, 10);
    		tree.root = tree.insert(tree.root, 20);
    		tree.root = tree.insert(tree.root, 30);
    		tree.root = tree.insert(tree.root, 40);
    		tree.root = tree.insert(tree.root, 50);
    		tree.root = tree.insert(tree.root, 25);
    		
    		tree.preOrder(tree.root);
		System.out.println(" ");
		tree.inOrder(tree.root);
		System.out.println(" ");
		tree.postOrder(tree.root);
		System.out.println(" ");
		
        TreePrinter.printNode(test1());

    }
    
}
