package com.rajamohan.base;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
        this.data = data;
    }
}

class BinaryTree{
    TreeNode root;

    BinaryTree (int data){
        this.root = new TreeNode(data);
    }

    public void insertLeft(TreeNode root, int data){
        root.left = new TreeNode(data);
    }

    public void insertRight(TreeNode root, int data){
        root.right = new TreeNode(data);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }
}

public class BinaryTreeDemo {

    public static void main(String args[]){
         BinaryTree tree = new BinaryTree(1);
         tree.insertLeft(tree.root, 2);
         tree.insertRight(tree.root, 3);
         tree.insertLeft(tree.root.left, 4);
         tree.insertRight(tree.root.left, 5);
         // Traverse the tree in-order
         tree.inOrder(tree.root);
    }
}
