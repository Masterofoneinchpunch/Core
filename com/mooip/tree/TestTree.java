package com.mooip.code.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Various tests for the tree including height, levels.
 * 
 * @author masterofoneinchpunch
 */
public final class TestTree {
    public static class NodeContainer {
        private final BinaryTree node;
        private final Integer position;
        
        public NodeContainer(BinaryTree node, Integer position){
            this.node = node;
            this.position = position;
        }
        
        public BinaryTree getNode() {
            return this.node;
        }
        
        public Integer getPostion(){
            return this.position;
        }
        
        @Override
        public String toString() {
            return "data: " + node.getValue() + " position: " + position;
        }
    }
    
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(3);
        BinaryTree bt2 = new BinaryTree(1);
        BinaryTree bt3 = new BinaryTree(15);
        BinaryTree bt4 = new BinaryTree(4);

        bt2.setLeft(bt3);
        root.setLeft(bt2);
        root.setRight(bt4);
        
        System.out.println("height: " + height(root));
        System.out.println("countNode function: " + countNode(root));
        
        System.out.println("levelOrder: ");
        List levels = levelOrder(root);
        
        System.out.println("levels: " + levels);
        insert(root, 2);
        levels = levelOrder(root);
        System.out.println("levels: " + levels);
        System.out.println("lca " + lca(root, 1, 4).getValue());
    }

    public static int height(BinaryTree node) {
      	if (node == null) {
              return -1;
        }
        
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight +1;
    }

    public static BinaryTree lca(BinaryTree root, int v1, int v2) {
      	if (root == null) {
              return null;
        }
        
        if (root.getValue() > v1 && root.getValue() > v2) {
            return lca(root.getLeft(), v1, v2);
        } else if (root.getValue() < v1 && root.getValue() < v2) {
            return lca(root.getRight(), v1, v2);
        }
        
        return root; //the correct node
    }

    public static BinaryTree insert(BinaryTree root,int data) {
        if (root == null) {
            return new BinaryTree(data);
        }
        if (data < root.getValue()) {
            root.setLeft(insert(root.getLeft(), data));
        }
        if (data > root.getValue()) {
            root.setRight(insert(root.getRight(), data));
        }
    	
        return root;
    }
    
    public static boolean checkBST(BinaryTree root) {
        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkNode(BinaryTree node, int minval, int maxval) {
        if (node == null) {
            return true;
        }
        return (
            node.getValue() >= minval && node.getValue() <= maxval &&
            checkNode(node.getLeft(), minval, node.getValue()-1) &&
            checkNode(node.getRight(), node.getValue()+1, maxval)
        );
    }
    
    //level order uses a BFS
    public static List<LinkedList<Integer>> levelOrder(BinaryTree root) {
        List rst = new LinkedList();
        if (root == null) {
            return rst;
        }
        
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.offer(root);
        
        while (queue.isEmpty() == false) {
            List<Integer> level = new LinkedList<Integer>();
            
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree temp = queue.poll();
                System.out.print(temp.getValue() + " "); //prints in level order
                level.add(temp.getValue());
                if (temp.getLeft() != null) {
                    queue.offer(temp.getLeft());
                }
                
                if (temp.getRight() != null) {
                    queue.offer(temp.getRight());
                }
            }
            rst.add(level);
        }
        System.out.println("");
        return rst;
    }

    public static void topView(BinaryTree root) {
        if (root == null) {
            return;
        }
        
        List<Integer> leftValues = new ArrayList<Integer>();
        final Integer rootValue = root.getValue();
        List<Integer> rightValues = new ArrayList<Integer>();
        
        //classic BFS (exam level-by-level, left-to-right)
        Queue<NodeContainer> queue = new LinkedList<NodeContainer>();
        queue.offer(new NodeContainer(root, 0));
        
        while (queue.isEmpty() == false) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeContainer nc = queue.poll();
                BinaryTree temp = nc.getNode();
                if (temp.getLeft() != null) {
                    NodeContainer left = new NodeContainer(temp.getLeft(), nc.getPostion() - 1);
                    queue.offer(left);
                    //if the position is bigger (negate) than the size it can be seen from top
                    if (leftValues.size() < -left.getPostion()) {
                        leftValues.add(temp.getLeft().getValue());
                    }                    
                }
                
                if (temp.getRight() != null) {
                    NodeContainer right = new NodeContainer(temp.getRight(), nc.getPostion() + 1);
                    queue.offer(right);
                    //if the position is bigger than the size it can be seen from top
                    if (rightValues.size() < right.getPostion()) {
                        rightValues.add(temp.getRight().getValue());
                    }
                }
            }
        }
        
        Collections.reverse(leftValues);
        for (Integer leftValue : leftValues) {
            System.out.print(leftValue + " ");
        }        
        System.out.print(rootValue + " ");
        for (Integer rightValue : rightValues) {
            System.out.print(rightValue + " ");
        }
    }
    
    private static int countNode(BinaryTree root) {
        if(root == null) {
            return 0;
        }

        return 1 + countNode(root.getLeft()) + countNode(root.getRight());        
    }
}

