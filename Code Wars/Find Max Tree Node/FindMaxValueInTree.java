public class FindMaxValueInTree {
    
    static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.value, Math.max(leftMax, rightMax));
    }

    class TreeNode {
        TreeNode  left;
        TreeNode  right;
        int value;
    }
}
