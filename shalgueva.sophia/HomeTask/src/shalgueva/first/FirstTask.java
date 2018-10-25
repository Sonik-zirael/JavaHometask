package shalgueva.first;

import java.util.Scanner;

public class FirstTask {
	
	public static void draw(int size) {
		int [][] matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if ((i == j) || (j == size - i - 1)) {
					matrix [i][j] = i + 1;
				} else {
					matrix [i] [j] = 0;
				}
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("Enter size of matrix: ");
			Scanner scan = new Scanner(System.in);
			int sizeMatrix = scan.nextInt();
			scan.close();
			if (sizeMatrix > 1) {
				draw(sizeMatrix);
			} else if (sizeMatrix == 1) {
				System.out.println("1");
			} else {
				throw new IllegalArgumentException ("Size must be positive");
			}		
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
