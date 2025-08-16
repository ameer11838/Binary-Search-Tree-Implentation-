This program recursively creates a binary tree, traverses it, and implements several methods.  
It is organized into three files with the following responsibilities:

- Main.java – Driver program that calls the functions in BinarySearchTree.java and measures their execution time.
- BinaryTree.java – Abstract class that defines the method signatures implemented in BinarySearchTree.java.
- BinarySearchTree.java – Provides recursive implementations of the following methods:
```bash
  - insert   → inserts nodes into the BST
  - remove   → removes nodes from the BST
  - search   → searches for a node and outputs "found" or "not found"
  - height   → calculates the height of the BST (in nodes). 
               *Note: this method is not defined in BinaryTree.java*
