package com.wm.project.project;

public class TestBinarySearchTree {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    /**
     * 二叉查找树的contains操作
     * @param val
     * @return
     */
    public boolean contains(int val) {
        if(root == null) {
            return false;
        }
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val == val) {
                return true;
            }else if(cur.val > val) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return false;
    }

    /**
     * 二叉查找树的插入
     * @param val
     * @return
     */
    public boolean insert(int val) {
        if(root == null) {
            root = new TreeNode(val);
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null) {
            if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else if(cur.val > val) {
                parent = cur;
                cur = cur.left;
            }else {
                return false;//不能插入相同的数字
            }
        }
        if(parent.val < val) {
            parent.right = new TreeNode(val);
        }else {
            parent.left = new TreeNode(val);
        }
        return true;
    }

    /**
     * 二叉查找树的删除
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if(root == null) {
            return false;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null) {
            if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else if(cur.val > val) {
                parent = cur;
                cur = cur.left;
            }else {
                removeNode(parent,cur);
                return true;
            }
        }
        return false;
    }

    public void removeNode(TreeNode parent, TreeNode cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(parent.right == cur) {
                parent.right = cur.right;
            }else {
                parent.left = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                cur = cur.left;
            }else if(parent.left == cur) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while(target != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }

    /**
     * 二叉查找树的中序遍历
     * @param root
     */
    public void inorder(TreeNode root) {
        if(root == null) {
            return ;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    /**
     * 输出二叉查找树中的最大值
     * @param root
     */
    public void findMax(TreeNode root) {
        if(root == null) {
            System.out.println("二叉查找树为空");
            return ;
        }
        while(root.right != null) {
            root = root.right;
        }
        System.out.println("最大值为：" + root.val);
    }

    /**
     * 输出二叉查找树中的最小值
     * @param root
     */
    public void findMin(TreeNode root) {
        if(root == null) {
            System.out.println("二叉查找树为空");
            return ;
        }
        while(root.left != null) {
            root = root.left;
        }
        System.out.println("最小值为：" + root.val);
    }

}

