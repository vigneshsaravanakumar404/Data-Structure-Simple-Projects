package Hashkeeping;

public class HKRunner{

	public static void main(String[]args){

		System.out.println("\nTEST SET 1 -> A few insertions, contains, remove \n-----------------------------");
		HashKeeper<String> hk = new HashKeeper<>(100);  // <-- Make this number large before you have a rehash
		hk.add("Apple");
		hk.add("Banana");
		System.out.println(hk);
		hk.add("Apple");
		System.out.println(hk);
		hk.add("Orange");
		hk.add("Pear");
		System.out.println(hk);
		hk.printBuckets();
		System.out.println("Contains 'Apple' --> "+hk.contains("Apple")); // true
		System.out.println("Contains 'Peach' --> "+hk.contains("Peach")); // false
		hk.remove("Apple");
		System.out.println("Removed 'Apple' ->"+hk);  //remove something that is there
		hk.remove("Grape");
		System.out.println("Removed 'Grape' ->"+hk);  // remove something that is NOT there


		System.out.println("\nTEST SET 2 -> Many Insertions\n-----------------------------");
		HashKeeper<String> hk2 = new HashKeeper<>(4);
		int i = 26;
		for (char c = 'A'; c <= 'Z'; c++){
			hk2.add(""+c+i);
			i--;

		}
		System.out.println(hk2);
		hk2.printBuckets();
		hk2.remove("D23");
		System.out.println(hk2);

	}
	
}
