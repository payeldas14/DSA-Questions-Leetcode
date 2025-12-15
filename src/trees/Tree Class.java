package trees;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


//104. Maximum Depth of Binary Tree - https://leetcode.com/problems/maximum-depth-of-binary-tree/
// time = O(n) and space = O(n)
class solution{
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }
}

//100. Same Tree - https://leetcode.com/problems/same-tree/
// time = O(n) and space = O(n) - worst, O(logn) - avg
class solution1{
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p != q){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//101. Symmetric Tree - https://leetcode.com/problems/symmetric-tree/
// time = O(n) and space = O(n) - worst, O(logn) - avg height of tree
class solution2{
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}

//226. Invert Binary Tree - https://leetcode.com/problems/invert-binary-tree/
// time = O(n) and space = O(logn) avg case - height of tree or O(n) worst case
class solution3{
    public TreeNode invertTree(TreeNode root){
        if(root == null) return null;

        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);

        root.left = rightTree;
        root.right = leftTree;

        return root;
    }
}