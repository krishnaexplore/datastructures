package org.ds.datastructures.matrix;

public class MatrixSample {

	public MatrixSample() {
	}

	public void displayMatrix(int mat[][]) {
		int m = mat[0].length;
		int n = mat[m-1].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void findOneIfMatrixisSortedLeftRight(int num, int[][] mat, int n) {
		
		int i = 0;
		int j = n - 1;
		
		while( i < n && j>=0) {
			if( mat[i][j] == num) {
				System.out.print("found at  "+i+", "+j);
				return;
			}else if(mat[i][j] > num) {
				j = j - 1;
			}else {
				i = i+1;
			}
		}
	}
	
	public void displayDiagnol(int mat[][]) {
		int m = mat[0].length;
		int n = mat[m-1].length;
		for(int i=0, j=0; i<m && j<n; i++,j++) {
			System.out.print( mat[i][j]);
		}
	}
	
	public static void main(String[] args) {
		MatrixSample s = new MatrixSample();
		int mat1[][] = {
						{1,2,3},
						{4,5,6},
						{7,8,9}
					   };
		s.displayMatrix(mat1);
		s.displayDiagnol(mat1);
		
		int mat[][] = { {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50} 
                       };
		s.findOneIfMatrixisSortedLeftRight(39,mat,4);
	}
}
