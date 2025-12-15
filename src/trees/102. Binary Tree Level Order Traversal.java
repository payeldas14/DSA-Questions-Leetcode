//102. Binary Tree Level Order Traversal - https://leetcode.com/problems/binary-tree-level-order-traversal/
//BFS traversal using Queue
//Time Complexity: O(n) and Space Complexity: O(n) because queue is storing n elements
package trees;
import java.util.*;

class solution{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> nodes = new ArrayList<>();
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                nodes.add(node.val);

                if(node.left != null){queue.offer(node.left);}
                if(node.right != null){queue.offer(node.right);}
            }

            result.add(nodes);
        }

        return result;
    }
    
}
