package com.mooip.code.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Search Test Tree.  This will show various algorithms for searching a tree.
 * DFS means depth-first search. BFS means breadth-first search.
 * 
 * @author masterofoneinchpunch
 */
public final class SearchTreeTest {
    private static int count = 0;
    
    private static void dFSPreOrder(BinaryTree node) {
        if (node == null) {
            return;
        }
        
        visit(node);
        dFSPreOrder(node.getLeft());
        dFSPreOrder(node.getRight());
    }
    
    private static void dFSInOrder(BinaryTree node) {
        if (node == null) {
            return;
        }
        
        dFSInOrder(node.getLeft());
        visit(node);
        dFSInOrder(node.getRight());
    }
    
    private static void dFSPostOrder(BinaryTree node) {
        if (node == null) {
            return;
        }
        
        dFSPostOrder(node.getLeft());
        dFSPostOrder(node.getRight());
        visit(node);
    }

    private static void bfs(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.offer(root);
        int countBfs = 0;
        while (queue.isEmpty() == false) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree temp = queue.poll();
                System.out.print(temp.getValue() + " "); //prints in level order
                countBfs++;
                if (temp.getLeft() != null) {
                    queue.offer(temp.getLeft());
                }
                
                if (temp.getRight() != null) {
                    queue.offer(temp.getRight());
                }
            }
        }
        System.out.println("countBfs: " + countBfs);
    }
      
    private static void visit(BinaryTree node){
        System.out.println("visit: " + node.getValue());
        count++;
    }
    
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(3);
        BinaryTree bt2 = new BinaryTree(1);
        BinaryTree bt3 = new BinaryTree(15);
        BinaryTree bt4 = new BinaryTree(4);

        bt2.setLeft(bt3);
        root.setLeft(bt2);
        root.setRight(bt4);   
        
        System.out.println("PRE ORDER: "); //3,1,15,4 (visits root first)
        dFSPreOrder(root);
        System.out.println("DFS PreOrder Count: " + count);
        count = 0;
        System.out.println("POST ORDER: "); //15,1,4,3
        dFSPostOrder(root);
        System.out.println("DFS PostOrder Count: " + count);    
        count = 0;
        
        //in order is the only one where all the values shown will be to the left of the
        //root node and all the values to the right will be shown to the right of the root node.
        System.out.println("IN ORDER: "); //15,1,3,4 
        dFSInOrder(root);
        System.out.println("DFS InOrder Count: " + count);    
        
        bfs(root);            
    }  
}

