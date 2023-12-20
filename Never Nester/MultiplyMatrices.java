public class MultiplyMatrices{


	// Main Method
	public static void main(String[]args){

		int[][] mat1 = {{1,2}, {3,4}, {5,6}};
		int[][] mat2 = {{9,8,7}, {6,5,4}};

		multiplyMethod(mat1,mat2);

	}


	// Multiply Method
	public static void multiplyMethod (int[][] arr1,int[][] arr2) {
		
		System.out.println("Product:");
		
		if(arr1[0].length == arr2.length){
			compute(arr1, arr2);

		} else{
			System.out.println("Product is not possible");
		}

	}

	// Calculate Method
	private static void compute(int[][] arr1, int[][] arr2) {
		int[][] answ = new int[arr1.length][arr2[0].length]; 

		for(int row = 0; row < arr1.length; row ++) {
			for(int col=0;col<arr2[0].length;col++){ 
				computeDiagonal(arr1, arr2, answ, row, col);
			}
		}

		printArray(answ);
	}

	// Diagonal Method
	private static void computeDiagonal(int[][] arr1, int[][] arr2, int[][] answ, int row, int col) {
		int num=0;
		for(int colreal = 0; colreal < arr1[row].length; colreal++){
			num+= arr1[row][colreal] * arr2[colreal][col];
		}
		answ[row][col]=num;
	}

	// To String Method
	private static void printArray(int[][] answ) {
		for(int row = 0; row < answ.length; row ++) {
			for(int col = 0; col < answ[row].length; col++){
				System.out.print(answ[row][col]+" ");
			}
				System.out.println("");
		}
	}


 }