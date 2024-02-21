public class Main {

    public static void main(String[] args) {

        String word = "metropolitanism";
        BST<Character> bst = new BST<>();
        for (int i = 0; i < word.length(); i++)
            bst.add(word.charAt(i));
        bst.print();

        //! Testing size, inOrder, preOrder, postOrder, contains
        System.out.println("Size => " + bst.size());
        System.out.println("In Order => " + bst.inOrder());
        System.out.println("Pre Order => " + bst.preOrder());
        System.out.println("Post Order => " + bst.postOrder());
        System.out.println("Contains 'i' => " + bst.contains('i'));
        System.out.println("Contains 'u' => " + bst.contains('u'));

        //! Testing remove
        System.out.println("Size => " + bst.size());
        bst.remove('m');
        bst.print();
        System.out.println("Size => " + bst.size());

    }
}