public class RBT<E>
{
  private TreeNode<E> root;
  private int size;

  public RBT(){
    root=null;
    size=0;
  }

  public void add(E value){
    root = add(root, value);
    size++;
  }

  public TreeNode<E> add(TreeNode<E> curr, E value)
  {
    if (curr == null)
      return new TreeNode<E>(value);

    if (Math.random()<0.5)
      curr.left = add(curr.left,value);

    else
      curr.right = add(curr.right,value);

    return curr;
  }

  public String findPath(E val){
    return "Stub Method -> Write some code to locate "+val;
  }

  public int size(){
    return size;
  }

  /********** PRINT **********/
  public void print(){
    if (root == null)
      System.out.print("Empty Tree");
    print(root, 0, "");
    System.out.println();
  }

  private void print(TreeNode<E> curr, int depth, String s){
		if (curr == null)
				return;
		for (int i = 1; i <= depth - 1; i++)
				System.out.print("|\t");
		if (depth == 0)
				System.out.println("[" + curr.value + "] <- root (L___ left, R___ right)");
		if (depth > 0)
		{
				System.out.print(s);
					System.out.println(curr.value);
			}
		print(curr.left, depth + 1, "L___"); // indicates left or "less than" side
		print(curr.right, depth + 1, "R___");  // indicate right or "greater than" side
  }
    /********** END PRINT **********/



  private class TreeNode<E>
  {
    private E value;
    private TreeNode<E> right;
    private TreeNode<E> left;

    public TreeNode(E value){
      this.value=value;
      right=null;
      left=null;
    }

    public String toString(){
       return ""+value;
    }
  }
  public static void main(String[]args){
		int[] vals = {18,22,3,7,5,1,6,10,9,8,11,12,13,14,15,16};
		RBT<Integer> tree = new RBT<>();
		for (int i = 0 ; i < vals.length; i++)
			tree.add(vals[i]);
		tree.print();
		System.out.println("Find 13: "+tree.findPath(13));
		System.out.println("Find 20: "+tree.findPath(20));
		System.out.println("Find 16: "+tree.findPath(16));
		System.out.println("Find 7: "+tree.findPath(7));
	}

}
