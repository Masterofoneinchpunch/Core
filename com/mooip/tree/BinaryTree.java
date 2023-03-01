package com.mooip.code.tree;

/**
 * Binary Tree.  Basic tree for testing and example purposes.  Java does not have 
 * one of these, but since they are easy to make, one can always create their own.
 * 
 * @author masterofoneinchpunch
 */
public final class BinaryTree {    
    private BinaryTree left;
    private BinaryTree right;
    private Integer value;
    
    /**
     * Construct for binary tree. 
     * 
     * @param value The integer value.
     */
    public BinaryTree(Integer value) {
        this.value = value;
    }

    /**
     * Gets the left binary tree.
     * 
     * @return left A binary tree.
     */
    public BinaryTree getLeft() {
        return left;
    }

    /**
     * Sets the left binary tree.
     * 
     * @param left A binary tree.
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * Gets the right binary tree.
     * 
     * @return right A binary tree.
     */
    public BinaryTree getRight() {
        return right;
    }

    /**
     * Sets the right binary tree.
     * 
     * @param right A binary tree.
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    /**
     * Gets the value.
     * 
     * @return value The value.
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Sets the value.
     * 
     * @param value The value.
     */
    public void setValue(Integer value) {
        this.value = value;
    }   
}

