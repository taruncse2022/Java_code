import java.util.*;
public class TreeNode {
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
 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            TreeNode rightmostNode = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                rightmostNode = curr; 

                
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            
            rightView.add(rightmostNode.val);
        }

        return rightView;
    }
}
