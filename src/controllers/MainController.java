package controllers;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tree.AVLTree;
import view.Printer;

public class MainController {

	private AVLTree tree;
	private Printer treePrinter;
	private int numbOfRandomNodes;

	@FXML
	private TextArea graphTextArea;
	@FXML
	private TextField inOrderField;
	@FXML
	private TextField preOrderField;
	@FXML
	private TextField postOrderField;
	@FXML
	private TextField inputField;
	@FXML
	private TextField randomNodesField;
	@FXML
	private Label treeHeightLabel;
	
	@FXML
	void initialize() {
		// - create instance of a tree and printer -
		tree = new AVLTree();
		tree.root = tree.insert(tree.root, 1);
		treePrinter = new Printer(tree);

		numbOfRandomNodes = 5;
		randomNodesField.setText(String.valueOf(numbOfRandomNodes));

		update();
	}

	@FXML
	public void addNode() {
		int value = 0;
		if (inputField.getText().isEmpty()) {
			showMessage("Cannot add the node. There is no value entered.");
		} else {
			try {
				value = Integer.parseInt(inputField.getText());
				tree.root = tree.insert(tree.root, value);
			} catch (NumberFormatException e) {
				showMessage("The value should be a type of integer!");
			}
		}
		update();
	}

	@FXML
	public void removeNode() {
		int value = 0;
		if (inputField.getText().isEmpty()) {
			showMessage("Cannot remove the node. There is no value entered.");
		} else {
			try {
				value = Integer.parseInt(inputField.getText());
				tree.root = tree.remove(tree.root, value);
			} catch (NumberFormatException e) {
				showMessage("The value should be a type of integer!");
			}
		}
		update();
	}

	@FXML
	public void readSampleTree() throws InterruptedException {
		Random randomGenerator = new Random();
		
		if (randomNodesField.getText().isEmpty()) {
			showMessage("Cannot add the nodes. There is no value entered.");
		} else {
			try {
				numbOfRandomNodes = Integer.parseInt(randomNodesField.getText());
				for (int i = 0; i < numbOfRandomNodes; i++) {
					int val = randomGenerator.nextInt(1000);
					tree.root = tree.insert(tree.root, val);
					update();
				}

			} catch (NumberFormatException e) {
				showMessage("The value should be a type of integer!");
			}
		}
		update();
	}

	@FXML
	public void resetTree() {
		showMessage("The tree has been removed!");
		initialize();
		update();
	}

	public void update() {
		inputField.setText("");
		treePrinter.updateView();
		graphTextArea.setText(treePrinter.getGraphTree());
		inOrderField.setText(treePrinter.getInOrder().toString());
		preOrderField.setText(treePrinter.getPreOrder().toString());
		postOrderField.setText(treePrinter.getPostOrder().toString());
		treeHeightLabel.setText(String.valueOf(tree.root.getHeight()));
	}

	public void showMessage(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning Message");
		alert.setHeaderText("Warning message");
		alert.setContentText(message);
		alert.showAndWait();
	}

}
