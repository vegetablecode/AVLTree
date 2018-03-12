# AVLTree

## What is it?
This is an implementation of AVL Tree data structure in Java.

## What is AVL Tree?
AVL Tree is a self-balancing binary search tree. It works almost the same as standard BST, but it contains algorithms that balance the tree when the difference between the heights of left and right subtrees is greater than 1. This difference is called Balance Factor and it can be equal to: 1, 0 or -1. Every operation (insertion, deletion) changes this value and if the BF is greater than 1 or lower than -1, the tree performs appropriate rotations and re-balances the nodes.

## Rotations
There are four different kinds of rotations:
1. Left Rotation [L]
2. Right Rotation [R]
3. Double right-left rotation [RL]
4. Double left-right rotation [LR]

## Operations
1. Insertion
2. Deletion
