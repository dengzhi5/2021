package leetCode;

import java.util.concurrent.CompletableFuture;

public class BinaryTreeTopic {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        //平衡二叉树
        //isBalanced(treeNode);

        //翻转二叉树
        invertTree(treeNode);


    }

    static TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}