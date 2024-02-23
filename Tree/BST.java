public class BST<E extends Comparable<E>> {

    private TreeNode<E> root;
    private int size;

    public BST() {
        size = 0;
        root = null;
    }

    public void add(E val) {
        if (root == null) {
            root = new TreeNode(val);
            size++;
        } else {
            add(root, val);
        }
    }

    private void add(TreeNode<E> current, E val) {
        int compare = val.compareTo(current.val);
        if (compare == 0) {
            return;
        }
        if (compare < 0) {
            if (current.left == null) {
                current.left = new TreeNode(val);
                size++;
            } else {
                add(current.left, val);
            }
        } else {
            if (current.right == null) {
                current.right = new TreeNode(val);
                size++;
            } else {
                add(current.right, val);
            }
        }
    }

    // Size
    public int size() {
        return size;
    }   

    //TODO: Pre order
    public String preOrder() {
        return "[" + "]";
    }

    //TODO: Post order
    public String postOrder() {
        return "[" + "]";
    }

    // In Order
    public String inOrder() {
        String result = inOrder(root);
        result = result.substring(0, result.length() - 2);
        result = result.trim();
        return "[" + result + "]";
    }

    private String inOrder(TreeNode<E> current) {
        if (current == null) {
            return "";
        }
        return inOrder(current.left) + " " + current.val + ", " + inOrder(current.right);
    }

    // Contains
    public boolean contains(E val) {
        return containsRecursive(root, val);
    }

    private boolean containsRecursive(TreeNode<E> current, E val) {
        if (current == null) {
            return false;
        }
        int compare = val.compareTo(current.val);
        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return containsRecursive(current.left, val);
        } else {
            return containsRecursive(current.right, val);
        }
    }

    public void remove(E val){
        root = remove(root, val);
        size--;
    }

    private TreeNode<E> remove(TreeNode<E> current, E val){
        if(current == null){
            return null;
        }
        int compare = val.compareTo(current.val);
        if(compare < 0){
            current.left = remove(current.left, val);
        } else if(compare > 0){
            current.right = remove(current.right, val);
        } else {
            if(current.left == null){
                return current.right;
            } else if(current.right == null){
                return current.left;
            } else {
                current.val = findMin(current.right);
                current.right = remove(current.right, current.val);
            }
        }
        return current;
    }

    private E findMin(TreeNode<E> current){
        while(current.left != null){
            current = current.left;
        }
        return current.val;
    }

    /********** PRINT **********/
    public void print() {
        if (root == null)
            System.out.print("Empty Tree");
        print(root, 0, "");
        System.out.println();
    }

    private void print(TreeNode<E> curr, int depth, String s) {
        if (curr == null)
            return;
        for (int i = 1; i <= depth - 1; i++)
            System.out.print("|\t");
        if (depth == 0)
            System.out.println("[" + curr.val + "] <- root (L___ left, R___ right)");
        if (depth > 0) {
            System.out.print(s);
            System.out.println(curr.val);
        }
        print(curr.left, depth + 1, "L___"); 
        print(curr.right, depth + 1, "R___");
    }

    public void rotateRight(){
        if (root == null || root.left == null)
            return;
        TreeNode<E> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root = newRoot;
    }

    public void rotateLeft(){
        if (root == null || root.right == null)
            return;
        TreeNode<E> newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root = newRoot;
    }

    /********** END PRINT **********/

    class TreeNode<E extends Comparable<E>> {
        private E val;
        private TreeNode<E> left, right;

        private TreeNode(E val) {
            this.val = val;
            left = null;
            right = null;
        }

        public String toString() {
            return val.toString();
        }
    }
}
