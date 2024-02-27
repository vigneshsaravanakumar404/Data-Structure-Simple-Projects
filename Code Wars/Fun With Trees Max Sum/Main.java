public class Main {

    // Find max sum from root to a leaf
    static int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.value;
        } else if (root.left == null) {
            return root.value + maxSum(root.right);
        } else if (root.right == null) {
            return root.value + maxSum(root.left);
        }
        return root.value + Math.max(maxSum(root.left), maxSum(root.right));
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int value) {
            this.value = value;
        }
    }
}
