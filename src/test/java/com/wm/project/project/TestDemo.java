package com.wm.project.project;

public class TestDemo {
    public static void main(String[] args) {
        TestBinarySearchTree tree = new TestBinarySearchTree();
        //创建二叉查找树
        tree.insert(5);
        tree.insert(8);
        tree.insert(1);
        tree.insert(10);
        tree.insert(16);
        tree.insert(3);
        tree.insert(4);
        System.out.println("二叉查找树的中序遍历");
        tree.inorder(tree.root);
        System.out.println("\n" + "===================");
        System.out.println("二叉查找树的查找，查找16");
        System.out.println(tree.contains(16));
        System.out.println("\n" + "===================");
        System.out.println("二叉查找树的插入,插入21");
        tree.insert(21);
        tree.inorder(tree.root);
        System.out.println("\n" + "===================");
        System.out.println("二叉查找树的删除，删除1");
        tree.remove(1);
        tree.inorder(tree.root);
        System.out.println("\n" + "===================");
        System.out.println("输出二叉查找树的最大值和最小值");
        tree.findMax(tree.root);
        tree.findMin(tree.root);
    }
}
