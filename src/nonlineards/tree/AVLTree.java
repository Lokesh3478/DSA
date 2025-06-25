package nonlineards.tree;

import java.util.Comparator;
import nonlineards.tree.BinarySearchTree.Node;

/**
 * AVLTree is a self-balancing Binary Search Tree that extends a basic BST.
 * After every insertion, it ensures the balance factor of any node is between -1 and 1,
 * performing rotations as necessary to maintain balance.
 */
public class AVLTree<T> extends BinarySearchTree<T> {

    // Default constructor for Comparable-based AVLTree
    public AVLTree() {
    }

    // Constructor to use Comparator instead of Comparable
    public AVLTree(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * Overrides insertion for Comparable types to include AVL rotation after BST insert.
     */
    @Override
    protected Node<T> insertByComparable(Node<T> root, Comparable<? super T> compData) {
        root = super.insertByComparable(root, compData); // Regular BST insertion
        return rotate(root); // Perform AVL rotation if unbalanced
    }

    /**
     * Overrides insertion for Comparator-based types to include AVL rotation.
     */
    @Override
    protected Node<T> insertByComparator(Node<T> root, T data) {
        root = super.insertByComparator(root, data); // Regular BST insertion
        return rotate(root); // Perform AVL rotation if needed
    }

    /**
     * Performs a left rotation (used in right-heavy cases like RR).
     */
    private Node<T> leftRotate(Node<T> node) {
        Node<T> child = node.getRight();
        node.setRight(child.getLeft());  // Move right child's left subtree to node's right
        child.setLeft(node);             // Put node below left of right child
        node.updateHeight();             // Update height of affected nodes
        child.updateHeight();
        return child;                    // returns right as new root of the rotated subtree
    }

    /**
     * Performs a right rotation (used in left-heavy cases like LL).
     */
    private Node<T> rightRotate(Node<T> node) {
        Node<T> child = node.getLeft();
        node.setLeft(child.getRight());  // Move left child's right subtree to node's left
        child.setRight(node);            // Put node below right of left child
        node.updateHeight();             // Update height of affected nodes
        child.updateHeight();
        return child;                    // returns left as new root of the rotated subtree
    }

    /**
     * Checks if the subtree rooted at the given node is unbalanced,
     * and applies appropriate rotation(s) based on imbalance type.
     * 
     * @param node The root node of the subtree to check for balance.
     * @return The possibly new root after performing AVL rotations.
     */
    private Node<T> rotate(Node<T> node) {
        if (node == null) return null;

        Node<T> left = node.getLeft();
        Node<T> right = node.getRight();

        int leftHeight = (left != null) ? left.getHeight() : -1;
        int rightHeight = (right != null) ? right.getHeight() : -1;

        // Check if node is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {

            if (leftHeight > rightHeight) {
                // Left-heavy subtree: check if it's LL or LR
                int leftLeftHeight = (left.getLeft() != null) ? left.getLeft().getHeight() : -1;
                int leftRightHeight = (left.getRight() != null) ? left.getRight().getHeight() : -1;

                if (leftLeftHeight > leftRightHeight) {
                    // LL Case
                    return rightRotate(node);
                } else {
                    // LR Case
                	//rotate left child's right child to align all on left
                    node.setLeft(leftRotate(left));
                    //rotate left to right
                    return rightRotate(node);
                }

            } else {
                // Right-heavy subtree: check if it's RR or RL
                int rightLeftHeight = (right.getLeft() != null) ? right.getLeft().getHeight() : -1;
                int rightRightHeight = (right.getRight() != null) ? right.getRight().getHeight() : -1;

                if (rightRightHeight > rightLeftHeight) {
                    // RR Case
                    return leftRotate(node);
                } else {
                    // RL Case
                	//rotate right child's left child to align all on right
                    node.setRight(rightRotate(right));
                  //rotate right to left
                    return leftRotate(node);
                }
            }
        }

        // Balanced subtree: no rotation needed
        return node;
    }
}