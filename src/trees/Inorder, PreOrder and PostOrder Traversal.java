//Inorder, PreOrder and PostOrder Traversal - https://leetcode.com/problems/binary-tree-inorder-traversal/
//Time Complexity: O(n) and Space Complexity: O(n)
package trees;
import java.util.*;

class TreeTraversal{
    
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void inOrder(TreeNode root){
        //left -> root -> right

        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void preOrder(TreeNode root){
        //root -> left -> right

        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);      
    }

    public static void postOrder(TreeNode root){
        // left -> right -> root

        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Inorder Traversal: ");
        inOrder(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        preOrder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        postOrder(root);
        System.out.println();
    }
}

//OUTPUT
//Inorder Traversal: 4 2 5 1 3
//Preorder Traversal: 1 2 4 5 3
//Postorder Traversal: 4 5 2 3 1

//Tree Structure
//        1
//       / \
//      2   3
//     / \
//    4   5