package app;

import tree.AVLTree;
import view.Printer;


public class Main {

    public static void main(String[] args) {

    		AVLTree tree = new AVLTree();
    		tree.root = tree.insert(tree.root, 10);
    		tree.root = tree.insert(tree.root, 20);
    		tree.root = tree.insert(tree.root, 30);
    		tree.root = tree.insert(tree.root, 40);
    		tree.root = tree.insert(tree.root, 50);
    		tree.root = tree.insert(tree.root, 25);
    		
    		Printer treePrinter = new Printer(tree);
    		treePrinter.updateView();
    		
    		
    		System.out.println(treePrinter.getInOrder());
		System.out.println(" ");
		System.out.println(treePrinter.getPreOrder());
		System.out.println(" ");
		System.out.println(treePrinter.getPostOrder());
		System.out.println(" ");
		

        System.out.println(" ");
        System.out.println(treePrinter.getGraphTree());
        
    }
    
}
