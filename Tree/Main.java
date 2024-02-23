public class Main {

  public static void main(String[] args) {

    System.out.println("\n********** SIZE / ADD ************");
    BST<String> tree = new BST<>();
    System.out.println("Size (0) = " + tree.size());
    tree.add("H");
    tree.add("A");

    System.out.println("Size (2) = " + tree.size());
    tree.add("A");
    System.out.println("Size Still (2) = " + tree.size());
    tree.add("R");
    tree.add("P");
    tree.add("S");
    System.out.println("Size (5) = " + tree.size());

    System.out.println("\n***** TRAVERSALS *******");
    System.out.println("PRE [H, A, R, P, S]:");
    System.out.println(tree.preOrder());
    System.out.println("IN [A, H, R, P, S] :");
    System.out.println(tree.inOrder());
    System.out.println("POST [A, P, S, R, H] :");
    System.out.println(tree.postOrder());

    System.out.println("\n******* aCONTAINS ********");
    System.out.println("contains(\"R\") [true] = " + tree.contains("R"));
    System.out.println("contains(\"Z\") [false] = " + tree.contains("Z"));

    System.out.println("\n********** ROTATION ************");
    System.out.println("ORIG:");
    tree.print();
    System.out.println("RIGHT:");
    tree.rotateRight();
    tree.print();
    System.out.println("BACK:");
    tree.rotateLeft();
    tree.print();
    System.out.println("LEFT:");
    tree.rotateLeft();
    tree.print();

    System.out.println("\n********** REMOVE ************");
    tree.remove("H");
    System.out.println("remove 2 child node 'H'");
    tree.print();
    tree.remove("P");
    System.out.println("remove 1 child branch 'P'");
    tree.print();
    tree.remove("A");
    System.out.println("remove leaf 'A'");
    tree.print();
    tree.remove("R");
    System.out.println("remove root 'R'");
    tree.print();
    System.out.println("New Size(1) = " + tree.size());

    BST<Integer> it = new BST<>();
    System.out.println("Random Size check");

    // Add 500 random nums to BST and remember size
    for (int i = 0; i < 500; i++)
      it.add((int) (Math.random() * 1000));
    int size = it.size();

    // Remove up to 300 random if present
    for (int i = 0; i < 300; i++) {
      int x = (int) (Math.random() * 1000);
      if (it.contains(x)) {
        it.remove(x);
        size--;
      }
    }
    System.out.println("Size matches = " + (size == it.size()));

  }
}