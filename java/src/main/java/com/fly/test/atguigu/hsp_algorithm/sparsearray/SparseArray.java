package com.fly.test.atguigu.hsp_algorithm.sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		// 创建一个原始的二维数组 11 * 11，0-表示没有棋子，1-表示黑子，2-表示蓝子
		int chessArr[][] = new int[11][11];
		chessArr[1][2] = 1;
		chessArr[2][3] = 2;
		chessArr[4][5] = 2;
		System.out.println("原始的二维数组----------------------------------------------------------------");
		for (int[] row : chessArr) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		System.out.println();
		
		int[][] sparseArr = twoLevelArray2SparseArray(chessArr);
		System.out.println("得到稀疏数组为----------------------------------------------------------------");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
		System.out.println();
		
		int[][] twoLevelArray = sparseArray2TwoLevelArray(sparseArr);
		System.out.println("恢复后的二维数组---------------------------------------------------------------");
		for (int[] row : twoLevelArray) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}
	
	public static int[][] twoLevelArray2SparseArray(int[][] twoLevelArray) {
		// 1. 先遍历二维数组 得到非0数据的个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (twoLevelArray[i][j] != 0) {
					sum++;
				}
			}
		}

		// 2. 创建对应的稀疏数组
		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = 11;		// 二维数组的行数
		sparseArr[0][1] = 11;		// 二维数组的列数
		sparseArr[0][2] = sum;		// 二维数组中有效值的个数
		
		// 3. 遍历二维数组，将非0的值存放到 sparseArr中
		int count = 0; //count 用于记录是第几个非0数据
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (twoLevelArray[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = twoLevelArray[i][j];
				}
			}
		}
		
		return sparseArr;
	}
	
	public static int[][] sparseArray2TwoLevelArray(int[][] sparseArr) {
		//1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
		int twoLevelArray[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		//2. 再读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
		for(int i = 1; i < sparseArr.length; i++) {
			twoLevelArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		return twoLevelArray;
	}
	
}