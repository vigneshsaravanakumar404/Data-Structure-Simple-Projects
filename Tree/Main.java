public class Main {

    public static void main(String[] args) {

        String word = "metropolitanism";
        BST<Character> bst = new BST<>();
        for (int i = 0; i < word.length(); i++)
            bst.add(word.charAt(i));
        bst.print();

        // //! Testing size, inOrder, preOrder, postOrder, contains
        // System.out.println("Size => " + bst.size());
        // System.out.println("In Order => " + bst.inOrder());
        // System.out.println("Pre Order => " + bst.preOrder());
        // System.out.println("Post Order => " + bst.postOrder());
        // System.out.println("Contains 'i' => " + bst.contains('i'));
        // System.out.println("Contains 'u' => " + bst.contains('u'));

        // //! Testing remove
        // System.out.println("Size => " + bst.size());
        // bst.remove('m');
        // bst.print();
        // System.out.println("Size => " + bst.size());

        // Rotation
        BST<Integer> tree = new BST<>();
        int[] nums = {45,13,6,77,23,5,54,24,19,99,24,72,17,18};
        for (int i: nums)
          tree.add(i);
    
        tree.print();
        tree.rotateRight();
        tree.print();
    



    }
}