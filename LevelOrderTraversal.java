// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal{

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base Condition to be checked.
        if(root == null) return result;
        
        // Initialize queue for performing the level order traversal.
        Queue<TreeNode> q = new LinkedList<>();
        
        // Add the root node into the queue to initialize the traversal.
        q.add(root);
        
        // Run the traversal until the queue is empty.
        // When the queue is empty, then we have traversed all the nodes in the list.
        while(!q.isEmpty()){
            
            // Since we need to distinguish each level elements from the other level we use size variable.
            int size = q.size();
            
            // Initializing a temporary list to store the elements associated to the current level.
            List<Integer> temp = new ArrayList<>();
            
            // Process all the elements associated to the current level.
            for(int i = 0; i < size; i++){
                
                // Popping the top associated in the current level.
                // Add this val to the temp list.
                TreeNode curr = q.poll();
                temp.add(curr.val);
                
                // Adding the left and right child's to the queue for next level processing.
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            // Once the current level is processed, add the temp List to the result list.
            result.add(temp);
        }
        
        return result;
    }

    public static void main(String[] args) {
        
    }
}