
# AVLTree

## What is it?
This is an implementation of AVL Tree data structure in Java.

## What is AVL Tree?
AVL Tree is a self-balancing binary search tree. It works almost the same as standard BST, but it contains algorithms that balance the tree when the difference between the heights of left and right subtrees is greater than 1. This difference is called Balance Factor and it can be equal to: 1, 0 or -1. Every operation (insertion, deletion) changes this value and if the BF is greater than 1 or lower than -1, the tree performs appropriate rotations and re-balances the nodes.

## Rotations
There are four different kinds of rotations:
#### Left Rotation [L]
```
A                           B
\           L(A)          / \
 B          ---->        A   C
  \
   C
```
#### Right Rotation [R]
```
   C                       B
  /         R(C)          / \
 B          ---->        A   C
/
A
```
#### Double right-left rotation [RL]
```
A                   A                        B
\       R(B)        \          L(A)        / \
 C      ---->        B         ---->      A   C
/                     \
B                       C
```
#### Double left-right rotation [LR]
```
 C                       C                    B
/         L(A)          /        R(C)        / \
A          ---->        B         ---->      A   C
\                     /
 B                   A
```

## Operations
#### Insertion
#### Deletion

## Screenshots
![Main Window](/screenshots/1.png)
![Main Window](/screenshots/2.png)
